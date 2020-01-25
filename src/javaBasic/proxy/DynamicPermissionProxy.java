package javaBasic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: zhouwei
 * @Description: JDK动态代理-代理权限校验功能
 * @Date: 2020/1/25 下午8:33
 * @Version: 1.0
 **/
public class DynamicPermissionProxy implements InvocationHandler {

    //被代理对象
    private Object target;

    public DynamicPermissionProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("这里是权限校验切面，校验开始......");
        Object invoke = method.invoke(target, args);
        System.out.println("这里是权限校验切面，校验结束......");
        return invoke;
    }
}
