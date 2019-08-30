package pattern.factory.abstarctFactory;

/**
 * @Author: zhouwei
 * @Description:
 * @Date: 2019/8/28 12:09
 * @Version: 1.0
 **/
public class Red implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}
