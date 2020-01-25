package javaBasic.proxy;

import java.lang.reflect.Proxy;

/**
 * @Author: zhouwei
 * @Description:
 * @Date: 2020/1/25 下午5:36
 * @Version: 1.0
 **/
public class Main {

    public static void main(String[] args) {
        //test01();
        //test02();
        //test03();
        //test04();
        test05();
    }

    /**
     * 测试继承方式实现的静态代理
     */
    public static void test01() {
        OrderServiceLogProxy proxy = new OrderServiceLogProxy();
        proxy.reduceStock("123");
    }

    /**
     * 测试聚合方式实现的静态代理
     */
    public static void test02() {
        OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
        OrderServiceLogProxy2 proxy = new OrderServiceLogProxy2(orderServiceImpl);
        proxy.reduceStock("123");
    }

    /**
     * 测试聚合方式实现的静态代理-功能叠加
     */
    public static void test03() {
        OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
        OrderServiceLogProxy2 logProxy = new OrderServiceLogProxy2(orderServiceImpl);
        OrderServicePermissionProxy permissionProxy = new OrderServicePermissionProxy(logProxy);
        permissionProxy.reduceStock("123");
    }

    /**
     * 测试JDK动态代理实现日志代理类
     */
    public static void test04() {
        OrderServiceImpl orderService = new OrderServiceImpl();
        Class<? extends OrderServiceImpl> clazz = orderService.getClass();
        DynamicLogProxy logProxyHandler = new DynamicLogProxy(orderService);
        OrderService os = (OrderService) Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),logProxyHandler);
        os.reduceStock("123");
    }

    /**
     * 测试JDK动态代理实现日志代理类-功能叠加
     */
    public static void test05() {
        //日志代理类
        OrderServiceImpl orderService = new OrderServiceImpl();
        Class<? extends OrderServiceImpl> clazz = orderService.getClass();
        DynamicLogProxy logProxyHandler = new DynamicLogProxy(orderService);
        OrderService os = (OrderService) Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),logProxyHandler);

        //权限代理类
        Class<? extends OrderService> clazz2 = os.getClass();
        DynamicPermissionProxy permissionProxy = new DynamicPermissionProxy(os);
        OrderService os2 = (OrderService) Proxy.newProxyInstance(clazz2.getClassLoader(), clazz2.getInterfaces(), permissionProxy);

        os2.reduceStock("123");
    }






}
