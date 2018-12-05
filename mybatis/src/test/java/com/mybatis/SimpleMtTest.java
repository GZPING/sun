package com.mybatis;

/**
 * Created by GD on 2018/11/20.
 * Blog: https://blog.csdn.net/SaketGD
 * GitHub: https://github.com/GZPING
 */

import com.mt.session.MySqlSession;
import com.mybatis.mapper.OrderMapper;
import com.mybatis.model.Order;

/**
 *
 * @Description
 * @Author GD
 * @Date 2018/11/20 23:31
 * @Since 1.0V
 */

public class SimpleMtTest {
    public static void main(String[] args) {
        MySqlSession sqlsession=new MySqlSession();
        OrderMapper mapper = sqlsession.getMapper(OrderMapper.class);
        Order order = mapper.selectOrderById(130002);
        System.out.println(order);
    }
}
