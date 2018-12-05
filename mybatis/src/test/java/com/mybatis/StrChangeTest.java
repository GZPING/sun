package com.mybatis;

/**
 * Created by GD on 2018/12/4.
 * Blog: https://blog.csdn.net/SaketGD
 * GitHub: https://github.com/GZPING
 */

/**
 * @Description
 * @Author GD
 * @Date 2018/12/4 23:05
 * @Since 1.0V
 */

public class StrChangeTest {

    public static void main(String[] args) {
        String input = "HuangJinJie";
        String output = changeStr(input);
        System.out.println(input);
        System.out.println(output);

    }

    private static String changeStr(String input) {
        char[] chs = input.toCharArray();
        for (int i = 1; i < chs.length; i = i+2) {
            char temp = chs[i-1];
            chs[i-1]=chs[i];
            chs[i]=temp;
        }

        return new String(chs);
    }
}
