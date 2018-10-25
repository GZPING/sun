package com.mybatis;

/**
 * Created by GD on 2018/10/24.
 * Blog: https://blog.csdn.net/SaketGD
 * GitHub: https://github.com/GZPING
 */

import java.util.Set;
import java.util.TreeSet;

/**
 * @Description
 * @Author GD
 * @Date 2018/10/24 23:35
 * @Since 1.0V
 */
// set 对象是比较equal 方法，只要equal 就表明是相等的
public class SetTest {
    public static void main(String[] args) {
        String a = new String("abc");
        String b = new String("abcd");
        Set<String> set = new TreeSet<>();
        set.add(a);
        set.add(b);
        System.out.println(set.size());
        for (int i = 0; i < set.size(); i++) {
            System.out.println(set.iterator());
        }
    }
}
