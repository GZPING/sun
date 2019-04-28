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
 * @Date 2018/5/9 19:59
 * @Since 1.0V
 */

public class AudioPlayer implements MediaPlayer {

    MediaPlayer mediaAdapter;

    public void play(String type, String fileName) {
        if(type.equals("mp3")){
            System.out.println("mp3 playing file is " + fileName);
        }else if(type.equals("vcr") || type.equals("mp4")){
            mediaAdapter = new MediaAdapter(type);
            mediaAdapter.play(type,fileName);
        }
    }
}
