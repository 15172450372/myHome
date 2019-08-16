package javabasic.socket.tcp.chat04;

import com.sun.deploy.util.StringUtils;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

import static javabasic.socket.tcp.chat04.KeyWord.EXIT;

/**
 * @Author: zhouwei
 * @Description: 群聊
 * @Date: 2019/8/9 20:27
 * @Version: 1.0
 **/
public class ChatServer {

    private static CopyOnWriteArrayList<Channel> channels = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws IOException {

        System.out.println("------Server------");

        ServerSocket server = new ServerSocket(9999);

        while (true) {
            Socket socket = server.accept();
            System.out.println("连接到一个客户端");
            Channel channel = new Channel(socket);
            channels.add(channel);
            channel.sendMsg("欢迎来到聊天室！");
            channel.sendOthersMsg(channel.name + ",来到聊天室",true);
            new Thread(channel).start();
        }
    }

    static class Channel implements Runnable {

        private Socket socket;
        private DataInputStream dis;
        private DataOutputStream dos;
        private boolean isRunning;
        private String name;

        Channel(Socket socket) {
            this.socket = socket;
            try {
                dis = new DataInputStream(socket.getInputStream());
                dos = new DataOutputStream(socket.getOutputStream());
                isRunning = true;
                String name = readMsg();
                this.name = name;
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
                e.printStackTrace();
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
                e.printStackTrace();
                release();
            }
        }

        //发送消息,群聊
        public void sendOthersMsg(String msg, boolean isSystemMsg) {
            for (Channel other:channels) {
                if (other==this) {
                    continue;
                }
                if (isSystemMsg) {
                    other.sendMsg(msg);
                } else {
                    other.sendMsg(name + ": " + msg);
                }
            }
        }

        //释放资源
        public void release(Closeable... targets) {
            this.isRunning = false;
            ReleaseUtil.release(targets);
            channels.remove(this);
            sendOthersMsg(this.name + "退出了聊天室", true);
        }

        @Override
        public void run() {
            while (isRunning) {
                String msg = readMsg();
                processMsg(msg);
            }
        }

        /**
         * 处理消息
         * @param msg
         */
        private void processMsg(String msg) {
            if (EXIT.equals(msg)) {
                sendMsg(EXIT);
                release(dis,dos);
                isRunning = false;
            }
            if (!msg.equals("")) {
                if (msg.startsWith("@")) {
                    //私聊
                    int index = msg.indexOf(":");
                    String name = msg.substring(1,index);
                    String content = msg.substring(index+1,msg.length());
                    for (Channel channel:channels) {
                        if (channel.name.equals(name)) {
                            channel.sendMsg(this.name + " 悄悄对你说:" + content);
                            break;
                        }
                    }
                } else {
                    //群聊
                    sendOthersMsg(msg,false);
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
