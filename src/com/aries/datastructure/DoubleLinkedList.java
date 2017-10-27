package com.aries.datastructure;

/**
 * @author aries
 * 双向链表
 */
public class DoubleLinkedList {
    public Node2 head;
    public Node2 tail;

    public boolean isEmpty() {
        return
                this.head == null;
    }

    /**
     * 插入
     *
     * @param data
     */
    public void insert(int data) {
        Node2 newNode = new Node2(data);
        if (this.isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.last = this.tail;
            this.tail = newNode;
        }
    }

    /**
     * 删除节点
     *
     * @param data
     */
    public void delete(int data) {
        //删除头结点
        if (this.head.data == data) {
            this.head = this.head.next;
            this.head.last = null;
            return;
        }
        //删除尾节点
        if (this.tail.data == data) {
            this.tail = this.tail.last;
            this.tail.next = null;
            return;
        }
        //删除中间节点
        Node2 temp = this.head;
        for (; temp != null; temp = temp.next) {
            if (temp.data == data) {
                temp.last.next = temp.next;
                temp.next.last = temp.last.next;
            }
        }
    }

    public void print() {
        Node2 temp = this.head;
        for (; temp != null; temp = temp.next) {
            System.out.println(temp.data);
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList linkedList = new DoubleLinkedList();
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.print();
    }
}

class Node2 {
    int data;
    Node2 last;
    Node2 next;

    public Node2(int data) {
        this.data = data;
        this.last = null;
        this.next = null;
    }
}
