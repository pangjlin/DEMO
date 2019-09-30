/**
 * RemoveNode.java   2018年9月4日 下午12:33:05 by PANGJIANLIN 
 *
 * Copyright (c) 2010 - 2018 jianlin.Pang. All rights reserved.
 * 
 */
package main.java;



public class RemoveNode {

    public class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static Node removeNthFromEnd(Node head, int n) {

        Node preNode = head;
        Node curNode = head;

        for (int i = 0; i < n; i++) {
            curNode = curNode.next;
        }

        if (curNode == null) {
            return preNode.next;
        }

        while (curNode.next != null) {
            preNode = preNode.next;
            curNode = curNode.next;
        }

        preNode.next = preNode.next.next;

        return head;
    }

    public static void main(String[] args) {
        RemoveNode re = new RemoveNode();
        Node head = re.new Node(0);
        Node node1 = re.new Node(1);
        Node node2 = re.new Node(2);
        Node node3 = re.new Node(3);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        Node node = removeNthFromEnd(head, 2);
        System.out.println(node);
    }

}
