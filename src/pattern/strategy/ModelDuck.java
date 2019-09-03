package pattern.strategy;

/**
 * @Author: zhouwei
 * @Description:
 * @Date: 2019/9/2 10:08
 * @Version: 1.0
 **/
public class ModelDuck extends Duck {

    public ModelDuck() {
        this.flyBehavior = new FlyNoWing();
        this.quackBehavior = new MuteQuack();
    }

    @Override
    public void display() {
        System.out.println("i am a model duck");
    }

}
