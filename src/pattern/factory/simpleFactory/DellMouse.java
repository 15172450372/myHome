package pattern.factory.simpleFactory;

/**
 * @Author: zhouwei
 * @Description:
 * @Date: 2019/8/28 11:32
 * @Version: 1.0
 **/
public class DellMouse implements Mouse {
    @Override
    public void say() {
        System.out.println("DellMouse");
    }
}
