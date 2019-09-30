/**
 * NormalThread.java   2019年9月26日 下午4:34:13 by PANGJIANLIN 
 *
 * Copyright (c) 2010 - 2019 jianlin.Pang. All rights reserved.
 * 
 */
package main.java.callable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NormalThread {
    
    public static void main(String[] args) throws InterruptedException {
        System.out.println("----程序开始运行----");
        Date date1 = new Date();
        ArrayList<Object> res = new ArrayList<Object>();
        res.addAll(test1());
        res.addAll(test2());
        System.out.println(res);
        Date date2 = new Date();
        System.out.println("----程序结束运行----，程序运行时间【" + (date2.getTime() - date1.getTime()) + "毫秒】");
    }
    
    public static List<Integer> test1() throws InterruptedException {
        System.out.println(">>>任务1启动");
        Date dateTmp1 = new Date();
        Thread.sleep(1000);
        Date dateTmp2 = new Date();
        long time = dateTmp2.getTime() - dateTmp1.getTime();
        System.out.println(">>>任务1终止,耗时：" + time + "ms");
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        return list;
    }

    public static List<String> test2() throws InterruptedException {
        System.out.println(">>>任务2启动");
        Date dateTmp1 = new Date();
        Thread.sleep(2000);
        Date dateTmp2 = new Date();
        long time = dateTmp2.getTime() - dateTmp1.getTime();
        System.out.println(">>>任务2终止,耗时：" + time + "ms");
        ArrayList<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        return list;
    }

}
