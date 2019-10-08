/**
 * Node.java   2018��3��13�� ����2:43:11 by PANGJIANLIN 
 *
 * Copyright (c) 2010 - 2018 jianlin.Pang. All rights reserved.
 * 
 */
package main.java.binaryTree;

public class Node {

    private int value;
    private Node leftChild;
    private Node rightChild;

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

}
