package pattern.proxy;

/**
 * @Descript:
 * @Author: zhouwei
 * @Date: 19-6-17 下午4:59
 * @Version 1.0
 */
public class ProxyImage implements Image {

    private String name;
    private RealImage realImage;

    public ProxyImage(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(name);
        }
        realImage.display();
    }

}
