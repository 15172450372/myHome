package javabasic.concurrency.thread;

/**
 * @Author: zhouwei
 * @Description: 线程中止
 * @Date: 2019/7/28 14:19
 * @Version: 1.0
 **/
public class ThreadStop {

    public static void main(String[] args) throws InterruptedException {
        //线程中止方式一
        Action action = new Action();
        Thread t1 = new Thread(action, "t1");
        t1.start();
        action.setStopped(true);
        t1.join();

        //线程中止方式二
        Thread t2 = new Thread(()->{
            if (!Thread.currentThread().isInterrupted()) {
                action();
            }
        }, "t2");
        t2.start();
        t2.interrupt();  //中断操作，实质是状态的流转
        t2.join();

        

    }

    private static class Action implements Runnable {

        private volatile boolean stopped = false;

        @Override
        public void run() {
            if (!stopped) {
                System.out.printf("线程[%s]正在执行...\n", Thread.currentThread().getName());
            }
        }

        void setStopped(boolean stopped) {
            this.stopped = stopped;
        }
    }

    private static void action() {
        System.out.printf("线程[%s]正在执行...\n", Thread.currentThread().getName());
    }

}
