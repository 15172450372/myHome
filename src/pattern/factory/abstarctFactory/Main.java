package pattern.factory.abstarctFactory;

/**
 * @Author: zhouwei
 * @Description:
 * @Date: 2019/8/28 12:23
 * @Version: 1.0
 **/
public class Main {

    public static void main(String[] args) {
        AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");
        Shape circle = shapeFactory.getShape("circle");
        circle.draw();

        AbstractFactory colorFactory = FactoryProducer.getFactory("color");
        Color red = colorFactory.getColor("red");
        red.fill();

    }

}
