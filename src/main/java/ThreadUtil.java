/**
 * ThreadUtil.java   2019年4月16日 下午5:11:44 by PANGJIANLIN 
 *
 * Copyright (c) 2010 - 2019 jianlin.Pang. All rights reserved.
 * 
 */
package main.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ThreadUtil {
    static ThreadFactory aaFactory = Executors.defaultThreadFactory();
    public static final ExecutorService executor = Executors.newFixedThreadPool(8, new ThreadFactory(){
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = aaFactory.newThread(r);
            //thread.setDaemon(true);
            return thread;
        }
    });

}
