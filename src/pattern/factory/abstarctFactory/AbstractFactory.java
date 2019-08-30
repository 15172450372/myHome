package pattern.factory.abstarctFactory;

/**
 * @Author: zhouwei
 * @Description:
 * @Date: 2019/8/28 12:11
 * @Version: 1.0
 **/
public abstract class AbstractFactory {

    public abstract Shape getShape(String shape);

    public abstract Color getColor(String color);

}
