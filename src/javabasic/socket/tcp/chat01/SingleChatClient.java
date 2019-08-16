package javabasic.socket.tcp.chat01;

import java.io.*;
import java.net.Socket;

/**
 * @Author: zhouwei
 * @Description: 单人聊天室 Client
 * @Date: 2019/8/9 16:54
 * @Version: 1.0
 **/
public class SingleChatClient {

    public static void main(String[] args) throws IOException {

        System.out.println("------Client------");

        Socket socket = new Socket("127.0.0.1",8888);

        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        while (true) {
            //发送消息
            String msg = br.readLine();
            dos.writeUTF(msg);
            dos.flush();

            //接收消息
            String msg1 = dis.readUTF();
            System.out.println(msg1);

            if ("exit".equalsIgnoreCase(msg)) {
                break;
            }
        }
        br.close();
        dos.close();
        socket.close();

    }

}
