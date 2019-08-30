package algorithm.datastruct;

/**
 * @Author: zhouwei
 * @Description: 循环队列
 * @Date: 2019/8/29 19:24
 * @Version: 1.0
 **/
public class MyCircularQueue {

    private int[] data;
    private int head;
    private int tail;
    private int size;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        data = new int[k];
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            data[0] = value;
        } else {
            tail = (tail+1)%data.length;
            data[tail] = value;
        }
        size++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (head == tail) {
            head = 0;
            tail = 0;
        } else {
            head = (head+1)%data.length;
        }
        size--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return data[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return data[tail];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        int interval = Math.abs(tail - head);
        if (interval == data.length-1) {
            return true;
        }
        return tail - head == -1;
    }

}
