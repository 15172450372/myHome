package javabasic.concurrency.thread;

/**
 * @Author: zhouwei
 * @Description: 线程执行
 * @Date: 2019/7/28 11:25
 * @Version: 1.0
 **/
public class ThreadExecution {

    public static void main(String[] args) throws InterruptedException {
        oneByOne();
        //threadLoop();
    }

    /**
     * 方法一：start、join
     *
     * @throws InterruptedException
     */
    private static void oneByOne() throws InterruptedException {
        Thread thread1 = new Thread(ThreadExecution::action, "t1");
        Thread thread2 = new Thread(ThreadExecution::action, "t2");
        Thread thread3 = new Thread(ThreadExecution::action, "t3");

        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();
        thread3.join();
    }

    /**
     * 方法二：自旋
     *
     * @throws InterruptedException
     */
    private static void threadLoop() throws InterruptedException {
        Thread thread1 = new Thread(ThreadExecution::action, "t1");
        Thread thread2 = new Thread(ThreadExecution::action, "t2");
        Thread thread3 = new Thread(ThreadExecution::action, "t3");

        thread1.start();
        while (thread1.isAlive()) {
            Thread.sleep(0);
        }

        thread2.start();
        while (thread2.isAlive()) {
            Thread.sleep(0);
        }

        thread3.start();
        while (thread3.isAlive()) {
            Thread.sleep(0);
        }

    }


    private static void action() {
        System.out.printf("线程[%s]正在执行...\n", Thread.currentThread().getName());
    }

}
