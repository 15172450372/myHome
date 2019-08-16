package javabasic.socket.tcp.chat03;

import java.io.*;
import java.net.Socket;

/**
 * @Author: zhouwei
 * @Description:
 * @Date: 2019/8/9 20:27
 * @Version: 1.0
 **/
public class ChatClient {

    public static void main(String[] args) throws IOException {

        System.out.println("------Client------");

        Socket socket = new Socket("127.0.0.1",8888);

        new Thread(new Send(socket)).start();
        new Thread(new Receive(socket)).start();

    }

}
