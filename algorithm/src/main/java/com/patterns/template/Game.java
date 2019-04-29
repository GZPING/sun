package com.patterns.template;

/**
 * Created by GD on 2019/4/29.
 */

/**
 *
 * @Description TODO
 * @Author GD
 * @Date 2019/4/29 23:13
 * @Version 1.0V
 */

public abstract class Game {
    
    public void play(){
        init();
        gameing();
        over();
    }

    protected abstract void gameing();

    protected abstract void over();

    protected abstract void init();
}
