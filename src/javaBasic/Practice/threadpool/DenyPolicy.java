package javaBasic.Practice.threadpool;

/**
 * @Author: zhouwei
 * @Description: 当RunnableQueue超出范围时，使用拒绝策略
 * @Date: 2019/8/30 15:25
 * @Version: 1.0
 **/
@FunctionalInterface
public interface DenyPolicy {

    /**
     * 拒绝策略
     *
     * @param runnable
     * @param threadPool
     */
    void reject(Runnable runnable, ThreadPool threadPool);

}
