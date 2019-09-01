package javaBasic.Practice.threadpool;

/**
 * @Author: zhouwei
 * @Description: 拒绝策略异常
 * @Date: 2019/8/30 15:38
 * @Version: 1.0
 **/
public class RunnableDenyPolicyException extends RuntimeException {

    public RunnableDenyPolicyException(String message) {
        super(message);
    }
}
