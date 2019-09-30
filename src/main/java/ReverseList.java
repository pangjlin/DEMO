/**
 * ReverseList.java   2018年4月26日 下午2:50:57 by PANGJIANLIN 
 *
 * Copyright (c) 2010 - 2018 jianlin.Pang. All rights reserved.
 * 
 */
package main.java;

public class ReverseList {

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

    public static void main(String[] args) {
        ReverseList re = new ReverseList();
        Node head = re.new Node(0);
        Node node1 = re.new Node(1);
        Node node2 = re.new Node(2);
        Node node3 = re.new Node(3);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);

        // 打印反转前的链表  
        Node h = head;
        while (null != h) {
            System.out.print(h.getData() + " ");
            h = h.getNext();
        }
        // 调用反转方法  
        head = reverse2(head);

        System.out.println("\n**************************");
        // 打印反转后的结果  
        while (null != head) {
            System.out.print(head.getData() + " ");
            head = head.getNext();
        }
    }

    public static Node reverse1(Node head) {
        // head看作是前一结点，head.getNext()是当前结点，reHead是反转后新链表的头结点
        if (null == head || null == head.getNext()) {
            return head;
        }
        Node reHead = reverse1(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return reHead;
    }

    public static Node reverse2(Node head) {
        if (null == head) {
            return head;
        }
        Node pre = head;
        Node cur = head.getNext();
        Node tmp = null;
        while (null != cur) {
            tmp = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = tmp;
        }
        head.setNext(null);
        return pre;
    }

    public static void main2(String[] args) {
        ReverseList re = new ReverseList();
        Node n1 = re.new Node(1);
        Node n2 = re.new Node(2);
        Node n3 = re.new Node(3);
        Node n4 = re.new Node(4);
        Node n5 = re.new Node(5);
        Node n6 = re.new Node(6);
        Node n7 = re.new Node(7);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n4;
        System.out.println(hasLoop(n1));
        System.out.println(getLoopNode(n1).getData());
    }

    public static boolean hasLoop(Node head) {
        Node p1 = head;
        Node p2 = head;
        while (null != p2 && null != p2.getNext()) {
            p1 = p1.getNext();
            p2 = p2.getNext().getNext();
            if (null == p2) {
                return false;
            }
            if (p1.getData() == p2.getData()) {
                return true;
            }
        }
        return false;
    }

    public static Node getLoopNode(Node head) {
        Node p1 = head;
        Node p2 = head;
        while (null != p2 && null != p2.getNext()) {
            p1 = p1.getNext();
            p2 = p2.getNext().getNext();
            if (null == p2) {
                return null;
            }
            if (p1.getData() == p2.getData()) {
                p2 = head;
                while (p1 != p2) {
                    p1 = p1.getNext();
                    p2 = p2.getNext();
                }
                if (p1.getData() == p2.getData()) {
                    return p1;
                }
            }
        }
        return null;
    }

}
