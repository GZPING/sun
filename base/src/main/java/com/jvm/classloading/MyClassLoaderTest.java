package com.jvm.classloading;

import java.lang.reflect.Method;

/**
 * 操作：
 *  在d:盘中对应位置添加Hello.class 文件
 *
 * 结果：
 * MyClassLoader{classDir=D:\class}
 * hello world to GD
 * com.jvm.classloading.Hello@48eff760
 * result welcome : hello world!
 *
 *操作：
 * 如果com.jvm.classloading 对于输出路径存在hello.class 文件
 * 结果：
 * jdk.internal.loader.ClassLoaders$AppClassLoader@1f89ab83
 * hello world to GD
 * com.jvm.classloading.Hello@13c78c0b
 * result welcome : hello world!
 *
 * 双亲委派机制，即父类能够找到的，将不会给之类去执行
 *
 * 具体可参考：java.lang.ClassLoader#loadClass(java.lang.String, boolean)
 *
 * @author : GD
 * @date :2020/3/11 : 22:20
 */
public class MyClassLoaderTest {

    public static void main(String[] args) throws Exception{
        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> clazz = myClassLoader.loadClass("com.jvm.classloading.Hello");
        System.out.println(clazz.getClassLoader());
        Object hello = clazz.newInstance();
        System.out.println(hello);
        Method helloMethod = clazz.getMethod("welcome");
        System.out.println("result welcome : " + helloMethod.invoke(hello));
    }
}
