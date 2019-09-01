package javaBasic.Practice.threadpool;

/**
 * @Author: zhouwei
 * @Description: 定义一个线程池应该具备的基本操作和方法
 * @Date: 2019/8/30 15:06
 * @Version: 1.0
 **/
public interface ThreadPool {

    /**
     * 提交任务到线程池
     *
     * @param runnable
     */
    void execute(Runnable runnable);

    /**
     * 关闭线程池
     */
    void shutdown();

    /**
     * 初始化大小
     */
    int getInitSize();

    /**
     * 获取线程池最大线程数
     *
     * @return
     */
    int getMaxsize();

    /**
     * 获取线程池最大的线程数
     *
     * @return
     */
    int getCoreSize();

    /**
     * 获取线程池中用于缓存任务队列的大小
     *
     * @return
     */
    int getQuenSize();

    /**
     * 获取线程池中活跃线程的数量
     *
     * @return
     */
    int getActiveCount();

    /**
     * 查询线程池是否已经关闭
     *
     * @return
     */
    boolean isShutdown();

}














