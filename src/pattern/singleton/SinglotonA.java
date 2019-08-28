package pattern.singleton;

/**
 * @Author: zhouwei
 * @Description: 非线程安全
 * @Date: 2019/8/23 11:00
 * @Version: 1.0
 **/
public class SinglotonA {

    private static SinglotonA instance;

    private SinglotonA() {}

    public static SinglotonA getInstance() {
        if (instance == null) {
            instance = new SinglotonA();
        }
        return instance;
    }

}
