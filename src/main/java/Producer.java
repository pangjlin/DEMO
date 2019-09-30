/**
 * Producer.java   2018年6月19日 上午11:06:26 by PANGJIANLIN 
 *
 * Copyright (c) 2010 - 2018 jianlin.Pang. All rights reserved.
 * 
 */
package main.java;

import java.util.Queue;

public class Producer extends Thread {

    private static final int MAX_QUEUE_SIZE = 5;
    @SuppressWarnings("rawtypes")
    private final Queue sharedQueue;

    @SuppressWarnings("rawtypes")
    public Producer(Queue sharedQueue) {
        super();
        this.sharedQueue = sharedQueue;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            synchronized (sharedQueue) {
                while (sharedQueue.size() >= MAX_QUEUE_SIZE) {
                    System.out.println("队列满了，等待消费");
                    try {
                        sharedQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                sharedQueue.add(i);
                System.out.println("进行生产 : " + i);
                sharedQueue.notify();
            }
        }
    }

}
