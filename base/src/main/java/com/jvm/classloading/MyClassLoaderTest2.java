package com.jvm.classloading;

import java.lang.reflect.Method;

/**
 * 将父类设置为null，则可以直接通过自己的类加载
 * @author : GD
 * @date :2020/3/11 : 22:20
 */
public class MyClassLoaderTest2 {

    public static void main(String[] args) throws Exception{
        // MyClassLoader myClassLoader = new MyClassLoader("D:\\class",null);
        ClassLoader classLoader = MyClassLoaderTest2.class.getClassLoader().getParent();
        MyClassLoader myClassLoader = new MyClassLoader("D:\\class",classLoader);
        Class<?> clazz = myClassLoader.loadClass("com.jvm.classloading.Hello");
        System.out.println(clazz.getClassLoader());
        Object hello = clazz.newInstance();
        System.out.println(hello);
        Method helloMethod = clazz.getMethod("welcome");
        System.out.println("result welcome : " + helloMethod.invoke(hello));
    }
}
