package com.yuan.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * FileName: ThreadPoolSingle
 * Author:   yhl
 * Date:     2018/12/2 12:11
 * Description: ${DESCRIPTION}
 */
public class ThreadPoolSingle {

    private static ThreadLocal<ThreadPoolExecutor> threadPoolExecutor_ = new ThreadLocal<ThreadPoolExecutor>();

    static {
        if(threadPoolExecutor_.get() == null){
            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)Executors.newFixedThreadPool(5);
            threadPoolExecutor_.set(threadPoolExecutor);
        }
    }
    public ThreadPoolSingle(){};

    public static ThreadPoolExecutor getSingleExecutor(){
       return threadPoolExecutor_.get();
    }
}
