package pattern.strategy;

/**
 * @Author: zhouwei
 * @Description: 策略模式: 定义了算法族，分别封装起来，让他们可以相互替换，此模式让算法的实现独立于使用算法的客户
 * @Date: 2019/9/2 9:06
 * @Version: 1.0
 **/
public class Main {

    public static void main(String[] args) {

        Duck mallard = new MallardDuck();
        mallard.display();
        mallard.performFly();
        mallard.performQuack();
        System.out.println();

        Duck model = new ModelDuck();
        model.display();
        model.performQuack();
        model.performFly();
        //动态赋予行为
        model.setFlyBehavior(new FlyRocketPower());
        model.performFly();

    }

}
