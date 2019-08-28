package pattern.factoryPattern.simpleFactory;

import pattern.factoryPattern.factory.DellMouse;
import pattern.factoryPattern.factory.HPMouse;

/**
 * @Author: zhouwei
 * @Description:
 * @Date: 2019/8/28 11:29
 * @Version: 1.0
 **/
public class MouseFactory {

    public Mouse createMouse(String mouseType) {
        if ("dell".equalsIgnoreCase(mouseType)) {
            return new DellMouse();
        } else if ("hp".equalsIgnoreCase(mouseType)) {
            return new HPMouse();
        } else {
            return null;
        }
    }

}
