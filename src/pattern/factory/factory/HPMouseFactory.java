package pattern.factory.factory;

import pattern.factory.simpleFactory.Mouse;

/**
 * @Author: zhouwei
 * @Description:
 * @Date: 2019/8/28 11:41
 * @Version: 1.0
 **/
public class HPMouseFactory implements MouseFactory {
    @Override
    public Mouse createMouse() {
        return new HPMouse();
    }
}
