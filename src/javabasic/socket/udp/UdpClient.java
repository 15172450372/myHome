package javabasic.socket.udp;

import javabasic.util.FileUtils;
import sun.security.krb5.internal.PAData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.*;

/**
 * @Author: zhouwei
 * @Description:
 * @Date: 2019/8/7 16:01
 * @Version: 1.0
 **/
public class UdpClient {

    public static void main(String[] args) throws Exception {

        System.out.println("数据发送中...");
        //构建客户端
        DatagramSocket client = new DatagramSocket(9999);

        //准备数据
        //String data = "啦啦啦啦";
        //byte[] bytes = data.getBytes();
        String path = "C:/Users/13701/Pictures/Saved Pictures/1.jpg";
        byte[] bytes = FileUtils.File2byte(path);

        //构建数据包
        InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost", 8888);
        DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length, inetSocketAddress);

        //发送数据包
        client.send(datagramPacket);

        client.close();
    }

}
