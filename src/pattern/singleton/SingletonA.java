package pattern.singleton;

/**
 * @Author: zhouwei
 * @Description: 非线程安全
 * @Date: 2019/8/23 11:00
 * @Version: 1.0
 **/
public class SingletonA {

    private static SingletonA instance;

    private SingletonA() {}

    public static SingletonA getInstance() {
        if (instance == null) {
            instance = new SingletonA();
        }
        return instance;
    }

}
