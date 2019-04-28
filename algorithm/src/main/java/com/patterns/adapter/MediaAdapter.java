package com.patterns.adapter;

/**
 * Created by GD on 2018/5/9.
 * Blog: https://blog.csdn.net/SaketGD
 * GitHub: https://github.com/GZPING
 */

/**
 *
 * @Description TODO
 * @Author GD
 * @Date 2018/5/9 19:55
 * @Since 1.0V
 */

public class MediaAdapter implements MediaPlayer {

    private AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String type) {
        if(type.equals("mp4")){
            advancedMediaPlayer = new Mp4Player();
        }else if (type.equals("vcr")){
            advancedMediaPlayer = new VcrPlayer();
        }else{
            advancedMediaPlayer = null;
        }

    }

    public void play(String type, String fileName) {
        if(type.equalsIgnoreCase("vcr")){
            advancedMediaPlayer.playVcr(fileName);
        }else if(type.equalsIgnoreCase("mp4")){
            advancedMediaPlayer.playMp4(fileName);
        }
    }
}
