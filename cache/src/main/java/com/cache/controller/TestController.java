package com.cache.controller;

/**
 * Created by GD on 2018/9/9.
 * Blog: https://blog.csdn.net/SaketGD
 * GitHub: https://github.com/GZPING
 */

import com.cache.service.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @Description
 * @Author GD
 * @Date 2018/9/9 0:00
 * @Since 1.0V
 */
@RestController
public class TestController {

    @Autowired
    private Person person;

    @RequestMapping("/hello")
    public String hello(){
        String hello = person.sayHi();
        return hello;
    }
}
