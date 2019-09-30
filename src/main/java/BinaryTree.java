/**
 * BinaryTree.java   2018��3��13�� ����2:44:54 by PANGJIANLIN 
 *
 * Copyright (c) 2010 - 2018 jianlin.Pang. All rights reserved.
 * 
 */
package main.java;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryTree {

    private Node root = null;

    public BinaryTree() {
    }

    public BinaryTree(int value) {
        root = new Node(value);
        root.setLeftChild(null);
        root.setRightChild(null);
    }

    public void findDepthWidth() {
        System.out.println("最大深度");
        System.out.println(findMaxDepth(root));
        System.out.println("最大宽度");
        System.out.println(findMaxWidth(root));
    }

    public int findMaxDepth(Node node) {
        if (null == node) {
            return 0;
        } else {
            int left = findMaxDepth(node.getLeftChild());
            int right = findMaxDepth(node.getRightChild());
            return 1 + Math.max(left, right);
        }
    }

    public int findMaxWidth(Node node) {
        if (null == node) {
            return 0;
        }
        Queue<Node> queue = new ArrayDeque<Node>();
        int maxWidth = 1;
        queue.add(node);
        while (true) {
            int length = queue.size();
            if (0 == length) {
                break;
            }
            while (length > 0) {
                Node n = queue.poll();
                length--;
                if (null != n.getLeftChild()) {
                    queue.add(n.getLeftChild());
                }
                if (null != n.getRightChild()) {
                    queue.add(n.getRightChild());
                }
            }
            maxWidth = Math.max(maxWidth, queue.size());
        }
        return maxWidth;
    }

    public int findMin() {
        Node current = root;
        while (true) {
            if (null == current.getLeftChild()) {
                return current.getValue();
            }
            current = current.getLeftChild();
        }
    }

    public void preOrderTraverse() {
        System.out.println("前序遍历");
        preOrder(root);
        System.out.println();
    }

    public void preOrder(Node node) {
        if (null == node) {
            return;
        } else {
            System.out.print(node.getValue() + " ");
            preOrder(node.getLeftChild());
            preOrder(node.getRightChild());
        }
    }

    public void inOrderTraverse() {
        System.out.println("中序遍历");
        inOrder(root);
        System.out.println();
    }

    public void inOrder(Node node) {
        if (null == node) {
            return;
        } else {
            inOrder(node.getLeftChild());
            System.out.print(node.getValue() + " ");
            inOrder(node.getRightChild());
        }
    }

    public Node findKey(int value) {
        Node current = root;
        while (true) {
            if (value == current.getValue()) {
                return current;
            } else if (value < current.getValue()) {
                current = current.getLeftChild();
            } else if (value > current.getValue()) {
                current = current.getRightChild();
            }
            if (null == current) {
                return null;
            }
        }
    }

    public void insert(int value) {
        Node node = new Node(value);
        if (null == root) {
            root = node;
            root.setLeftChild(null);
            root.setRightChild(null);
        } else {
            Node current = root;
            Node parent = null;
            while (true) {
                if (value < current.getValue()) {
                    parent = current;
                    current = current.getLeftChild();
                    if (null == current) {
                        parent.setLeftChild(node);
                        break;
                    }
                }
                if (value > current.getValue()) {
                    parent = current;
                    current = current.getRightChild();
                    if (null == current) {
                        parent.setRightChild(node);
                        break;
                    }
                }
                if (value == current.getValue()) {
                    System.out.println("same value found");
                    break;
                }
            }
        }
    }

}
