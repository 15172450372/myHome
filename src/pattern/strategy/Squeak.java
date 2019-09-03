package pattern.strategy;

/**
 * @Author: zhouwei
 * @Description:
 * @Date: 2019/9/2 10:03
 * @Version: 1.0
 **/
public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("quack: Squeak Squeak Squeak");
    }
}
