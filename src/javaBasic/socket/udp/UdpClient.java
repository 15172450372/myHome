//package javaBasic.socket.udp;
//
//import org.apache.commons.io.FileUtils;
//
//import java.io.File;
//import java.net.DatagramPacket;
//import java.net.DatagramSocket;
//import java.net.InetSocketAddress;
//
///**
// * @Author: zhouwei
// * @Description:
// * @Date: 2019/8/7 16:01
// * @Version: 1.0
// **/
//public class UdpClient {
//
//    public static void main(String[] args) throws Exception {
//
//        System.out.println("数据发送中...");
//        //构建客户端
//        DatagramSocket client = new DatagramSocket(9999);
//
//        //准备数据
//        String path = "src/javabasic/socket/udp/1.jpg";
//        byte[] bytes = FileUtils.readFileToByteArray(new File(path));
//
//        //构建数据包,UDP通过数据包进行数据传输
//        InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost", 8888);
//        DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length, inetSocketAddress);
//
//        //发送数据包
//        client.send(datagramPacket);
//
//        client.close();
//    }
//
//}
