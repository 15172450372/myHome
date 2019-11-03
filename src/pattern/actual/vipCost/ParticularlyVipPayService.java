package pattern.actual.vipCost;

import java.math.BigDecimal;

/**
 * @Author: zhouwei
 * @Description: 专属会员
 * @Date: 2019/11/3 下午9:34
 * @Version: 1.0
 **/
public class ParticularlyVipPayService implements UserPayService {

    private static final BigDecimal PRICE_LINE = BigDecimal.valueOf(30);

    @Override
    public BigDecimal quote(BigDecimal orderPrice) {
        if (orderPrice.compareTo(PRICE_LINE) > 0) {
            return orderPrice.multiply(BigDecimal.valueOf(0.7));
        }
        return orderPrice;
    }

}
