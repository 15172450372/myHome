package pattern.factoryPattern.abstarctFactory;

/**
 * @Author: zhouwei
 * @Description:
 * @Date: 2019/8/28 12:10
 * @Version: 1.0
 **/
public class Black implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Black::fill() method.");
    }
}
