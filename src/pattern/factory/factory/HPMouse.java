package pattern.factory.factory;

import pattern.factory.simpleFactory.Mouse;

/**
 * @Author: zhouwei
 * @Description:
 * @Date: 2019/8/28 11:33
 * @Version: 1.0
 **/
public class HPMouse implements Mouse {
    @Override
    public void say() {
        System.out.println("HPMouse");
    }
}
