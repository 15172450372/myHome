package pattern.strategy;

/**
 * @Author: zhouwei
 * @Description:
 * @Date: 2019/9/2 10:00
 * @Version: 1.0
 **/
public class FlyNoWing implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("i can not flying");
    }
}
