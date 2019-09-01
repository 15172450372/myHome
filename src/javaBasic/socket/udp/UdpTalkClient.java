package javaBasic.socket.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @Author: zhouwei
 * @Description: 聊天客户端
 * @Date: 2019/8/9 12:28
 * @Version: 1.0
 **/
public class UdpTalkClient {

    public static void main(String[] args) throws IOException {
        System.out.println("发送方准备中...");
        //构建客户端
        DatagramSocket client = new DatagramSocket(9999);

        while (true) {
            //准备数据
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String msg = bufferedReader.readLine();
            byte[] datas = msg.getBytes();

            //构建数据包
            InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost", 8888);
            DatagramPacket datagramPacket = new DatagramPacket(datas, 0, datas.length, inetSocketAddress);

            //发送数据包
            client.send(datagramPacket);

            //退出聊天
            if (msg.equalsIgnoreCase("exit")) {
                break;
            }
        }

        client.close();
    }

}
