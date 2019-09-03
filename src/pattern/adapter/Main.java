package pattern.adapter;

/**
 * @Descript: 适配器模式
 * @Author: zhouwei
 * @Date: 19-6-17 下午5:25
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {
        MediaPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");

    }

}
