package javabasic.socket.tcp.chat04;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import static javabasic.socket.tcp.chat04.KeyWord.EXIT;

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
    private String name;

    public Send(Socket socket, String name) {
        this.socket = socket;
        try {
            dos = new DataOutputStream(socket.getOutputStream());
            console = new BufferedReader(new InputStreamReader(System.in));
            isRunning = true;
            this.name = name;
            sendMsg(name);
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

    /**
     * 发消息
     * @param msg
     */
    public void sendMsg(String msg) {
        try {
            dos.writeUTF(msg);
            dos.flush();
            if (EXIT.equals(msg)) {
                isRunning = false;
                ReleaseUtil.release(dos);
            }
        } catch (IOException e) {
            ReleaseUtil.release(dos,socket);
        }
    }

    /**
     * 从控制台获取信息
     * @return
     */
    private String getStrFromConsole() {
        try {
            return console.readLine();
        } catch (IOException e) {
            ReleaseUtil.release(dos,socket);
        }
        return "";
    }

}
