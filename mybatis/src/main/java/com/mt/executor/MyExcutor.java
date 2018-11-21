package com.mt.executor;

/**
 * Created by GD on 2018/10/23.
 * Blog: https://blog.csdn.net/SaketGD
 * GitHub: https://github.com/GZPING
 */

import com.mt.session.Configuration;
import com.mybatis.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Description
 * @Author GD
 * @Date 2018/10/23 22:32
 * @Since 1.0V
 */

public class MyExcutor implements Excutor {
    private Configuration xmlConfiguration = new Configuration();

    @Override
    public <T> T query(String sql, Object parameter) {
        Connection connection = getConnection();
        ResultSet set = null;
        PreparedStatement pre = null;
        try {
            pre = connection.prepareStatement(sql);
            //设置参数
            pre.setInt(1, (Integer) parameter);
            set = pre.executeQuery();
            Order order = new Order();
            //遍历结果集
            while (set.next()) {
                order.setId(set.getInt(1));
                order.setMoney(set.getBigDecimal(2));
                order.setUser(set.getInt(3));
            }
            return (T) order;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (set != null) {
                    set.close();
                }
                if (pre != null) {
                    pre.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    private Connection getConnection() {
        try {
            Connection connection = xmlConfiguration.build("simplemt.xml");
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
