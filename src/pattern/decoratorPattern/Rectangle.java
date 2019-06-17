package pattern.decoratorPattern;

/**
 * @Descript:
 * @Author: zhouwei
 * @Date: 19-6-17 下午5:45
 * @Version 1.0
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("shape: Rectangle");
    }

}
