package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author : GD
 * @Create :2019/9/25 : 9:59
 */
public class JDKProxy implements InvocationHandler {


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("i am JDKProxy");
        return null;
    }
}
