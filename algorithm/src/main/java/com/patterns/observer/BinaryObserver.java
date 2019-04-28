package com.patterns.observer;

/**
 * Created by GD on 2018/5/9.
 * Blog: https://blog.csdn.net/SaketGD
 * GitHub: https://github.com/GZPING
 */

import javax.xml.ws.soap.MTOM;

/**
 *
 * @Description
 * @Author GD
 * @Date 2018/5/9 21:05
 * @Since 1.0V
 */

public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    public void update(Integer data) {
        System.out.println("Binary :" + Integer.toBinaryString(data));
    }
    public static void main(String[] args) {


    }
}
