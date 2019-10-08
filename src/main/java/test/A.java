/**
 * A.java   2019年8月19日 下午1:26:34 by PANGJIANLIN 
 *
 * Copyright (c) 2010 - 2019 jianlin.Pang. All rights reserved.
 * 
 */
package main.java.test;

import java.io.Serializable;
import java.util.ArrayList;

public class A implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -478632769663679517L;
    private ArrayList<String> list;

    public A(ArrayList<String> list) {
        this.list = list;

    }

    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "A [list=" + list + "]";
    }

}
