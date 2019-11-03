package pattern.actual.vipCost;

import java.math.BigDecimal;

/**
 * @Author: zhouwei
 * @Description: 普通用户
 * @Date: 2019/11/3 下午10:05
 * @Version: 1.0
 **/
public class NormalPayService implements UserPayService {

    @Override
    public BigDecimal quote(BigDecimal orderPrice) {
        return orderPrice;
    }
}
