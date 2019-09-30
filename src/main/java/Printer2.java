/**
 * Printer2.java   2019年9月27日 下午3:25:28 by PANGJIANLIN 
 *
 * Copyright (c) 2010 - 2019 jianlin.Pang. All rights reserved.
 * 
 */
package main.java;

public class Printer2 implements Runnable {

    private static final Object LOCK = new Object();

    /**
     * 当前即将打印的数字
     */
    private static int current = 0;

    /**
     * 当前线程编号，从0开始
     */
    private int threadNo;

    /**
     * 线程数量
     */
    private int threadCount;

    /**
     * 打印的最大数值
     */
    private int max;

    public Printer2(int threadNo, int threadCount, int max) {
        this.threadNo = threadNo;
        this.threadCount = threadCount;
        this.max = max;
    }

    @Override
    public void run() {
        synchronized (LOCK) {
            while (current <= max) {
                if (current % threadCount == threadNo) {
                    System.out.println("thread-" + threadNo + " : " + current);
                    current++;
                    // 唤醒其他wait线程
                    LOCK.notifyAll();
                } else {
                    try {
                        // 如果不是，则当前线程进入wait
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int threadCount = 3;
        int max = 10;
        for (int i = 0; i < threadCount; i++) {
            new Thread(new Printer2(i, threadCount, max)).start();
        }
    }

}
