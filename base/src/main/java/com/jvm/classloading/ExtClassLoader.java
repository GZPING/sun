package com.jvm.classloading;

/**
 * @author : GD
 * @date :2020/3/11 : 21:54
 */
public class ExtClassLoader {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> helloClass = Class.forName("com.jvm.Singleton");
        System.out.println(helloClass.getClassLoader());
    }
}
