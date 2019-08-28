package pattern.factoryPattern;

import pattern.factoryPattern.abstarctFactory.AbstractFactory;
import pattern.factoryPattern.abstarctFactory.Color;
import pattern.factoryPattern.factory.DellMouseFactory;
import pattern.factoryPattern.factory.FactoryProducer;
import pattern.factoryPattern.simpleFactory.Mouse;
import pattern.factoryPattern.simpleFactory.MouseFactory;

/**
 * @Author: zhouwei
 * @Description: 工厂模式
 * @Date: 2019/8/28 11:26
 * @Version: 1.0
 **/
public class Main {

    public static void main(String[] args) {
        String mousetype = "dell";

        //1、简单工厂模式
        MouseFactory factory = new MouseFactory();
        Mouse mouse = factory.createMouse(mousetype);
        mouse.say();

        //2、工厂方法模式
        pattern.factoryPattern.factory.MouseFactory factory1 = FactoryProducer.createFactory(mousetype);
        Mouse mouse1 = factory1.createMouse();
        mouse1.say();

        //3、抽象工厂模式
        AbstractFactory factory2 = pattern.factoryPattern.abstarctFactory.FactoryProducer.getFactory("color");
        Color red = factory2.getColor("red");


    }

}
