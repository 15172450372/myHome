package java.thread;

/**
 * @Author: zhouwei
 * @Description: 并发同步-模拟龟兔赛跑
 * @Date: 2019/8/16 14:32
 * @Version: 1.0
 **/
public class RaceTest implements Runnable {

    private static final String RABBIT = "rabbit";
    private static final String TORTOISE = "tortoise";

    private static String winner;

    @Override
    public void run() {
        for (int steps=0; steps<=100; steps++) {
            if (isGameOver(steps)) {
                break;
            } else {
                System.out.println(Thread.currentThread().getName() + "--" + steps);
                if (Thread.currentThread().getName().equals(RABBIT) && steps%10==0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * 判断比赛是否结束
     * @param step 步数
     * @return
     */
    private static boolean isGameOver(int step) {
        if (winner != null) {
            return true;
        } else {
            if (step == 100) {
                winner = Thread.currentThread().getName();
                System.out.println(Thread.currentThread().getName() + "--" + 100);
                System.out.println("winner is " + winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        RaceTest race = new RaceTest();
        Thread thread = new Thread(race, TORTOISE);
        Thread thread1 = new Thread(race, RABBIT);
        thread.start();
        thread1.start();


    }

}
