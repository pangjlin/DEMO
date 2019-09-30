/**
 * YourCallable.java   2019年9月26日 下午4:25:58 by PANGJIANLIN 
 *
 * Copyright (c) 2010 - 2019 jianlin.Pang. All rights reserved.
 * 
 */
package main.java.callable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

public class YourCallable implements Callable<Object> {

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

}
