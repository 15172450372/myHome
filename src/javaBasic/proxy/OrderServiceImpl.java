package javaBasic.proxy;

/**
 * @Author: zhouwei
 * @Description: 业务实现类
 * @Date: 2020/1/25 下午5:38
 * @Version: 1.0
 **/
public class OrderServiceImpl implements OrderService {

    @Override
    public void reduceStock(String id) {
        try {
            System.out.println("预减库存中......");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
