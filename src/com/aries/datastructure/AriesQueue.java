package com.aries.datastructure;


/**
 * @param <E>
 * @author aries
 * 队列，先进先出
 */
public class AriesQueue<E> {
    private QueueNode2<E> root;
    private int size = 0;

    /**
     * 返回队列的size
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 入队
     *
     * @param data
     * @return
     */
    public boolean put(E data) {
        if (this.isEmpty()) {
            root = new QueueNode2<>(data);
            size++;
        } else {
            QueueNode2 node = root;
            //遍历到队尾元素
            for (; node.next != null; node = node.next) {

            }
            node.next = new QueueNode2(data);
            size++;
        }
        return true;
    }

    /**
     * 返回队头元素值
     *
     * @return
     */
    public E peek() {
        return root.data;
    }

    /**
     * 出队
     *
     * @return
     */
    public E pop() {
        E data = root.data;
        root = root.next;
        size--;
        return data;
    }


    public static void main(String[] args) {
        AriesQueue<String> queue = new AriesQueue<>();
        queue.put("A");
        queue.put("B");
        System.out.println(queue.peek() + "  " + queue.peek());
        System.out.println(queue.pop() + "  " + queue.pop());
    }
}

class QueueNode2<E> {
    public E data;
    public QueueNode2 next;

    public QueueNode2(E data) {
        this.data = data;
    }
}