package com.yuan.threadPool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * FileName: RejectedPolicyHandler
 * Author:   yhl
 * Date:     2018/12/16 21:54
 * Description: ${DESCRIPTION}
 */
public class RejectedPolicyHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println(r.toString()+" is discard");
    }
}
