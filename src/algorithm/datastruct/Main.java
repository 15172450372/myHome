package algorithm.datastruct;

import java.util.LinkedList;

/**
 * @Author: zhouwei
 * @Description:
 * @Date: 2019/8/29 19:21
 * @Version: 1.0
 **/
public class Main {

    public static void main(String[] args) {
        //queueTest();
        circularQueueTest();
    }

    private static void queueTest() {
        MyQueue q = new MyQueue();
        q.enQueue(5);
        q.enQueue(3);
        if (!q.isEmpty()) {
            System.out.println(q.getFront());
        }
        q.deQueue();
        if (!q.isEmpty()) {
            System.out.println(q.getFront());
        }
        q.deQueue();
        if (!q.isEmpty()) {
            System.out.println(q.getFront());
        }
    }

    private static void circularQueueTest() {
        MyCircularQueue myCircularQueue = new MyCircularQueue(5);
        myCircularQueue.enQueue(1);
        myCircularQueue.deQueue();

        int front = myCircularQueue.Front();
        int rear = myCircularQueue.Rear();

    }

}
