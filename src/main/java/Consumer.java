/**
 * Consumer.java   2018年6月19日 上午11:07:00 by PANGJIANLIN 
 *
 * Copyright (c) 2010 - 2018 jianlin.Pang. All rights reserved.
 * 
 */
package main.java;

import java.util.Queue;

public class Consumer extends Thread {

    @SuppressWarnings("rawtypes")
    private final Queue sharedQueue;

    @SuppressWarnings("rawtypes")
    public Consumer(Queue sharedQueue) {
        super();
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (sharedQueue) {
                while (sharedQueue.size() == 0) {
                    try {
                        System.out.println("队列空了，等待生产");
                        sharedQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int number = Integer.valueOf(sharedQueue.poll().toString());
                System.out.println("进行消费 : " + number);
                sharedQueue.notify();
            }
        }
    }

}
