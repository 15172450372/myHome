package java.socket.tcp.chat03;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @Author: zhouwei
 * @Description: 接收消息
 * @Date: 2019/8/11 10:00
 * @Version: 1.0
 **/
public class Receive implements Runnable {

    private Socket socket;
    private DataInputStream dis;
    private boolean isRunning;

    public Receive(Socket socket) {
        this.socket = socket;
        isRunning = true;
        try {
            dis = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            ReleaseUtil.release(dis,socket);
        }
    }

    @Override
    public void run() {
        while (isRunning) {
            String msg = readMsg();
            if (!msg.equals("")) {
                System.out.println(msg);
            }
        }
    }

    private String readMsg() {
        String msg = "";
        try {
            msg = dis.readUTF();
        } catch (IOException e) {
            //e.printStackTrace();
            ReleaseUtil.release(dis,socket);
        }
        return msg;
    }


}
