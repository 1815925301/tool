package com.yuan.executor;

import com.yuan.aspect.ExecutorAspect;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.*;

/**
 * FileName: AbstractExecutor
 * Author:   yhl
 * Date:     2018/12/2 12:07
 * Description: ${DESCRIPTION}
 */
public class AbstractExecutor implements ExecutorServiceHandler {
    private static Logger logger = LogManager.getLogger(AbstractExecutor.class);

    /**
     * 注意ExecutorService和ThreadPoolExecutor的关系。。。
     */
   // private  ExecutorService executorService;
    private ThreadPoolExecutor threadPoolExecutor;
    private static ThreadLocal<ThreadPoolExecutor> threadPoolExecutor_ = new ThreadLocal<ThreadPoolExecutor>();

    @Override
    public void initPool(int poolSize, boolean isSingle) {
        if(isSingle){
            //executorService = ThreadPoolSingle.getSingleExecutor();
            threadPoolExecutor = ThreadPoolSingle.getSingleExecutor();
        }else {
           // executorService = Executors.newFixedThreadPool(poolSize);
            if(threadPoolExecutor_.get() == null){
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)Executors.newFixedThreadPool(poolSize);
                threadPoolExecutor_.set(threadPoolExecutor);
            }
            //threadPoolExecutor =  threadPoolExecutor_.get();
            logger.error("AbstractExecutor----poolsize:{}",poolSize);
            threadPoolExecutor = (ThreadPoolExecutor)Executors.newFixedThreadPool(poolSize);
        }
    }

    @Override
    public <T> Future handle(Callable<T> callable) {
        Future<T> submitResult = threadPoolExecutor.submit(callable);
        /*System.out.println("线程池中现在的线程数目是："+threadPoolExecutor.getPoolSize()+",  队列中正在等待执行的任务数量为："+
                threadPoolExecutor.getQueue().size());*/
        return submitResult;
    }

    @Override
    public void shotDown() {
        //executorService.isShutdown();
        threadPoolExecutor.shutdown();
    }
}
