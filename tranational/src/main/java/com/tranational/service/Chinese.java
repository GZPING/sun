package com.tranational.service;

/**
 * Created by GD on 2018/9/17.
 * Blog: https://blog.csdn.net/SaketGD
 * GitHub: https://github.com/GZPING
 */

import org.springframework.stereotype.Service;

/**
 *
 * @Description
 * @Author GD
 * @Date 2018/9/17 23:04
 * @Since 1.0V
 */
@Service
public class Chinese implements Person {
    @Override
    public String sayHi() {
        return " 你好，我是中国人";
    }
}
