package com.jvm.classloading;

/**
 *1。 使用同一个类加载器加载同一个class 文件，加载出的Class对象 都是一样的
 * 509886383
 * 509886383
 * true
 * 2. 不同加载器加载出来的的Class 对象不是同一个对象
 *
 * 357863579
 * 1811044090
 * false
 * @author : GD
 * @date :2020/3/12 : 21:42
 */
public class NameSpace {
    public static void main(String[] args) throws ClassNotFoundException {
        /*ClassLoader classLoader = NameSpace.class.getClassLoader();
        Class<?> clazz = classLoader.loadClass("com.jvm.classloading.Hello");
        Class<?> clazz1 = classLoader.loadClass("com.jvm.classloading.Hello");*/
        MyClassLoader myClassLoader = new MyClassLoader();
        BrokerDelegateClassLoader brokerDelegateClassLoader = new BrokerDelegateClassLoader();
        Class<?> clazz = myClassLoader.loadClass("com.jvm.classloading.Hello");
        Class<?> clazz1 = brokerDelegateClassLoader.loadClass("com.jvm.classloading.Hello");
        System.out.println(clazz.hashCode());
        System.out.println(clazz1.hashCode());
        System.out.println(clazz == clazz1);
    }
}
