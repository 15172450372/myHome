package java.Practice.threadpool;

/**
 * @Author: zhouwei
 * @Description: 创建线程
 * @Date: 2019/8/30 19:01
 * @Version: 1.0
 **/
@FunctionalInterface
public interface ThreadFactory {

    /**
     * 用于创建线程
     *
     * @param runnable
     * @return
     */
    Thread createThread(Runnable runnable);

}
