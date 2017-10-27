package com.aries.datastructure;

/**
 * @param <K>
 * @param <V>
 * @author create by aries 2017-10-23
 */
public class AriesMap<K, V> {
    private static final int CAPITAL = 16;

    private MapNode<K, V>[] nodes;

    int size = 0;

    public static void main(String[] args) {
        AriesMap<String, String> map = new AriesMap<>();
        map.put("7", "haha");
        map.put("18", "hehe");
        map.put("1", "gege");
        map.put("18", "1111");
        map.put("90", "222");
        map.put("90", "233");


        String s = map.get("7");
        String ss = map.get("1");
        String sss = map.get("18");
        String ssss = map.get("90");
        System.out.println(s + "   " + ss + "  " + sss + " " + ssss);
    }

    /**
     * 判断map是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return
                this.size == 0;
    }

    /**
     * 返回map的size
     *
     * @return
     */
    public int size() {
        return
                this.size;
    }

    /**
     * 对key进行hash操作
     *
     * @param key
     * @return
     */
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    /**
     * 根据hash值和hashMap桶的数量计算出桶的位置
     *
     * @param h
     * @param length
     * @return
     */
    static int indexFor(int h, int length) {
        return
                h & (length - 1);
    }

    /**
     * key相同，覆盖，key不同，追加
     *
     * @param key
     * @param value
     * @return
     */
    public V put(K key, V value) {
        //计算出桶的位置
        int position = indexFor(hash(key), CAPITAL);
        //初始化桶
        if (null == this.nodes) {
            nodes = new MapNode[CAPITAL];
        }
        MapNode current = nodes[position];
        //如果桶为空，填充
        if (current == null) {
            nodes[position] = new MapNode(key, value);
            size++;
        } else {
            //如果桶不为空遍历桶中的链表
            for (; current != null; current = current.next) {
                if (current.key.equals(key)) {
                    //key相同，替换
                    current.value = value;
                    break;
                } else {//key不同，向链表尾追加
                    if (current.next == null) {
                        current.next = new MapNode(key, value);
                        size++;
                        break;
                    }
                }
            }
        }

        return null;
    }

    /**
     * @param key
     * @return
     */
    public V get(K key) {
        //计算位置
        int position = indexFor(hash(key), CAPITAL);
        MapNode node = nodes[position];
        if (node.key == key) {
            return (V) node.value;
        } else {//遍历链表
            while (true) {
                node = node.next;
                if (node == null) {
                    return null;
                } else {
                    if (node.key.equals(key)) {
                        return (V) node.value;
                    }
                }
            }
        }
    }


}

class MapNode<K, V> {
    public K key;
    public V value;
    public MapNode next;

    public MapNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

