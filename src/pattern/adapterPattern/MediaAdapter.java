package pattern.adapterPattern;


/**
 * @Descript: 适配器类
 * @Author: zhouwei
 * @Date: 19-6-17 下午5:29
 * @Version 1.0
 */
public class MediaAdapter implements MediaPlayer {

    private AdvancedMediaPlayer mediaPlayer;

    public MediaAdapter(String audioType) {
        if ("vlc".equalsIgnoreCase(audioType)) {
            mediaPlayer = new VlcPlayer();
        } else if ("mp4".equalsIgnoreCase(audioType)) {
            mediaPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if ("vlc".equalsIgnoreCase(audioType)) {
            mediaPlayer.playVlc(fileName);
        } else if ("mp4".equalsIgnoreCase(audioType)) {
            mediaPlayer.playMp4(fileName);
        } else {
            System.out.println("Invalid media. "+
                    audioType + " format not supported");
        }
    }

}
