package pattern.factory.abstarctFactory;

/**
 * @Author: zhouwei
 * @Description:
 * @Date: 2019/8/28 12:15
 * @Version: 1.0
 **/
public class ColorFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shape) {
        return null;
    }

    @Override
    public Color getColor(String color) {

        if ("red".equalsIgnoreCase(color)) {
            return new Red();
        } else if ("black".equalsIgnoreCase(color)) {
            return new Black();
        } else if ("white".equalsIgnoreCase(color)) {
            return new White();
        } else {
            throw new RuntimeException("illegal input [No Such Color]: " + color);
        }

    }
}
