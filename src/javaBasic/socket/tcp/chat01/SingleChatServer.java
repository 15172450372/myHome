package javaBasic.socket.tcp.chat01;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: zhouwei
 * @Description: 单聊
 * @Date: 2019/8/9 16:54
 * @Version: 1.0
 **/
public class SingleChatServer {

    public static void main(String[] args) throws IOException {

        System.out.println("------Server------");

        ServerSocket server = new ServerSocket(8888);
        Socket socket = server.accept();

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        while (true) {
            //接收消息
            String msg = dis.readUTF();
            //返回消息
            dos.writeUTF(msg);

            if ("exit".equalsIgnoreCase(msg)) {
                break;
            }
        }
        dis.close();
        dos.close();
        socket.close();
    }

}
