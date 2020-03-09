package com.jvm;

/**
 * Created by GD on 2019/8/7.
 */

/**
 *
 * @Description
 * 1. 对象可以自我拯救
 * 2. 通过finalize 方法拯救，但是finalize方法只会被系统调用一次
 * @Author GD
 * @Date 2019/8/7 21:47
 * @Version 1.0V
 */

public class FinalizeEscapeGC {

    private static FinalizeEscapeGC FEGC = null;

    private void isAlice(){
        System.out.println("isAlice");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("do finalize function !");
        FinalizeEscapeGC.FEGC = this;
    }

    public static void main(String[] args) throws InterruptedException {
        // 第一次执行，自我拯救
        FEGC = new FinalizeEscapeGC();
        FEGC.isAlice();
        FEGC = null;
        System.gc();
        Thread.sleep(5000);
        if(FEGC != null){
            FEGC.isAlice();
        }else {
            System.out.println("dead 1 !");
        }
        FEGC = null;
        System.gc();
        Thread.sleep(5000);
        if(FEGC != null){
            FEGC.isAlice();
        }else {
            System.out.println("dead 2 !");
        }
    }
}
