package javabasic.mycollection;


/**
 * @Author: zhouwei
 * @Description: 手写LinkedList
 * @Date: 2019/8/6 14:50
 * @Version: 1.0
 **/
public class MyLinkedList<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    public void add(E element) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, element, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    public void add(int index, E element) {
        rangeCheck(index);
        if (index == size) {
            final Node<E> l = last;
            final Node<E> newNode = new Node<>(l, element, null);
            last.next = newNode;
            last = newNode;
        } else {
            final Node<E> node = getNode(index);
            final Node<E> preNode = node.prev;
            final Node newNode = new Node(preNode, element, node);
            node.prev = newNode;
            if (preNode == null) {
                first = newNode;
            } else {
                preNode.next = newNode;
            }
            size++;
        }
    }

    public E get(int index) {
        return getNode(index).item;
    }

    public Node<E> getNode(int index) {
        rangeCheck(index);
        Node temp;
        if (index < (size>>1)) {
            temp = first;
            for (int i=0; i<index; i++) {
                temp = temp.next;
            }
        } else {
            temp = last;
            for (int i=size-1; i>index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    public E remove(int index) {
        rangeCheck(index);
        Node<E> node = getNode(index);
        final E element = node.item;
        final Node<E> pre = node.prev;
        final Node<E> next = node.next;

        if (pre == null) {
            first = next;
        } else {
            pre.next = next;
            node.prev = null;
        }

        if (next == null) {
            last = pre;
        } else {
            next.prev = pre;
            node.next = null;
        }

        node.item = null;
        size--;
        return element;

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

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }



    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("a");
        myLinkedList.add("b");
        myLinkedList.add("c");
        myLinkedList.add("d");
        myLinkedList.add("e");
        myLinkedList.add(2,"f");
        System.out.println(1);
    }
}
