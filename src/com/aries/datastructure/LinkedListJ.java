package com.aries.datastructure;

/**
 * @author aries
 */
public class LinkedListJ {
    private Node first;
    private Node last;


    public static void main(String[] args) {
        LinkedListJ listJ = new LinkedListJ();
        listJ.insert(11, 1, "aries");
        listJ.insert(12, 2, "bool");
        listJ.insert(13, 2, "candy");

        LinkedListJ listJ1 = new LinkedListJ();
        listJ1.insert(14, 2, "d");

        listJ.contactList(listJ, listJ1);
        listJ.print();
    }


    /**
     * 判断链表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return
                this.first == null;
    }

    /**
     * 打印链表内容
     */
    public void print() {
        Node current = first;
        while (current != null) {
            System.out.println(current.data + "  " + current.name + "  " + current.np);
            current = current.next;
        }
        System.out.println();
    }

    /**
     * 链表新增节点
     *
     * @param data
     * @param np
     * @param name
     */
    public void insert(int data, int np, String name) {
        Node newNode = new Node(data, np, name);
        if (this.isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
    }

    /**
     * 删除节点
     *
     * @param delNode
     */
    public void delete(Node delNode) {
        Node temp;

        //删除头结点
        if (delNode.data == first.data) {
            this.first = first.next;
        } else if (last.data == delNode.data) {
            //删除尾节点
            temp = first;
            for (; ; ) {
                if (temp.next == last) {
                    this.last = temp;
                    temp.next = null;
                    break;
                }
                temp = temp.next;
            }
        } else {//删除中间节点
            temp = first;
            for (; ; ) {
                if (temp.next.data == delNode.data) {
                    temp.next = temp.next.next;
                    break;
                }
                temp = temp.next;
            }
        }
    }

    /**
     * 连接两个链表
     *
     * @param listJ1
     * @param listJ2
     */
    public void contactList(LinkedListJ listJ1, LinkedListJ listJ2) {

        Node listJ1Head = listJ1.first;
        for (; listJ1Head.next != null; listJ1Head = listJ1Head.next) {
        }
        listJ1Head.next = listJ2.first;
    }
}

class Node {
    int data;
    int np;
    String name;
    Node next;

    public Node(int data, int np, String name) {
        this.data = data;
        this.np = np;
        this.name = name;
        this.next = null;
    }

}