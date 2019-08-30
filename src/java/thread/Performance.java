package java.thread;

/**
 * @Author: zhouwei
 * @Description: 线程协作-生产消费模型，信号灯法
 * @Date: 2019/8/18 10:36
 * @Version: 1.0
 **/
public class Performance {

    public static void main(String[] args) {

        TV tv = new TV();

        Perfomer perfomer = new Perfomer(tv);
        Audience audience = new Audience(tv);

        new Thread(perfomer).start();
        new Thread(audience).start();
    }

}

/**
 * 表演者
 */
class Perfomer implements Runnable {

    private TV tv;
    public Perfomer(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i=0; i<10; i++) {
            if (i%2==0) {
                tv.play("111111");
            } else {
                tv.play("22222222");
            }
        }
    }
}

/**
 * 观众
 */
class Audience implements Runnable {

    private TV tv;
    public Audience(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i=0; i<10; i++) {
            tv.watch();
        }
    }
}

/**
 * 电视
 */
class TV {
    String voice; //内容
    boolean flag = true; //信号灯

    /**
     * 表演
     * @param voice
     */
    public synchronized void play(String voice) {
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.voice = voice;
        System.out.println("表演时刻" + voice);
        flag = false;
        this.notifyAll();
    }

    /**
     * 收听
     */
    public synchronized void watch() {
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("收听时刻" + this.voice);
        flag = true;
        this.notifyAll();
    }

}