package javaBasic.Practice;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: zhouwei
 * @Description:
 * @Date: 2019/8/30 20:19
 * @Version: 1.0
 **/
public class MyThreadPool {

    BlockingQueue<Runnable> workQueue;  //任务队列

    public MyThreadPool(int size, BlockingQueue<Runnable> workQueue) {
        this.workQueue = workQueue;
        for (int i=0; i<size; i++) {
            WorkThread workThread = new WorkThread();
            workThread.start();
            workQueue.add(workThread);
        }
    }

    void execute(Runnable command) {
        try {
            workQueue.put(command);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class WorkThread extends Thread {
        @Override
        public void run() {
            while (true) {
                Runnable task = null;
                try {
                    task = workQueue.take();
                    task.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<>(5);
        MyThreadPool myThreadPool = new MyThreadPool(2, workQueue);
        for (int i=0; i<100; i++) {
            myThreadPool.execute(()-> System.out.println("hello"));
        }
    }

}
