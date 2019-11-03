package pattern.actual.vipCost;

import java.math.BigDecimal;

/**
 * @Author: zhouwei
 * @Description:
 * @Date: 2019/11/3 下午10:06
 * @Version: 1.0
 **/
public class Test {

    public static void main(String[] args) {

        BigDecimal price = BigDecimal.valueOf(3);
        System.out.println("商品原价为：" + price);

        UserPayService strategy = new SuperVipPayService();
        BigDecimal quote = strategy.quote(price);
        System.out.println("超级会员商品的最终价格为：" + quote);

        UserPayService strategy1 = new ParticularlyVipPayService();
        BigDecimal quote1 = strategy1.quote(price);
        System.out.println("专属会员商品的最终价格为：" + quote1);

        UserPayService strategy2 = new VipPayService();
        BigDecimal quote2 = strategy2.quote(price);
        System.out.println("普通会员商品的最终价格为：" + quote2);

        UserPayService strategy3 = new NormalPayService();
        BigDecimal quote3 = strategy3.quote(price);
        System.out.println("普通用户商品的最终价格为：" + quote3);

        User user = new User(1,"vip");
        calPrice(price,user);
        calPrice2(price,user);

    }

    public static BigDecimal calPrice(BigDecimal price, User user) {
        BigDecimal finalPrice = null;
        String vipType = user.getType();
        if (vipType.equals("超级会员")) {
            finalPrice = new SuperVipPayService().quote(price);
        } else if (vipType.equals("专属会员")) {
            finalPrice = new ParticularlyVipPayService().quote(price);
        } else if (vipType.equals("普通会员")) {
            finalPrice = new VipPayService().quote(price);
        } else {
            finalPrice = price;
        }
        return finalPrice;
    }

    /**
     * 应用工厂模式
     * @param price
     * @param user
     * @return
     */
    public static BigDecimal calPrice2(BigDecimal price, User user) {
        String vipType = user.getType();
        UserPayService strategy = UserPayServiceStrategyFactory.getByUserType(vipType);
        return strategy.quote(price);
    }

}
