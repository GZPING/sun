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

public class DBBaseTest {

    public static void main(String[] args) throws Exception {
        //加载驱动
        // DriverManager.registerDriver(new Driver());//第一种方式
        Class.forName("com.mysql.jdbc.Driver");//第二种方式
        //创建连接
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, user, password);
        //获取连接
        Statement statement = connection.createStatement();
        String insertSql = "insert into orders values (null,100,30.20)";
        int num = statement.executeUpdate(insertSql);
        System.out.println(num);
        //一次会话
        String sql = "select * from orders limit 0 ,10";
        ResultSet set = statement.executeQuery(sql);
        //执行SQL语句
        while (set.next()) {
            String id = set.getString(1);
            String name = set.getString(2);
            String money = set.getString(3);
            //接着一个一个的区便利
            System.out.println(id + "<===========>" + name + "<===========>" + money);
        }
        //返回结果集
        set.close();
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
        //关闭资源

    }
}
