package javabasic.socket.udp;

import com.sun.javafx.binding.StringFormatter;
import javabasic.util.FileUtils;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Arrays;

/**
 * @Author: zhouwei
 * @Description:
 * @Date: 2019/8/7 16:02
 * @Version: 1.0
 **/
public class UdpServer {

    public static void main(String[] args) throws IOException {

        System.out.println("数据接收中...");
        //构建服务端
        DatagramSocket server = new DatagramSocket(8888);

        //准备容器接受数据
        byte[] container = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(container, 0, container.length);

        //接收数据(阻塞)
        server.receive(datagramPacket);

        //解析数据
        byte[] data = datagramPacket.getData();
        FileUtils.byte2File(data,"C:/Users/13701/Pictures/Saved Pictures","copy.jpg");
        //System.out.println(new String(data,0,data.length));

        //释放资源
        server.close();

    }

}
