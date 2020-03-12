package com.jvm.classloading;

import java.lang.reflect.Method;

/**
 *
 * @author : GD
 * @date :2020/3/11 : 22:20
 */
public class BrokerDelegateClassLoaderTest {

    public static void main(String[] args) throws Exception{
        BrokerDelegateClassLoader myClassLoader = new BrokerDelegateClassLoader();
        Class<?> clazz = myClassLoader.loadClass("com.jvm.classloading.Hello");
        System.out.println(clazz.getClassLoader());
        Object hello = clazz.newInstance();
        System.out.println(hello);
        Method helloMethod = clazz.getMethod("welcome");
        System.out.println("result welcome : " + helloMethod.invoke(hello));
    }
}
