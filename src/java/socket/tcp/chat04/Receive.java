package java.socket.tcp.chat04;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import static java.socket.tcp.chat04.KeyWord.EXIT;

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
            processMsg(msg);
        }
    }

    /**
     * 处理消息
     */
    private void processMsg(String msg) {
        if (EXIT.equals(msg)) {
            isRunning = false;
            ReleaseUtil.release(dis,socket);
            System.out.println("已退出聊天室！");
        } else {
            if (!msg.equals("")) {
                System.out.println(msg);
            }
        }
    }

    /**
     * 收消息
     * @return
     */
    private String readMsg() {
        String msg = "";
        try {
            msg = dis.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
            ReleaseUtil.release(dis, socket);
        }
        return msg;
    }

}
