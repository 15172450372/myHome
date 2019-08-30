package pattern.factory.factory;

import pattern.factory.simpleFactory.Mouse;

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
