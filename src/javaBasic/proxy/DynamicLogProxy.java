package javaBasic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: zhouwei
 * @Description: JDK动态代理-代理日志功能，代理类需实现InvocationHandler接口
 * @Date: 2020/1/25 下午5:57
 * @Version: 1.0
 **/
public class DynamicLogProxy implements InvocationHandler {

    //需要代理的对象类
    private Object target;

    public DynamicLogProxy(Object target) {
        this.target = target;
    }

    /**
     *
     * @param proxy   被代理对象
     * @param method  对象方法
     * @param args    方法参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("这里是日志记录切面，日志开始......");
        Object invoke = method.invoke(target, args);
        System.out.println("这里是日志记录切面，日志结束......");
        return invoke;
    }

}
