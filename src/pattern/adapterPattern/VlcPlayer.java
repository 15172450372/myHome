package pattern.adapterPattern;

/**
 * @Descript:
 * @Author: zhouwei
 * @Date: 19-6-17 下午5:27
 * @Version 1.0
 */
public class VlcPlayer implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vcl file. Name: "+ fileName);
    }

    @Override
    public void playMp4(String fileName) {

    }
}
