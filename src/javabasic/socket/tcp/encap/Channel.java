package javabasic.socket.tcp.encap;

import java.io.Closeable;
import java.io.IOException;

/**
 * @Author: zhouwei
 * @Description: 一个客户端对应一个Channel
 * @Date: 2019/8/9 20:23
 * @Version: 1.0
 **/
public class Channel {

    /**
     * 接收消息
     * @return
     */
    public String readMsg() {
        return null;
    }

    //发送消息
    public void sendMsg(String msg) {

    }

    //释放资源
    public void release(Closeable... targets) {
        for (Closeable target:targets) {
            try {
                if (target != null) {
                    target.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
