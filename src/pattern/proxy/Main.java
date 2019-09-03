package pattern.proxy;

/**
 * @Descript: 代理模式
 * @Author: zhouwei
 * @Date: 19-6-17 下午4:56
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");

        image.display();
        System.out.println("");
        image.display();
    }

}
