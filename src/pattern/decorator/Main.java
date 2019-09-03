package pattern.decorator;

/**
 * @Descript: 装饰器模式
 * @Author: zhouwei
 * @Date: 19-6-17 下午5:43
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {

        Shape rectangle = new Rectangle();
        rectangle.draw();

        rectangle = new RedShapeDecorator(rectangle);
        rectangle.draw();
    }

}
