package javaBasic.Practice.threadpool;

/**
 * @Author: zhouwei
 * @Description: 拒绝策略-在提交者所在的线程执行
 * @Date: 2019/8/30 15:53
 * @Version: 1.0
 **/
public class RunnerDenyPolicy implements DenyPolicy {

    /**
     * 执行
     *
     * @param runnable
     * @param threadPool
     */
    @Override
    public void reject(Runnable runnable, ThreadPool threadPool) {
        if (!threadPool.isShutdown()) {
            runnable.run();
        }
    }
}
