package pattern.singleton;


/**
 * @Author: zhouwei
 * @Description: 线程安全-双重校验锁
 * @Date: 2019/8/23 11:02
 * @Version: 1.0
 **/
public class SingletonB {

    private static volatile SingletonB instance;

    private SingletonB() { }

    public static SingletonB getInstance() {
        if (instance == null) {
            synchronized (SingletonB.class) {
                if (instance == null) {
                    instance = new SingletonB();
                }
            }
        }
        return instance;
    }

}
