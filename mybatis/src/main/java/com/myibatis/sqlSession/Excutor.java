package com.myibatis.sqlSession;
/**
 * Created by GD on 2018/10/23.
 * Blog: https://blog.csdn.net/SaketGD
 * GitHub: https://github.com/GZPING
 */

/**
 *
 * @Description
 * @Author GD
 * @Date 2018/10/23 22:30
 * @Since 1.0V
 */
public interface Excutor {
    <T> T query(String statement,Object parameter);
}
