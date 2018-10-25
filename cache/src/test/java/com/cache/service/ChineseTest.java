package com.cache.service;

import com.cache.CacheApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.concurrent.CountDownLatch;


@RunWith(SpringRunner.class)
@SpringBootTest(classes= CacheApplication.class)
public class ChineseTest {

    @Autowired
    private Person person;

    private static final int COUNT = 10;
    private static CountDownLatch lock = new CountDownLatch(COUNT);

    @Test
    public void sayHi() throws Exception {
    }

    @Test
    public void getTotalMoney() throws Exception {
        for (int i = 0; i < COUNT; i++) {
            System.out.println("还存在--------------------" + lock.getCount());
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        lock.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    BigDecimal totalMoney = person.getTotalMoney(10);
                    System.out.println("总金额为--------------------" + totalMoney);
                }
            }).start();
            lock.countDown();
            Thread.sleep(100);
        }
    }

    @Test
    public void productOrder() throws Exception {
        for (int i = 0; i < 100000; i++) {
            person.productOrder();
        }

    }
    @Test
    public void getOrder() throws Exception {
        BigDecimal totalMoney = person.getTotalMoney(10);
        System.out.println("总金额为--------------------" + totalMoney);
    }

}
