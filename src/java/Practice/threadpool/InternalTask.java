package java.Practice.threadpool;

/**
 * @Author: zhouwei
 * @Description: 用于线程池内部，不断从queue中取出某个runnable,并运行run方法
 * @Date: 2019/8/30 15:56
 * @Version: 1.0
 **/
public class InternalTask implements Runnable {

    //任务队列
    private final RunnableQueue queue;

    //标志
    private volatile boolean running = true;

    public InternalTask(RunnableQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (running && !Thread.currentThread().isInterrupted()) {
            try {
                Runnable task = queue.task();
                task.run();
            } catch (Exception e) {
                running = false;
            }
        }
    }

    //停止当前任务
    public void stop() {
        this.running = false;
    }


}
