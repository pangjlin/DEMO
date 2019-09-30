/**
 * CallableThread.java   2018年9月4日 上午11:04:21 by PANGJIANLIN 
 *
 * Copyright (c) 2010 - 2018 jianlin.Pang. All rights reserved.
 * 
 */
package main.java.callable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableThread {

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("----程序开始运行----");
        Date date1 = new Date();
        int taskSize = 3;
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
        List<Future> list = new ArrayList<Future>();
        //        for (int i = 0; i < taskSize; i++) {
        //            Callable c = new MyCallable();
        //            // 执行任务并获取Future对象  
        //            Future f = pool.submit(c);
        //            list.add(f);
        //            // System.out.println(">>>" + f.get().toString());  
        //            Callable c2 = new YourCallable();
        //            Future f2 = pool.submit(c2);
        //            list.add(f2);
        //        }
        //Callable c = new MyCallable();
        Callable<List<Integer>> c = new Callable<List<Integer>>(){
            @Override
            public List<Integer> call() throws Exception {
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
        };
        Future f = pool.submit(c);
        //Callable c2 = new YourCallable();
        Callable<List<String>> c2 = new Callable<List<String>>(){
            @Override
            public List<String> call() throws Exception {
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
        };
        Future f2 = pool.submit(c2);

        list.add(f);
        list.add(f2);
        pool.shutdown();
        ArrayList<Object> res = new ArrayList<Object>();
        for (Future futureRes : list) {
            res.addAll((ArrayList<Object>) futureRes.get());
        }
        System.out.println(res);
        Date date2 = new Date();
        System.out.println("----程序结束运行----，程序运行时间【" + (date2.getTime() - date1.getTime()) + "毫秒】");
    }

}
