package java.Practice.threadpool;

/**
 * @Author: zhouwei
 * @Description: 存放用于提交的Runnable
 * @Date: 2019/8/30 15:20
 * @Version: 1.0
 **/
public interface RunnableQueue {

    /**
     * 存放新任务
     *
     * @param command
     */
    void offer(Runnable command);

    /**
     * 获取任务
     *
     * @return
     */
    Runnable task();

    /**
     * 获取线程池缓存任务的数量
     *
     * @return
     */
    int size();

}
