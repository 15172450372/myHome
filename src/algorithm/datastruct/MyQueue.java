package algorithm.datastruct;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhouwei
 * @Description: 队列
 * @Date: 2019/8/29 19:11
 * @Version: 1.0
 **/
public class MyQueue {

    private List<Integer> data;
    private int p_start;

    public MyQueue() {
        data = new ArrayList<>();
        p_start = 0;
    }

    /**
     * 入队
     * @param element
     */
    public boolean enQueue(int element) {
        data.add(element);
        return true;
    }

    /**
     * 出队
     * @return
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        p_start++;
        return true;
    }

    /**
     * 获取队首元素
     * @return
     */
    public int getFront() {
        return data.get(p_start);
    }

    /**
     * 判空
     * @return
     */
    public boolean isEmpty() {
        return p_start >= data.size();
    }

}
