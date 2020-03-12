package com.jvm.classloading;

/**
 * @author : GD
 * @date :2020/3/12 : 22:36
 */
public class LoadHello2Class {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        BrokerDelegateClassLoader brokerDelegateClassLoader = new BrokerDelegateClassLoader();
        Class<?> clazz = brokerDelegateClassLoader.loadClass("com.jvm.classloading.Hello2");
        System.out.println(brokerDelegateClassLoader.getParent());
        clazz.newInstance();
    }
}
