package java.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: zhouwei
 * @Description:
 * @Date: 2019/7/28 16:16
 * @Version: 1.0
 **/
public class AtomicIntegerTest {

    private static final int THREADS_CONUT = 10;
    private static AtomicInteger num = new AtomicInteger(0);


    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_CONUT];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    // 此处设置10000.太小看不到效果。请酌情设置
                    for (int j = 1; j <=10000 ; j++) {
                        // 如想要看到结果请放开下行注释
                        //System.out.println(Thread.currentThread().getName() +" num = "+num);
                        num.incrementAndGet();
                    }
                }
            });
            threads[i].start();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(num);
    }

}
