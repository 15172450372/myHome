package javabasic.concurrency.thread;

import java.io.IOException;

/**
 * @Author: zhouwei
 * @Description: 线程创建（只有一中创建线程的方式：new，但运行线程有多种：runable、thread...）
 * @Date: 2019/7/28 14:34
 * @Version: 1.0
 **/
public class ThreadCreate {

    public static void main(String[] args) throws IOException {
        //创建线程
        Thread t1 = new Thread(ThreadCreate::action, "t1");
        t1.start();
        Thread t2 = new Thread(new MyThread(), "t2");
        t2.start();

        //创建进程
        //Runtime runtime = Runtime.getRuntime();
        ////Process process = runtime.exec("cmd /k start www.baidu.com");
        //Process process = runtime.exec("calc");
        //process.exitValue();
    }

    private static class MyThread implements Runnable {
        @Override
        public void run() {
            System.out.printf("线程[%s]正在执行...\n", Thread.currentThread().getName());
        }
    }

    private static void action() {
        System.out.printf("线程[%s]正在执行...\n", Thread.currentThread().getName());
    }

}
