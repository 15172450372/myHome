package pattern.actual.vipCost;

import java.math.BigDecimal;

/**
 * @Author: zhouwei
 * @Description: 普通会员
 * @Date: 2019/11/3 下午10:00
 * @Version: 1.0
 **/
public class VipPayService implements UserPayService {

    @Override
    public BigDecimal quote(BigDecimal orderPrice) {
        //TODO:该超级会员用户刚过期且尚未使用临时折扣
        if (1<0) {
            //TODO:更新临时折扣数，发送通知引导用户再次开通会员
            return orderPrice.multiply(BigDecimal.valueOf(0.8));
        }
        return orderPrice.multiply(BigDecimal.valueOf(0.9));
    }
}
