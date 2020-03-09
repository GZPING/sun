package com.jvm;

/**
 *
 * 类加载过程
 * @author : GD
 * @date :2020/3/9 : 22:26
 */
public class Singleton {

    private static int x = 0;
    private static int y ;

    private static Singleton singleton = new Singleton();

    public Singleton() {
        x++;
        y++;
    }

    public static Singleton getSingleton(){
        return singleton;
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.getSingleton();
        System.out.println(singleton.x);
        System.out.println(singleton.y);
    }
}
