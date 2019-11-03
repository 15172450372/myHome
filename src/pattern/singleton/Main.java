package pattern.singleton;

/**
 * @Author: zhouwei
 * @Description: 单例模式
 * @Date: 2019/8/23 11:02
 * @Version: 1.0
 **/
public class Main {

    public static void main(String[] args) {
        SingletonA instance = SingletonA.getInstance();
        SingletonA instance1 = SingletonA.getInstance();
        if (instance == instance1) {
            System.out.println("success");
        }

        SingletonB instance2 = SingletonB.getInstance();
        SingletonB instance3 = SingletonB.getInstance();
        if (instance2 == instance3) {
            System.out.println("success");
        }

        SingletonC instance4 = SingletonC.getInstance();
        SingletonC instance5 = SingletonC.getInstance();
        if (instance4 == instance5) {
            System.out.println("success");
        }

    }

    public static void test(Class clazz) {

    }

}
