package javabasic.thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author: zhouwei
 * @Description: 任务调度
 * @Date: 2019/8/18 14:37
 * @Version: 1.0
 **/
public class Test01 {

    public static void main(String[] args) {
        Timer timer = new Timer();
        MyTimerTask timerTask = new MyTimerTask();
        System.out.println("....");
        timer.schedule(timerTask,3000);
    }

    static class MyTimerTask extends TimerTask {

        @Override
        public void run() {
            System.out.println("i am coming!");
        }
    }

}
