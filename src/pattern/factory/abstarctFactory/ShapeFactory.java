package pattern.factory.abstarctFactory;

/**
 * @Author: zhouwei
 * @Description:
 * @Date: 2019/8/28 12:13
 * @Version: 1.0
 **/
public class ShapeFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shape) {
        if ("rectangle".equalsIgnoreCase(shape)) {
            return new Rectangle();
        } else if ("circle".equalsIgnoreCase(shape)) {
            return new Circle();
        } else if ("square".equalsIgnoreCase(shape)) {
            return new Square();
        } else {
            throw new RuntimeException("illegal input [No Such Color]: " + shape);
        }
    }

    @Override
    public Color getColor(String color) {
        return null;
    }
}
