package com.cache.aop;

/**
 * Created by GD on 2018/9/8.
 * Blog: https://blog.csdn.net/SaketGD
 * GitHub: https://github.com/GZPING
 */

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 *
 * @Description
 * @Author GD
 * @Date 2018/9/8 23:24
 * @Since 1.0V
 */

//@Aspect
//@Component
public class AspectAdvice {

    @Pointcut("execution(* com.tranational.*.*(..)) && @annotation(com.tranational.aop.AopTest)")
    private void pointcut(){}

    @Before("pointcut()")
    public void before(){
        System.out.println("-----------before-----------");
    }
    @After("pointcut()")
    public void after(){
        System.out.println("-----------after-----------");
    }

}
