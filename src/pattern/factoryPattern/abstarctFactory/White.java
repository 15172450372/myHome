package pattern.factoryPattern.abstarctFactory;

/**
 * @Author: zhouwei
 * @Description:
 * @Date: 2019/8/28 12:10
 * @Version: 1.0
 **/
public class White implements Color {
    @Override
    public void fill() {
        System.out.println("Inside White::fill() method.");
    }
}
