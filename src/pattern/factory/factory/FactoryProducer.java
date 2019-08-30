package pattern.factory.factory;

/**
 * @Author: zhouwei
 * @Description:
 * @Date: 2019/8/28 12:00
 * @Version: 1.0
 **/
public class FactoryProducer {

    public static MouseFactory createFactory(String type) {
        if ("dell".equalsIgnoreCase(type)) {
            return new DellMouseFactory();
        } else if ("hp".equalsIgnoreCase(type)) {
            return new HPMouseFactory();
        } else {
            throw new RuntimeException("illegal input");
        }
    }

}
