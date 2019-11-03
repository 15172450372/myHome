package pattern.singleton;

/**
 * @Author: zhouwei
 * @Description: 线程安全-静态内部类
 * @Date: 2019/8/23 11:08
 * @Version: 1.0
 **/
public class SingletonC {

    private SingletonC() {}

    private static class Lazyload {
        private static final SingletonC INSTANCE = new SingletonC();
    }

    public static SingletonC getInstance() {
        return Lazyload.INSTANCE;
    }

}
