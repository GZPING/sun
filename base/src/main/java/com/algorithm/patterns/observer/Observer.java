package com.algorithm.patterns.observer;
/**
 * Created by GD on 2018/5/9.
 * Blog: https://blog.csdn.net/SaketGD
 * GitHub: https://github.com/GZPING
 */

/**
 *
 * @Description TODO
 * @Author GD
 * @Date 2018/5/9 21:02
 * @Since 1.0V
 */
public abstract class Observer {

    protected Subject subject;

    public abstract void update(Integer data);
}
