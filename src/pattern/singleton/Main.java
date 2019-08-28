package pattern.singleton;

/**
 * @Author: zhouwei
 * @Description: 单例模式
 * @Date: 2019/8/23 11:02
 * @Version: 1.0
 **/
public class Main {

    public static void main(String[] args) {
        SinglotonA instance = SinglotonA.getInstance();
        SinglotonA instance1 = SinglotonA.getInstance();
        if (instance == instance1) {
            System.out.println("success");
        }

        SinglotonB instance2 = SinglotonB.getInstance();
        SinglotonB instance3 = SinglotonB.getInstance();
        if (instance2 == instance3) {
            System.out.println("success");
        }

        SinglotonC instance4 = SinglotonC.getInstance();
        SinglotonC instance5 = SinglotonC.getInstance();
        if (instance4 == instance5) {
            System.out.println("success");
        }

    }

}
