package pattern.strategy;

/**
 * @Author: zhouwei
 * @Description:
 * @Date: 2019/9/2 10:18
 * @Version: 1.0
 **/
public class FlyRocketPower implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("fly with a rocket powers");
    }
}
