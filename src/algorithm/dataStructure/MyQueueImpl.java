package algorithm.dataStructure;


/**
 * @Descript: 队列
 * @Author: zhouwei
 * @Date: 19-6-23 下午3:08
 * @Version 1.0
 */
public class MyQueueImpl implements MyQueue {

    int[] arr;

    @Override
    public void qInit(int capacity) {
        arr = new int[capacity];
    }

    @Override
    public int[] qpush(int element) throws Exception {
        if (qFull()) {
            throw new Exception("队列已满！");
        }
        for (int i:arr) {
            if (arr[i] == 0) {
                arr[i] = element;
                break;
            }
        }
        return arr;
    }

    @Override
    public int[] qPop() {
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == 0) {
                break;
            }
            arr[i] = arr[i+1];
        }
        return arr;
    }

    @Override
    public boolean qEmpty() {
        return this.arr[0] == 0;
    }

    @Override
    public boolean qFull() {
        return arr[arr.length-1] != 0;
    }
}
