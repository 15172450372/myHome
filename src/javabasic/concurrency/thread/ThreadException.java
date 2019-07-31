package javabasic.concurrency.thread;

/**
 * @Author: zhouwei
 * @Description: 线程异常时线程会中断
 * @Date: 2019/7/28 14:46
 * @Version: 1.0
 **/
public class ThreadException {

    public static void main(String[] args) throws InterruptedException {

        //异常捕获
        Thread.setDefaultUncaughtExceptionHandler((thread, Throwable)->{
            System.out.printf("线程[%s]遇到异常，详细信息：%s\n", thread.getName(), Throwable.getMessage());
        });

        //线程抛异常
        Thread t1 = new Thread(()->{
            throw new RuntimeException("数据异常！");
        },"t1");
        t1.start();
        t1.join();

        System.out.println(t1.isAlive());
    }

}
