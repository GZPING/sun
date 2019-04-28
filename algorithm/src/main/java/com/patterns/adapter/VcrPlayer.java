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
 * @Date 2018/5/9 19:53
 * @Since 1.0V
 */

public class VcrPlayer implements AdvancedMediaPlayer {
    public void playVcr(String fileName) {
        System.out.println("VCR playing , file is " + fileName);
    }

    public void playMp4(String fileName) {

    }
}
