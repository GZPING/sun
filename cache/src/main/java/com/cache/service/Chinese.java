package com.cache.service;

/**
 * Created by GD on 2018/9/17.
 * Blog: https://blog.csdn.net/SaketGD
 * GitHub: https://github.com/GZPING
 */

import com.cache.mapper.OrderMapper;
import com.cache.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 *
 * @Description
 * @Author GD
 * @Date 2018/9/17 23:04
 * @Since 1.0V
 */
@Service
public class Chinese implements Person {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public String sayHi() {
        return " 你好，我是中国人";
    }

    @Override
    public BigDecimal getTotalMoney(int usreId) {
        return orderMapper.selectTotalMoneyByUserId(usreId);
    }

    @Override
    public int productOrder() {
        Order order = new Order();
        order.setUser(10);
        order.setMoney(BigDecimal.valueOf(Math.random()*100));
        orderMapper.insert(order);
        return 0;
    }


}
