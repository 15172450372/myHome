package javaBasic.proxy;

/**
 * @Author: zhouwei
 * @Description: 继承方式实现的静态代理-日志
 * @Date: 2020/1/25 下午5:41
 * @Version: 1.0
 **/
public class OrderServiceLogProxy extends OrderServiceImpl{

    @Override
    public void reduceStock(String id) {
        System.out.println("预减库存开始......");
        super.reduceStock(id);
        System.out.println("预减库存结束......");
    }
}
