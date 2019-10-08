/**
 * ProducerConsumerTest.java   2018年6月19日 上午10:52:42 by PANGJIANLIN 
 *
 * Copyright (c) 2010 - 2018 jianlin.Pang. All rights reserved.
 * 
 */
package main.java.producerConsunerDemo;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerTest {
    
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static void main(String args[]) {
        final Queue<Integer> sharedQueue = new LinkedList();
        Thread producer = new Producer(sharedQueue);
        Thread consumer = new Consumer(sharedQueue);
        producer.start();
        consumer.start();
    }
}
