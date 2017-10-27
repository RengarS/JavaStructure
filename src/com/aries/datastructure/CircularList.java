package com.aries.datastructure;

/**
 * @author aries
 * 环形链表
 */
public class CircularList {
    public Node1 first;
    public Node1 last;

    public boolean isEmpty() {
        return
                this.first == null;
    }

    public void insert(int data) {
        if (this.isEmpty()) {
            Node1 insertNode = new Node1(data);
            this.first = insertNode;
            this.last = insertNode;
            this.last.next = this.first;
            return;
        }

        Node1 insertNode = new Node1(data);
        last.next = insertNode;
        last = insertNode;
        last.next = first;
    }
}

class Node1 {
    int data;
    Node1 next;

    public Node1(int data) {
        this.data = data;
    }
}