package com.mybatis.mapper;

import com.mybatis.model.Order;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface OrderMapper {

    List<Order> getAllOrder(@Param("page") Integer page ,@Param("size") Integer size);

     @Delete({
        "delete from orders",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into orders (id, user, ",
        "money)",
        "values (#{id,jdbcType=INTEGER}, #{user,jdbcType=INTEGER}, ",
        "#{money,jdbcType=DECIMAL})"
    })
    int insert(Order record);

    @Select({
        "select",
        "id, user, money",
        "from orders",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user", property="user", jdbcType=JdbcType.INTEGER),
        @Result(column="money", property="money", jdbcType=JdbcType.DECIMAL)
    })
    Order selectByPrimaryKey(Integer id);


    @Update({
        "update orders",
        "set user = #{user,jdbcType=INTEGER},",
          "money = #{money,jdbcType=DECIMAL}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Order record);

    @Select({
            "select",
            "sum(money)",
            "from orders",
            "where user = #{userId,jdbcType=INTEGER}"
    })
    BigDecimal selectTotalMoneyByUserId(@Param("userId") Integer userId);


    Order selectOrderById(Integer s);
}