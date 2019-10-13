package com.yuan.tool.thread;

import com.yuan.threadPool.RejectedPolicyHandler;
import com.yuan.threadPool.ThreadFactoryHandler;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * FileName: RejectThreadPoolDemo
 * Author:   yhl
 * Date:     2018/12/16 20:42
 * Description: ${DESCRIPTION}
 */
public class RejectThreadPoolDemo {

    public static class MyTask implements Runnable {
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + ":Thread Id:" + Thread.currentThread().getId());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testRejectPolicy() throws InterruptedException {
        MyTask my = new MyTask();
        ExecutorService es = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(10), Executors.defaultThreadFactory(), new RejectedPolicyHandler());

        ExecutorService es2 = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(10));
        for (int i = 0; i < 100; i++) {
            es.submit(my);
            Thread.sleep(10);
        }
        //es.shutdown();
    }
    @Test
    public void testThreadFactory() throws InterruptedException {
        MyTask my = new MyTask();
        ExecutorService es = new ThreadPoolExecutor(5, 20, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(10), new ThreadFactoryHandler(), new RejectedPolicyHandler());
        for (int i = 0; i < 20; i++) {
            es.submit(my);
        }
        Thread.sleep(2000);
    }

    /**
     * 守护线程在main方式可以验证
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        MyTask my = new MyTask();
        ExecutorService es = new ThreadPoolExecutor(5, 20, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(10), new ThreadFactoryHandler(), new RejectedPolicyHandler());
        for (int i = 0; i < 20; i++) {
            es.submit(my);
        }
//        es.shutdown();
        Thread.sleep(2000);
    }

}
