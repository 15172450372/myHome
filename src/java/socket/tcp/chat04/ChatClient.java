package java.socket.tcp.chat04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("input your name:");
        String name = br.readLine();
        Socket socket = new Socket("127.0.0.1",9999);

        new Thread(new Send(socket,name)).start();
        new Thread(new Receive(socket)).start();

    }

}
