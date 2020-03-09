package com.proxy;

import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

/**
 * @Author : GD
 * @Create :2019/9/25 : 9:59
 */
public class CGlibProxy implements InvocationHandler {

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("i am cglibProxy");
        return null;
    }
}
