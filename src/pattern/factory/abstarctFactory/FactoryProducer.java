package pattern.factory.abstarctFactory;

/**
 * @Author: zhouwei
 * @Description: 工厂选择器
 * @Date: 2019/8/28 12:18
 * @Version: 1.0
 **/
public class FactoryProducer {

    public static AbstractFactory getFactory(String type) {
        if ("color".equalsIgnoreCase(type)) {
            return new ColorFactory();
        } else if ("shape".equalsIgnoreCase(type)) {
            return new ShapeFactory();
        } else {
            throw new RuntimeException("illegal input [No Such Factory]: " + type);
        }
    }

}
