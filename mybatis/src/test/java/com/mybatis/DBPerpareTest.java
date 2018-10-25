package com.mybatis;

/**
 * Created by GD on 2018/10/25.
 * Blog: https://blog.csdn.net/SaketGD
 * GitHub: https://github.com/GZPING
 */

import java.sql.*;

/**
 * @Description
 * @Author GD
 * @Date 2018/10/25 23:12
 * @Since 1.0V
 */

public class DBPerpareTest {

    public static void main(String[] args) throws Exception {
        //加载驱动
        // DriverManager.registerDriver(new Driver());//第一种方式
        Class.forName("com.mysql.jdbc.Driver");//第二种方式
        //创建连接
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "123456";
        //获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        //一次会话

        String sql = "insert into orders values (null,?,?)";
        PreparedStatement pst = connection.prepareStatement(sql);
        //返回结果集
        pst.setInt(1,20);
        pst.setDouble(2,50.23);
        int ret = pst.executeUpdate();
        System.out.println(ret);
        if (pst != null){
            pst.close();
        }
        if (connection != null) {
            connection.close();
        }
        //关闭资源

    }
}
