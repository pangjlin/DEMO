/**
 * bucketDemo.java   2018年7月24日 下午3:49:28 by PANGJIANLIN 
 *
 * Copyright (c) 2010 - 2018 jianlin.Pang. All rights reserved.
 * 
 */
package main.java;

public class BucketDemo {

    private static long time = System.currentTimeMillis();
    private static int water = 0;
    private static int size = 10;
    private static int rate = 3;

    public static boolean grant() {
        long now = System.currentTimeMillis();
        int out = (int) ((now - time) / 700 * rate);
        water = Math.max(0, water - out);
        time = now;
        if ((water + 1) < size) {
            ++water;
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable(){
                @Override
                public void run() {
                    if (grant()) {
                        System.out.println("true");
                    } else {
                        System.out.println("false");
                    }
                }
            }).start();
        }
    }

}
