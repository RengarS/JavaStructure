package com.aries.datastructure;

/**
 * @param <E>
 * @author aries
 * 栈，先进后出
 */
public class AriesStack<E> {
    private StackNode root;
    private int size = 0;
    private StackNode tail;

    /**
     * 入栈
     *
     * @param data
     * @return
     */
    public boolean put(E data) {
        if (root == null) {
            root = new StackNode(data);
            size++;
        } else {
            StackNode node = root;
            for (; node.next != null; node = node.next) {
            }
            node.next = new StackNode(data);
            size++;
        }

        return true;
    }

    /**
     * 仅返回栈顶元素的值
     *
     * @return
     */
    public E peek() {
        return (E) elementAt(size - 1).getData();
    }

    /**
     * 出栈
     *
     * @return
     */
    public E pop() {
        StackNode node1 = root;
        if (size == 1) {
            E data = (E) root.getData();
            root = null;
            size--;
            return data;
        }
        //遍历到栈顶的下一个元素
        for (int i = 1; i < size - 1; i++) {
            node1 = node1.next;
        }
        E data = (E) node1.next.getData();
        node1.next = null;
        size--;
        return data;
    }

    public int size() {
        return size;
    }

    private StackNode elementAt(int index) {
        StackNode node1 = root;
        for (int i = 0; i < index; i++) {
            node1 = node1.next;
        }
        return node1;
    }


    public static void main(String[] args) {
        AriesStack<String> stack = new AriesStack<>();
        stack.put("A");
        stack.put("B");
        stack.put("C");
        stack.put("D");
        String data = stack.peek();
        String data1 = stack.peek();
        String data2 = stack.pop();
        String data3 = stack.pop();
        System.out.println(data + "  " + data1 + "  " + data2 + "  " + data3);
        System.out.println(stack.size());
    }
}

class StackNode<E> {
    private E data;
    StackNode next;

    public StackNode() {
    }

    public StackNode(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

}
