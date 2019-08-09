package javabasic.collection;

import java.util.HashMap;

/**
 * @Author: zhouwei
 * @Description: 手写HashSet
 * @Date: 2019/8/7 9:23
 * @Version: 1.0
 **/
public class MyHashSet<E> {

    private HashMap<E,Object> map;

    private static final Object PRESENT = new Object();

    public MyHashSet() {
        this.map = new HashMap<>();
    }

    public void add(E element) {
        this.map.put(element, PRESENT);
    }

    public void remove(E element) {
        map.remove(element);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (E e : map.keySet()) {
            stringBuilder.append(e + ",");
        }
        stringBuilder.setCharAt(stringBuilder.length()-1, ']');
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        MyHashSet<Integer> myHashSet = new MyHashSet<>();
        myHashSet.add(1);
        myHashSet.add(2);
        myHashSet.add(3);
        myHashSet.add(2);
        myHashSet.remove(3);
        System.out.println(myHashSet.toString());
    }

}
