package javaBasic.Practice.threadpool;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: zhouwei
 * @Description:
 * @Date: 2019/8/30 19:06
 * @Version: 1.0
 **/
public class DefaultThreadFactory implements ThreadFactory {

    private static final AtomicInteger GROUP_COUNTER = new AtomicInteger(1);

    private static final ThreadGroup GROUP = new ThreadGroup("MyThreadPool-" + GROUP_COUNTER.getAndDecrement());

    private static final AtomicInteger COUNTER = new AtomicInteger(0);

    @Override
    public Thread createThread(Runnable runnable) {
        return new Thread(GROUP, runnable, "thread-pool-" + COUNTER.getAndDecrement());
    }

}
