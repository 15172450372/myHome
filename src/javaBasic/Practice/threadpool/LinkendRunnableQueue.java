package javaBasic.Practice.threadpool;

import java.util.LinkedList;

/**
 * @Author: zhouwei
 * @Description:
 * @Date: 2019/8/30 16:03
 * @Version: 1.0
 **/
public class LinkendRunnableQueue implements RunnableQueue {

    /**
     * 队列最大长度
     */
    private final int limit;

    /**
     * 拒绝策略
     */
    private final DenyPolicy denyPolicy;

    /**
     * 存放任务
     */
    private final LinkedList<Runnable> runnableList = new LinkedList<>();

    /**
     * 线程池
     */
    private ThreadPool threadPool;

    public LinkendRunnableQueue(int limit, DenyPolicy denyPolicy, ThreadPool threadPool) {
        this.limit = limit;
        this.denyPolicy = denyPolicy;
        this.threadPool = threadPool;
    }

    @Override
    public void offer(Runnable command) {
        synchronized (runnableList) {
            if (runnableList.size() >= limit) {
                denyPolicy.reject(command,threadPool);
            } else {
                runnableList.addLast(command);
                runnableList.notifyAll();
            }
        }
    }

    @Override
    public Runnable task() {
        synchronized (runnableList) {
            while (runnableList.isEmpty()) {
                try {
                    runnableList.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return runnableList.removeFirst();
        }
    }

    @Override
    public int size() {
        synchronized (runnableList) {
            return runnableList.size();
        }
    }
}
