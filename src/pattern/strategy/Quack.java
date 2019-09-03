package pattern.strategy;

/**
 * @Author: zhouwei
 * @Description:
 * @Date: 2019/9/2 10:01
 * @Version: 1.0
 **/
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("quack: quack quack quack");
    }
}
