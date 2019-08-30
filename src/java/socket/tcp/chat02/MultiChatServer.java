package java.socket.tcp.chat02;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: zhouwei
 * @Description: 多人单聊
 * @Date: 2019/8/9 17:50
 * @Version: 1.0
 **/
public class MultiChatServer {

    public static void main(String[] args) throws IOException {

        System.out.println("------Server------");

        ServerSocket server = new ServerSocket(8888);

        while (true) {
            Socket socket = server.accept();
            System.out.println("连接到一个客户端");

            new Thread(()->{

                DataInputStream dis = null;
                DataOutputStream dos = null;
                try {
                    dis = new DataInputStream(socket.getInputStream());
                    dos = new DataOutputStream(socket.getOutputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                boolean isRunning = true;
                while (isRunning) {
                    //接收消息
                    String msg = null;
                    try {
                        msg = dis.readUTF();
                    } catch (IOException e) {
                        e.printStackTrace();
                        isRunning = false;
                    }
                    //返回消息
                    try {
                        dos.writeUTF(msg);
                    } catch (IOException e) {
                        e.printStackTrace();
                        isRunning = false;
                    }

                    if ("exit".equalsIgnoreCase(msg)) {
                        break;
                    }
                }
                //释放资源
                try {
                    if (dos != null) {
                        dos.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if (dis != null) {
                        dis.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if (socket != null) {
                        socket.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }).start();
        }

    }

}
