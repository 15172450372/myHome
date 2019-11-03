package pattern.actual.vipCost;

import java.math.BigDecimal;

/**
 * @Author: zhouwei
 * @Description: 超级会员
 * @Date: 2019/11/3 下午9:53
 * @Version: 1.0
 **/
public class SuperVipPayService implements UserPayService {

    @Override
    public BigDecimal quote(BigDecimal orderPrice) {
        return orderPrice.multiply(BigDecimal.valueOf(0.8));
    }
}
