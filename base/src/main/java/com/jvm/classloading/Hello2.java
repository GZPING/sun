package com.jvm.classloading;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : GD
 * @date :2020/3/11 : 22:18
 */
public class Hello2 {

    private static byte[] buffer = new byte[8];

    private static String str = "a";

    private static List<String> list = new ArrayList<>();

    static{
        buffer[0] = (byte)1;
        str = "Hello2";
        list.add("element");
        System.out.println(buffer[0]);
        System.out.println(str);
        System.out.println(list.get(0));
        System.out.println("hello world to GD 22222");
    }
}
