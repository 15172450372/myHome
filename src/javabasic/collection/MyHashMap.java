package javabasic.collection;


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: zhouwei
 * @Description: 手写HashMap
 * @Date: 2019/8/6 17:45
 * @Version: 1.0
 **/
public class MyHashMap<K,V> {

    private Node[] table;
    private int size;

    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    public MyHashMap() {
        table = new Node[DEFAULT_INITIAL_CAPACITY];
    }

    static class Node<K,V> {
        int hash;
        K key;
        V value;
        Node<K,V> next;

        Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
        Node() { }

        public void setHash(int hash) {
            this.hash = hash;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }

        @Override
        public final String toString() { return key + "=" + value; }
    }

    public void put(K key, V value) {
        //TODO:数组扩容

        Node<K,V> newNode = new Node<>();
        newNode.hash = myHash(key.hashCode(), table.length);
        newNode.key = key;
        newNode.value = value;
        newNode.next = null;

        Node temp = table[newNode.hash];
        Node last = null;
        if (temp == null) {  //数组该位置上无元素
            table[newNode.hash] = newNode;
            size++;
        } else {  //数组该位置上有元素
            while (temp != null) {  //key重复，直接覆盖
                if (temp.key.equals(key)) {
                    temp.value = value;
                    break;
                } else {  //key不重复，便利下一个
                    last = temp;
                    temp = temp.next;
                }
            }
            //key无重复
            if (last != null) {
                last.next = newNode;
                size++;
            }
        }
    }

    public V get(K key) {
        Node<K,V> node = table[myHash(key.hashCode(),table.length)];
        V value = null;
        if (node != null) {
            while (node != null) {
                if (node.key.equals(key)) {
                    value = node.value;
                    break;
                } else {
                    node = node.next;
                }
            }
        }
        return value;
    }

    private int myHash(int hashCode, int length) {
        return hashCode&(length-1);
    }

    public static void main(String[] args) {
        //MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
        //myHashMap.put(1,"a");
        //myHashMap.put(2,"b");
        //myHashMap.put(3,"c");
        //myHashMap.put(3,"f");
        //System.out.println(myHashMap.size);
        //String s = myHashMap.get(2);
        //System.out.println(s);


        ReentrantLock reentrantLock = new ReentrantLock();

    }

}
