package javabasic.thread;


/**
 * @Author: zhouwei
 * @Description: 线程协作-生产消费模型，管程法
 * @Date: 2019/8/18 10:36
 * @Version: 1.0
 **/
public class Cost {

    public static void main(String[] args) {

        Container container = new Container(10);
        Producer producer = new Producer(container);
        Consumer consumer = new Consumer(container);

        new Thread(producer).start();
        new Thread(consumer).start();

    }

}

/**
 * 生产者
 */
class Producer implements Runnable {

    private Container container;

    public Producer(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i=0; i<100; i++) {
            Data data = new Data(i);
            //System.out.println("生产数据：" + data.id);
            container.push(data);
        }
    }
}

/**
 * 消费者
 */
class Consumer implements Runnable {

    private Container container;

    Consumer(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i=0;i<100;i++) {
            container.pop();
        }
    }
}

/**
 * 缓冲区
 */
class Container {

    private Data[] datas;
    private int capacity;
    private int count = 0;

    Container(int capacity) {
        this.capacity = capacity;
        this.datas = new Data[capacity];
    }

    //存,生产
    synchronized void push(Data data) {
        while (count >= capacity) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        datas[count] = data;
        System.out.println("生产数据：" + data.id);
        count ++;
        this.notifyAll();
    }

    //取，消费
    synchronized Data pop() {
        while (count <= 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        Data data = datas[count];
        System.out.println("消费数据: "+data.id);
        this.notifyAll();
        return data;
    }
}

/**
 * 数据
 */
class Data {
    int id;
    Data(int id) {
        this.id = id;
    }
}
