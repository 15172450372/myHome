package javabasic.jdk.util.concurrent;

import java.util.PrimitiveIterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: zhouwei
 * @Description: java.util.concurrent.atomic包
 * @Date: 2019/8/26 14:26
 * @Version: 1.0
 **/
public class AtomicTest {

    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {

        new Thread(new test(),"A").start();
        new Thread(new test(),"B").start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);

    }

    private static class test implements Runnable {

        @Override
        public void run() {
            for (int i=0;i<1000;i++) {
                count.incrementAndGet();
            }
        }
    }

}
