package com.mybatis;

import com.mybatis.mapper.OrderMapper;
import com.mybatis.model.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class MybatisApplicationTests {

	//@Test
	public void contextLoads() throws IOException{
	}

	public static void main(String[] args) throws IOException{
		String resource = "mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
			List<Order> orders = orderMapper.getAllOrder(0,1);
			for (Order order : orders){
				System.out.println(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	}
}
