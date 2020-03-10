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
    /**
     *  定义singleton 在x , y 之前，那么将先执行构造函数，x,y 都会先变成1 ;
     *  此时在进行x,y 初始化，x=0,因y 没有设置初始值，则不会进行初始化
     *  所以 x=0,y=1
     */
    private static Singleton singleton = new Singleton();

    private static int x = 0;
    private static int y ;

    /**
     *  若改行放在x,y定义之后，x,y将先初始化，再执行x++,y++;
     *  此时x=1,y=1
     */
    // private static Singleton singleton = new Singleton();
    private Singleton() {
        x++;
        y++;
    }

    public static Singleton getSingleton(){
        return singleton;
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.getSingleton();
        System.out.println(singleton);
        System.out.println(singleton.x);
        System.out.println(singleton.y);
    }
}
