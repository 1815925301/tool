package com.yuan.tool.thread;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.concurrent.*;

import static java.lang.Thread.sleep;

/**
 * FileName: FutureModelTest
 * Author:   yhl
 * Date:     2018/12/2 12:14
 * Description: ${DESCRIPTION}
 */
public class FutureModelTest {

    private static Logger logger = LogManager.getLogger(FutureModelTest.class);

    @Test
   public void test1() throws InterruptedException {
        testFuture();
    }
    /**
     * 区别： CallAble  可以有返回值  可以抛出受检异常
     * Runnable  没有返回值   无法抛出受检异常但可捕获线程中发生的异常。
     * 者都可通过对future.get()进行try cathch捕获异常
     */
    private static void testFuture() throws InterruptedException {
        MyCallable myCallable = new MyCallable();
        MyRunnable myRunnable = new MyRunnable();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<?> future = executorService.submit(myRunnable);
        sleep(2000);
        try {
            //String data = future.get(2000, TimeUnit.MILLISECONDS);//可以指定超时时间
            Object data = future.get();//当执行Runnable的时候，这里返回的为nul。此时如果有run方法体中有异常异常抛出，可以在此捕获到,虽然Run方法没有显示的抛出受检异常。
            logger.error(data + "---" + data.getClass().toString());
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        } catch (ExecutionException e) {
            logger.error(e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        executorService.shutdown();
    }
    static class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            sleep(500);
            logger.error("I am Callable...");
              int num = 10/0;
              throw  new RuntimeException("异常");
            //return "hello";
        }
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {//不支持返回值，无法对线程捕获异常。
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.error("I am Runnable...");
            try {
                int num = 10/0;
            }catch (Exception e){
                logger.error("1111");
            }
        }
    }

}
