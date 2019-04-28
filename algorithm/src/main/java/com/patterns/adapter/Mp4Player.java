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
 * @Date 2018/5/9 19:51
 * @Since 1.0V
 */

public class Mp4Player implements AdvancedMediaPlayer {

    public void playVcr(String fileName) {
        // do nothing
    }

    public void playMp4(String fileName) {
        System.out.println("MP4 playing , file is " + fileName);
    }
}
