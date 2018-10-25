package com.cache.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.cache.model.Order;

public class OrderSqlProvider {

    public String insertSelective(Order record) {
        BEGIN();
        INSERT_INTO("orders");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUser() != null) {
            VALUES("user", "#{user,jdbcType=INTEGER}");
        }
        
        if (record.getMoney() != null) {
            VALUES("money", "#{money,jdbcType=DECIMAL}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Order record) {
        BEGIN();
        UPDATE("orders");
        
        if (record.getUser() != null) {
            SET("user = #{user,jdbcType=INTEGER}");
        }
        
        if (record.getMoney() != null) {
            SET("money = #{money,jdbcType=DECIMAL}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}