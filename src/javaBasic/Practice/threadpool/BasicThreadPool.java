package javaBasic.Practice.threadpool;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: zhouwei
 * @Description:
 * @Date: 2019/8/30 19:06
 * @Version: 1.0
 **/
public class BasicThreadPool extends Thread implements ThreadPool {

    /**
     * 初始化线程数量
     */
    private int initSize;

    /**
     * 线程池最大线程数量
     */
    private int maxSize;

    /**
     * 线程池核心线程数量
     */
    private int coreSize;

    /**
     * 当前活跃的线程数量
     */
    private int activeCount;

    private int keepAliveTime;

    private TimeUnit timeUnit;

    //是否停止线程池
    private volatile boolean isShutdown = false;

    private ThreadFactory threadFactory;

    //任务队列
    private RunnableQueue runnableQueue;

    //拒绝策略
    private DenyPolicy denyPolicy;

    //线程队列
    private final Queue<ThreadTask> threadQueue = new ArrayDeque();

    /**
     * 默认线程创建工厂
     */
    private static final ThreadFactory DEFAULT_THREAD_FACTORY = new DefaultThreadFactory();

    /**
     * 默认拒绝策略
     */
    private static final DenyPolicy DEFAULT_DENY_POLICY = new DiscardDenyPolicy();

    public BasicThreadPool(int initSize, int coreSize, int maxSize, int queueSize) {
        this(initSize, coreSize, maxSize, queueSize, DEFAULT_THREAD_FACTORY, DEFAULT_DENY_POLICY, 10, TimeUnit.SECONDS);
    }

    /**
     * init
     *
     * @param initSize 初始线程数
     * @param coreSize 核心线程数
     * @param maxSize 最大线程数
     * @param threadFactory 线程创建工厂
     * @param denyPolicy 拒绝策略
     * @param queueSize 队列容量
     * @param keepAliveTime 存活时间
     * @param timeUnit 时间单位
     */
    public BasicThreadPool(int initSize, int coreSize, int maxSize, int queueSize,
                           ThreadFactory threadFactory, DenyPolicy denyPolicy, int keepAliveTime, TimeUnit timeUnit) {
        this.initSize = initSize;
        this.coreSize = coreSize;
        this.maxSize = maxSize;
        this.threadFactory = threadFactory;
        this.runnableQueue = new LinkendRunnableQueue(queueSize, denyPolicy, this);
        this.keepAliveTime = keepAliveTime;
        this.timeUnit = timeUnit;
        init();
    }

    /**
     * 初始化
     */
    private void init() {
        start();  //导致此线程开始执行; Java虚拟机调用此线程的run方法。
        for (int i = 0; i < initSize; i++) {
            createThread();
        }
    }

    /**
     * 添加线程
     */
    private void createThread() {
        InternalTask internalTask = new InternalTask(runnableQueue);
        Thread thread = this.threadFactory.createThread(internalTask);
        ThreadTask threadTask = new ThreadTask(thread, internalTask);
        threadQueue.offer(threadTask);
        this.activeCount++;
        thread.start();
    }

    /**
     * 移除某个线程
     */
    private void removeThread() {
        ThreadTask threadTask = threadQueue.remove();
        threadTask.internalTask.stop();
        this.activeCount--;
    }

    @Override
    public void run() {
        //用于维护线程数量，比如扩容、回收等工作
        while (!isShutdown && !isInterrupted()) {
            try {
                timeUnit.sleep(keepAliveTime);
            } catch (InterruptedException e) {
                isShutdown = true;
                break;
            }

            synchronized (this) {
                if (isShutdown) {
                    break;
                }
                if (runnableQueue.size() > 0 && activeCount < coreSize) {
                    for (int i = initSize; i < coreSize; i++) {
                        createThread();
                    }
                    continue;
                }

                if (runnableQueue.size() > 0 && activeCount < coreSize) {
                    for (int i = initSize; i < maxSize; i++) {
                        createThread();
                    }
                }

                if (runnableQueue.size() == 0 && activeCount > coreSize) {
                    for (int i = coreSize; i < activeCount; i++) {
                        removeThread();
                    }
                }

            }
        }
    }

    @Override
    public void execute(Runnable runnable) {
        if (this.isShutdown) {
            throw new IllegalStateException("The thread pool is destroy");
        }
        //提交到队列
        this.runnableQueue.offer(runnable);
    }

    /**
     * 关闭线程池
     */
    @Override
    public void shutdown() {
        synchronized (this) {
            if (isShutdown) {
                return;
            } else {
                isShutdown = true;
                threadQueue.forEach(threadTask -> {
                    threadTask.internalTask.stop();
                    threadTask.thread.interrupt();
                });
            }
            this.interrupt();
        }
    }

    @Override
    public int getInitSize() {
        if (isShutdown) {
            throw new IllegalStateException("The thread pool is destroy");
        }
        return this.initSize;
    }

    @Override
    public int getMaxsize() {
        if (isShutdown) {
            throw new IllegalStateException("The thread pool is destroy");
        }
        return this.maxSize;
    }

    @Override
    public int getCoreSize() {
        if (isShutdown) {
            throw new IllegalStateException("The thread pool is destroy");
        }
        return this.coreSize;
    }

    @Override
    public int getQuenSize() {
        if (isShutdown) {
            throw new IllegalStateException("The thread pool is destroy");
        }
        return this.runnableQueue.size();
    }

    @Override
    public int getActiveCount() {
        if (isShutdown) {
            throw new IllegalStateException("The thread pool is destroy");
        }
        return this.activeCount;
    }

    @Override
    public boolean isShutdown() {
        return isShutdown;
    }

    /**
     * ThreadTask只是InternalTask和Thread结合
     */
    private static class ThreadTask {
        Thread thread;
        InternalTask internalTask;

        public ThreadTask(Thread thread, InternalTask internalTask) {
            this.thread = thread;
            this.internalTask = internalTask;
        }
    }

}
