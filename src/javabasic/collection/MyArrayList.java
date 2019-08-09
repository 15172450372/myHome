package javabasic.collection;

/**
 * @Author: zhouwei
 * @Description: 手写ArrayList
 * @Date: 2019/8/6 12:09
 * @Version: 1.0
 **/
public class MyArrayList<E> {

    private Object[] elementData;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    private static final Object[] EMPTY_ELEMENTDATA = {};

    public MyArrayList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new RuntimeException("Illegal Capacity: " + initialCapacity);
        }
    }

    public void add(E element) {
        //扩容
        if (size == elementData.length) {
            Object[] newArray = new Object[elementData.length + (elementData.length >> 1)];
            System.arraycopy(elementData,0,newArray,0,elementData.length);
            elementData = newArray;
        }
        this.elementData[size++] = element;
    }

    public E get(int index) {
        rangeCheck(index);
        return (E) elementData[index];
    }

    public E set(E e, int index) {
        rangeCheck(index);
        E element = (E) elementData[index];
        elementData[index] = e;
        return element;
    }

    public E remove(int index) {
        rangeCheck(index);
        E element = (E) elementData[index];
        System.arraycopy(elementData,index+1,elementData,index,elementData.length-index-1);
        return element;
    }

    public boolean remove(Object o) {
        if (o == null) {
            for (int index = 0; index < size; index++) {
                if (elementData[index] == null) {
                    remove(index);
                    return true;
                }
            }
        } else {
            for (int index = 0; index < size; index++) {
                if (o.equals(elementData[index])) {
                    remove(index);
                    return true;
                }
            }
        }
        return false;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 数组越界检测
     * @param index
     */
    private void rangeCheck(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (Object o : elementData) {
            sb.append(0).append(",");
        }
        sb.setCharAt(sb.length()-1, ']');
        return sb.toString();
    }

    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(5);
        myArrayList.remove(new Integer(5));
    }

}
