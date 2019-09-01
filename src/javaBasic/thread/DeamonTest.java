package javaBasic.thread;


/**
 * @Author: zhouwei
 * @Description: 守护线程，jvm不会等待守护线程结束
 * @Date: 2019/8/16 16:31
 * @Version: 1.0
 **/
public class DeamonTest {

    public static void main(String[] args) {
        User user = new User();
        God god = new God();
        Thread userThread = new Thread(user);
        Thread godThread = new Thread(god);
        godThread.setDaemon(true);
        godThread.start();
        userThread.start();
    }

    static class User implements Runnable{
        @Override
        public void run() {
            for (int i=0;i<365;i++) {
                System.out.println("user");
            }
        }
    }
    static class God implements Runnable{
        @Override
        public void run() {
            for (int i=0;i<365*1000000;i++) {
                System.out.println("god");
            }
        }
    }
}
