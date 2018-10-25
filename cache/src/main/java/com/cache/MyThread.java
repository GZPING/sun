package com.cache;

/**
 * Created by GD on 2018/9/27.
 * Blog: https://blog.csdn.net/SaketGD
 * GitHub: https://github.com/GZPING
 */

import com.cache.service.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 *
 * @Description
 * @Author GD
 * @Date 2018/9/27 23:15
 * @Since 1.0V
 */

public class MyThread extends Thread{

    private Person person;


    public MyThread(Person person) {
        this.person = person;
    }

    @Override
    public void run() {
        super.run();
    }
}
