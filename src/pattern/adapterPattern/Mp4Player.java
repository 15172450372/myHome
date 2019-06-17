package pattern.adapterPattern;

/**
 * @Descript:
 * @Author: zhouwei
 * @Date: 19-6-17 下午5:28
 * @Version 1.0
 */
public class Mp4Player implements AdvancedMediaPlayer {

    @Override
    public void playVcl(String fileName) {

    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: "+ fileName);
    }
}
