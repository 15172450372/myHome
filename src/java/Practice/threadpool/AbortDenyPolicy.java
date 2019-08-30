package java.Practice.threadpool;

/**
 * @Author: zhouwei
 * @Description: 拒绝策略-丢弃并抛异常
 * @Date: 2019/8/30 15:37
 * @Version: 1.0
 **/
public class AbortDenyPolicy implements DenyPolicy {

    /**
     * 拒绝任务，抛异常
     *
     * @param runnable
     * @param threadPool
     */
    @Override
    public void reject(Runnable runnable, ThreadPool threadPool) {
        throw new RunnableDenyPolicyException("task reject！" + runnable.toString());
    }
}
