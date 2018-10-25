package com.mybatis.service;
/**
 * Created by GD on 2018/9/17.
 * Blog: https://blog.csdn.net/SaketGD
 * GitHub: https://github.com/GZPING
 */

import java.math.BigDecimal;

/**
 *
 * @Description
 * @Author GD
 * @Date 2018/9/17 23:03
 * @Since 1.0V
 */
public interface Person {

    String sayHi();

    BigDecimal getTotalMoney(int usreId);

    int productOrder();
}
