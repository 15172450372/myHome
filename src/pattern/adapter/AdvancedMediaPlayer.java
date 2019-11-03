package pattern.adapter;

/**
 * @Descript: 高级媒体播放器
 * @Author: zhouwei
 * @Date: 19-6-17 下午5:36
 * @Version 1.0
 */
public interface AdvancedMediaPlayer {

    void playVlc(String fileName);

    void playMp4(String fileName);

}
