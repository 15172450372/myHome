package pattern.factoryPattern.abstarctFactory;

/**
 * @Author: zhouwei
 * @Description:
 * @Date: 2019/8/28 12:06
 * @Version: 1.0
 **/
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
