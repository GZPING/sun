package com.thread.syccodeblock;

/**
 * Created by GD on 2018/9/1.
 * Blog: https://blog.csdn.net/SaketGD
 * GitHub: https://github.com/GZPING
 */

/**
 *
 * @Description
 * @Author GD
 * @Date 2018/9/1 22:59
 * @Since 1.0V
 */

public class MyThread extends Thread{

    private MyObject myObject;

    public MyThread(MyObject myObject) {
        super();
        this.myObject = myObject;
    }
    public MyThread(MyObject myObject, String name) {
        super(name);
        this.myObject = myObject;
    }

    @Override
    public void run() {
        super.run();
       // myObject.Method1();
      //  myObject.methodA(this.getName());
      //  myObject.methodB();
        myObject.methodD(this.getName());
       // System.out.println(myObject.getI());

    }
}
