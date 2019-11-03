package pattern.actual.vipCost;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: zhouwei
 * @Description: 策略工厂类
 * @Date: 2019/11/3 下午10:20
 * @Version: 1.0
 **/
public class UserPayServiceStrategyFactory {

    private static Map<String, UserPayService> services = new ConcurrentHashMap<>();

    public static UserPayService getByUserType(String type) {
        return services.get(type);
    }

    public static void register(String type, UserPayService userPayService) {
        services.put(type,userPayService);
    }

}
