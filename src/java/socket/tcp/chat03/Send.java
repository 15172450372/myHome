package java.socket.tcp.chat03;

import java.io.*;
import java.net.Socket;

/**
 * @Author: zhouwei
 * @Description: 发送消息
 * @Date: 2019/8/11 10:01
 * @Version: 1.0
 **/
public class Send implements Runnable {

    private DataOutputStream dos;
    private Socket socket;
    private BufferedReader console;
    private boolean isRunning;

    public Send(Socket socket) {
        this.socket = socket;
        try {
            dos = new DataOutputStream(socket.getOutputStream());
            console = new BufferedReader(new InputStreamReader(System.in));
            isRunning = true;
        } catch (IOException e) {
            e.printStackTrace();
            ReleaseUtil.release(dos,socket);
        }
    }

    @Override
    public void run() {
        while (isRunning) {
            String msg = getStrFromConsole();
            sendMsg(msg);
        }
    }

    //发送消息
    public void sendMsg(String msg) {
        try {
            dos.writeUTF(msg);
            dos.flush();
        } catch (IOException e) {
            ReleaseUtil.release(dos,socket);
        }
    }

    private String getStrFromConsole() {
        try {
            return console.readLine();
        } catch (IOException e) {
            ReleaseUtil.release(dos,socket);
        }
        return "";
    }

}
