package pattern.strategy;

/**
 * @Author: zhouwei
 * @Description:
 * @Date: 2019/9/2 10:04
 * @Version: 1.0
 **/
public class MallardDuck extends Duck {

    public MallardDuck() {
        this.flyBehavior = new FlyWithWings();
        this.quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("i am a mallard duck!");
    }

}
