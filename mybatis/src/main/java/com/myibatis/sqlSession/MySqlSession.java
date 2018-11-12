package com.myibatis.sqlSession;

/**
 * Created by GD on 2018/10/23.
 * Blog: https://blog.csdn.net/SaketGD
 * GitHub: https://github.com/GZPING
 */

import java.lang.reflect.Proxy;

/**
 *
 * @Description
 * @Author GD
 * @Date 2018/10/23 22:34
 * @Since 1.0V
 */

public class MySqlSession {

    private Excutor excutor= new MyExcutor();

    private Configuration configuration = new Configuration();

    public <T> T selectOne(String statement,Object parameter){
        return excutor.query(statement, parameter);
    }

    @SuppressWarnings("unchecked")
    public <T> T getMapper(Class<T> clas){
        //动态代理调用
        return (T) Proxy.newProxyInstance(clas.getClassLoader(),new Class[]{clas},
                new MyMapperProxy(configuration,this));
    }
}
