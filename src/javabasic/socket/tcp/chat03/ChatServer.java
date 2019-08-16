package javabasic.socket.tcp.chat03;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: zhouwei
 * @Description: 封装
 * @Date: 2019/8/9 20:27
 * @Version: 1.0
 **/
public class ChatServer {

    private static CopyOnWriteArrayList<Channel> channels = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws IOException {

        System.out.println("------Server------");

        ServerSocket server = new ServerSocket(8888);

        while (true) {
            Socket socket = server.accept();
            System.out.println("连接到一个客户端");
            new Thread(new Channel(socket)).start();
        }
    }

    static class Channel implements Runnable {

        private Socket socket;
        private DataInputStream dis;
        private DataOutputStream dos;
        private boolean isRunning;

        Channel(Socket socket) {
            this.socket = socket;
            try {
                dis = new DataInputStream(socket.getInputStream());
                dos = new DataOutputStream(socket.getOutputStream());
                isRunning = true;
            } catch (IOException e) {
                //e.printStackTrace();
                release();
            }
        }

        /**
         * 接收消息
         * @return
         */
        public String readMsg() {
            String msg = "";
            try {
                msg = dis.readUTF();
            } catch (IOException e) {
                //e.printStackTrace();
                release();
            }
            return msg;
        }

        //发送消息
        public void sendMsg(String msg) {
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                //e.printStackTrace();
                release();
            }
        }

        //发送消息,群聊
        public void sendOthersMsg(String msg) {
            try {
                for (Channel channel:channels) {
                    if (channel==this) {
                        continue;
                    }
                    channel.sendMsg(msg);
                }
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                //e.printStackTrace();
                release();
            }
        }

        //释放资源
        public void release(Closeable... targets) {
            this.isRunning = false;
            ReleaseUtil.release(targets);
        }

        @Override
        public void run() {
            while (isRunning) {
                String msg = readMsg();
                if (!msg.equals("")) {
                    sendMsg(msg);
                }
            }
        }

        public Socket getSocket() {
            return socket;
        }
        public void setSocket(Socket socket) {
            this.socket = socket;
        }
        public DataInputStream getDis() {
            return dis;
        }
        public void setDis(DataInputStream dis) {
            this.dis = dis;
        }
        public DataOutputStream getDos() {
            return dos;
        }
        public void setDos(DataOutputStream dos) {
            this.dos = dos;
        }

    }


}
