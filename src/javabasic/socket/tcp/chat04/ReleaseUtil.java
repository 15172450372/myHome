package javabasic.socket.tcp.chat04;

import java.io.Closeable;
import java.io.IOException;

/**
 * @Author: zhouwei
 * @Description:
 * @Date: 2019/8/15 17:43
 * @Version: 1.0
 **/
public class ReleaseUtil {

    //释放资源
    public static void release(Closeable... targets) {
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
