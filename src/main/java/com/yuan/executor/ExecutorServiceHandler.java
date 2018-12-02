package com.yuan.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * FileName: ExecutorService
 * Author:   yhl
 * Date:     2018/12/2 11:54
 * Description: ${DESCRIPTION}
 */
public interface ExecutorServiceHandler {

    /**
     * 初始化线程池
     * @param poolSize
     * @param isSingle
     */
    void initPool(int poolSize,boolean isSingle);

    /**
     * 执行线程方法
     * @param callable
     * @param <T>
     * @return
     */
    <T>Future handle(Callable<T> callable);

    /**
     * 关闭线程池
     */
    void shotDown();

}
