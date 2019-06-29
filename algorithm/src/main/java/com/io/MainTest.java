package com.io;

/**
 * Created by GD on 2019/5/26.
 */

/**
 *
 * @Description TODO
 * @Author GD
 * @Date 2019/5/26 23:22
 * @Version 1.0V
 */

public class MainTest {

    public static void main(String[] args) {
        (new Thread(new TimeServer(8888))).start();
    }
}
