package com.yuan.aspect;

import com.yuan.annotation.Executor;
import com.yuan.executor.AbstractExecutor;
import com.yuan.utils.JsonUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.jsoup.select.Evaluator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * FileName: ExecutorAspect
 * Author:   yhl
 * Date:     2018/12/2 14:28
 * Description: ${DESCRIPTION}
 */

/**
 * 总结两点：
 * 1.执行顺序(没有异常)：around（processed方法执行之前）-before（processed方法执行之前）-around（processed方法执行之后）-after-AfterReturning
 * 异常：around-before-after-throw。
 * 2.关于returning返回值，around可以对返回值进行修改返回(如果在此处修改成功，看上边的流程顺序，那么到AfterReturning取的返回值将是在around中修改后的结果)，
 *   但是到AfterReturning方法之后，返回值已经不能修改，结果是什么就返回什么。
 * 3.一般使用@around结合throw注解就可以满足日常需求。。。
 * 4.注意ProceedingJoinPoint和JoinPoint的区别，子类和父类的关系，前者只使用于@around注解中.
 */

/**
 * 环绕通知=前置+目标方法执行+后置通知，proceed方法就是用于启动目标方法执行的。
 *
 * 环绕通知 ProceedingJoinPoint 执行proceed方法的作用是让目标方法执行，这也是环绕通知和前置、后置通知方法的一个最大区别。
 *
 * Proceedingjoinpoint 继承了 JoinPoint 。是在JoinPoint的基础上暴露出 proceed 这个方法。proceed很重要，这个是aop代理链执行的方法。
 */
@Aspect
@Component
public class ExecutorAspect extends AbstractExecutor implements BeanFactoryAware {
    private static Logger logger = LogManager.getLogger(ExecutorAspect.class);

    private BeanFactory beanFactory;

    @Pointcut("@annotation(com.yuan.annotation.Executor)")
    public void executorAspect() {
    }

    @Before("executorAspect()")
    public void before(JoinPoint joinPoint) {
        System.out.println("前置通知============" + joinPoint);
        // Map<String,String> map = (Map<String, String>) joinPoint.getArgs()[0];
        //super.initPool(map.size(),false);
    }

    //@AfterReturning(value = "executorAspect()",returning="resultMap")
    public Object afterReturing(JoinPoint joinPoint, Object resultMap) throws Exception {
        System.out.println("后置通知============" + resultMap);
        Signature signature = joinPoint.getSignature();
        MethodSignature ms = (MethodSignature) signature;
        //Method method = ms.getMethod();
        Object target = joinPoint.getTarget();
        Method method = target.getClass().getMethod(ms.getName(), ms.getParameterTypes());
        /**
         *          msig = (MethodSignature) sig;
         *         Object target = pjp.getTarget();
         *         Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
         */
        String taskClassName = method.getAnnotation(Executor.class).taskClassName();
        boolean single = method.getAnnotation(Executor.class).isSingle();
        Map<String, String> map = (Map) joinPoint.getArgs()[0];
        //初始化线程池
        // super.initPool(map.size(),single);
        Class beanClass = Class.forName(taskClassName);
        Object beanTask = beanFactory.getBean(beanClass);
        List<Map<String, String>> futureMap = new LinkedList<>();
        try {
            for (String key : map.keySet()) {
                Field keyId = beanClass.getDeclaredField("id");
                keyId.setAccessible(true);
                keyId.set(beanTask, key);
                Future handle = super.handle((Callable) beanTask);
                Map<String, String> result1 = (Map<String, String>) handle.get();
                //logger.error("result:{}", JsonUtil.toJson(result1));
                futureMap.add(result1);
            }
            resultMap = futureMap;//测试返回值
        } catch (Exception e) {
            logger.error("executorAspect-----exception:{}", e);
        } finally {
            if (!single) {
                super.shotDown();
            }
        }
        return resultMap;
    }

    @Around(value="executorAspect()")
    public List<Map<String, String>> handle(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around=========");
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //Method method = signature.getMethod();
        Object proceed = null;
        Object target = joinPoint.getTarget();
        Method method = target.getClass().getMethod(signature.getName(), signature.getParameterTypes());
        /**
         *          msig = (MethodSignature) sig;
         *         Object target = pjp.getTarget();
         *         Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
         */
        String taskClassName = method.getAnnotation(Executor.class).taskClassName();
        boolean single = method.getAnnotation(Executor.class).isSingle();
        Map<String, String> map = (Map) joinPoint.getArgs()[0];
        //初始化线程池
        super.initPool(map.size(), single);
        Class beanClass = Class.forName(taskClassName);
        Object beanTask = beanFactory.getBean(beanClass);
        List<Map<String, String>> futureMap = new LinkedList<>();
        try {
            for (String key : map.keySet()) {
                Field keyId = beanClass.getDeclaredField("id");
                keyId.setAccessible(true);
                keyId.set(beanTask, key);
                Future handle = super.handle((Callable) beanTask);
                Map<String, String> result = (Map<String, String>) handle.get();
                logger.error("result:{}", JsonUtil.toJson(result));
                futureMap.add(result);
            }
            proceed = joinPoint.proceed();
            proceed = futureMap;//重新赋值返回结果（环绕通知。类似于后置通知AfterReturning）
            System.out.println("around--end----");
        } catch (Exception e) {
            logger.error("executorAspect-----exception:{}", e);
            throw new RuntimeException(e);
        } finally {
            if (!single) {
                super.shotDown();
            }
        }
        logger.error("executorAspect------------end-----");
        return (List<Map<String, String>>) proceed;
    }

    @AfterThrowing(value = "executorAspect()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint,Throwable e) {
        System.out.println("异常抛出通知=========" + e.getMessage());
        try {
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            System.out.println("切点：" + joinPoint);
            System.out.println("类名：" + className);
            System.out.println("方法名：" + methodName);
            Object[] arguments = joinPoint.getArgs(); // 参数
            String param = className + "." + methodName + ":";
            for (int i = 0; i < arguments.length; i++) {
                if (arguments[i] != null && !"".equals(arguments[i])
                        && !"null".equals(arguments[i])) {
                    param += "参数[" + i + "]:" + arguments[i].toString();
                }
            }
            System.out.printf("类名:"+joinPoint.getTarget().getClass().getName()+"    方法名:"+joinPoint.getSignature().getName(),e);
            System.out.println("param:" + param);
            System.out.println("=====异常通知开始=====");
            System.out.println("异常代码:" + e.getClass().getName());
            System.out.println("异常信息:" + e.getMessage());
            System.out.println("异常方法:"
                    + (joinPoint.getTarget().getClass().getName() + "."
                    + joinPoint.getSignature().getName() + "()") + "."
                    + methodName);
        }catch (Exception e1){
            e1.printStackTrace();
        }
    }

    @After(value = "executorAspect()")
    public void after() {
        System.out.println("最终通知===========");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
