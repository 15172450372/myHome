package java.socket.udp;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

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
        byte[] container = new byte[1024*10];
        DatagramPacket datagramPacket = new DatagramPacket(container, 0, container.length);

        //接收数据(阻塞)
        server.receive(datagramPacket);

        //解析数据
        byte[] data = datagramPacket.getData();
        FileUtils.writeByteArrayToFile(new File("src/javabasic/socket/udp/2.jpg"),data);

        //释放资源
        server.close();

    }

}
