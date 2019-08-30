package java.Practice.threadpool;

import java.util.concurrent.TimeUnit;

/**
 * @Author: zhouwei
 * @Description:
 * @Date: 2019/8/30 20:06
 * @Version: 1.0
 **/
public class ThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {
        final ThreadPool threadPool = new BasicThreadPool(10, 100, 10, 1000);


        for (int i = 0; i < 20; i++) {
            threadPool.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(10);
                    System.out.println(Thread.currentThread().getName() + " is running and done.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            for (; ; ) {
                System.out.println("getActiveCount:" + threadPool.getActiveCount());
                System.out.println("getCoreSize:" + threadPool.getCoreSize());
                System.out.println("getMaxSize:" + threadPool.getMaxsize());
                System.out.println("getRunnableQueue:" + threadPool.getQuenSize());
                System.out.println("=================================");
                TimeUnit.SECONDS.sleep(5);
            }
        }
    }
}
