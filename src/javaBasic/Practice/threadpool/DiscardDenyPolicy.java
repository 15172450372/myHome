package javaBasic.Practice.threadpool;

/**
 * @Author: zhouwei
 * @Description: 拒绝策略-丢弃
 * @Date: 2019/8/30 15:36
 * @Version: 1.0
 **/
public class DiscardDenyPolicy implements DenyPolicy {

    /**
     * 丢弃
     *
     * @param runnable
     * @param threadPool
     */
    @Override
    public void reject(Runnable runnable, ThreadPool threadPool) {

    }
}
