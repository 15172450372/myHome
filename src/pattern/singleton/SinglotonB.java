package pattern.singleton;


/**
 * @Author: zhouwei
 * @Description: 线程安全-双重校验锁
 * @Date: 2019/8/23 11:02
 * @Version: 1.0
 **/
public class SinglotonB {

    private static volatile SinglotonB instance;

    private SinglotonB() { }

    public static SinglotonB getInstance() {
        if (instance == null) {
            synchronized (SinglotonB.class) {
                if (instance == null) {
                    instance = new SinglotonB();
                }
            }
        }
        return instance;
    }

}
