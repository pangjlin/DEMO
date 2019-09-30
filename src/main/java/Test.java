/**
 * Test.java   2018��3��13�� ����3:10:11 by PANGJIANLIN 
 *
 * Copyright (c) 2010 - 2018 jianlin.Pang. All rights reserved.
 * 
 */
package main.java;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        final ArrayList<String> list= new ArrayList<String>();
        for (int i = 0; i < 3; i++) {
            list.add("111");
        }
        System.out.println(list);
        A a = new A(list);
        System.out.println(a);
    }
}