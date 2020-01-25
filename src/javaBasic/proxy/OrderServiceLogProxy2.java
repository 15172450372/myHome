package javaBasic.proxy;

/**
 * @Author: zhouwei
 * @Description: 聚合方式实现的静态代理-日志
 * @Date: 2020/1/25 下午5:45
 * @Version: 1.0
 **/
public class OrderServiceLogProxy2 implements OrderService {

    private OrderService orderService;

    public OrderServiceLogProxy2(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void reduceStock(String id) {
        System.out.println("预减库存开始......");
        orderService.reduceStock(id);
        System.out.println("预减库存结束......");
    }

}
