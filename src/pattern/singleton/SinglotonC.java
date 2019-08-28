package pattern.singleton;

/**
 * @Author: zhouwei
 * @Description: 线程安全-静态内部类
 * @Date: 2019/8/23 11:08
 * @Version: 1.0
 **/
public class SinglotonC {

    private SinglotonC() {}

    private static class Lazyload {
        private static final SinglotonC INSTANCE = new SinglotonC();
    }

    public static final SinglotonC getInstance() {
        return Lazyload.INSTANCE;
    }

}
