package com.jvm;

/**
 *
 * 类加载过程
 * 1. main 方法中调用Singleton 的静态方法，此时Singleton 对象初始化
 * 2. 对象初始化，将初始化变量x,y, y 默认值为0,
 * 3. 调用new Singleton 构造函数，执行x++,y++ 操作，
 * 4. 返回对象实例
 *
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
