package java.socket.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author: zhouwei
 * @Description: tcp消息传输客户端
 * @Date: 2019/8/7 16:24
 * @Version: 1.0
 **/
public class TcpClient {

    public static void main(String[] args) throws IOException {

        System.out.println("客户端启动。。。");

        Socket socket = new Socket("127.0.0.1",8888);

        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(outputStream);
        dos.writeUTF("愿我如星君如月，夜夜流光相皎洁");
        dos.flush();

        dos.close();
        socket.close();
    }

}
