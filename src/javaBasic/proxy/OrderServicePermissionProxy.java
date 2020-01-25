package javaBasic.proxy;

/**
 * @Author: zhouwei
 * @Description: 聚合方式实现的静态代理-权限校验
 * @Date: 2020/1/25 下午5:50
 * @Version: 1.0
 **/
public class OrderServicePermissionProxy implements OrderService{

    private OrderService orderService;

    public OrderServicePermissionProxy(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void reduceStock(String id) {
        System.out.println("权限校验开始......");
        orderService.reduceStock(id);
        System.out.println("权限校验结束......");
    }
}
