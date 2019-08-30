package java.socket.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: zhouwei
 * @Description: tcp消息传输服务端
 * @Date: 2019/8/7 16:24
 * @Version: 1.0
 **/
public class TcpServer {

    public static void main(String[] args) throws IOException {

        System.out.println("服务端启动。。。");

        ServerSocket server = new ServerSocket(8888);

        Socket socket = server.accept();

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        String msg = dis.readUTF();
        System.out.println(msg);

        dis.close();
        dis.close();
    }

}
