package java.socket.udp;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @Author: zhouwei
 * @Description: 聊天服务端
 * @Date: 2019/8/9 12:28
 * @Version: 1.0
 **/
public class UdpTalkServer {

    public static void main(String[] args) throws IOException {

        System.out.println("接收方接收中...");

        DatagramSocket server = new DatagramSocket(8888);

        while (true) {
            byte[] container = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(container, 0, container.length);

            server.receive(datagramPacket);
            byte[] data = datagramPacket.getData();
            int length = datagramPacket.getLength();
            String msg = new String(data,0,length);
            System.out.println(msg);

            if (msg.equals("exit")) {
                break;
            }
        }
        server.close();
    }

}
