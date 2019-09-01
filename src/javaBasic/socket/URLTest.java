package javaBasic.socket;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * @Author: zhouwei
 * @Description:
 * @Date: 2019/8/9 11:55
 * @Version: 1.0
 **/
public class URLTest {

    public static void main(String[] args) throws IOException {
        test01();
    }

    public static void test01() throws IOException {
        //1.获取url
        URL url = new URL("http://www.jd.com");
        //2.得到输入流
        InputStream is = url.openStream();
        //URLConnection urlConnection = (HttpURLConnection) url.openConnection();
        //urlConnection.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.87 Safari/537.36");
        //InputStream is = urlConnection.getInputStream();
        BufferedReader bf = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
        //3.分析数据
        String msg;
        while ((msg=bf.readLine()) != null) {
            System.out.println(msg);
        }
        //4.处理数据
        //TODO：。。。
        //5.关闭资源
        if (is != null) {
            is.close();
        }
        bf.close();

    }

}
