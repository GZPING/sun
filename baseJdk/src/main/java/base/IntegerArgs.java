package base;

import java.lang.reflect.Field;

/**
 * @Author : GD
 * @Create :2019/8/14 : 11:12
 */
public class IntegerArgs {

    public static void main(String[] args) throws Exception{
        Integer a = 3;
        Integer b = 5;
        System.out.println("before swap: a="+ a + ",b=" + b);
        swap(a,b);
        System.out.println("after swap: a="+ a + ",b=" + b);
        Integer c = 3;
        System.out.println(c);
    }

    public static void swap(Integer a,Integer b) throws Exception {
        Field valueField = Integer.class.getDeclaredField("value");
        valueField.setAccessible(true);
        int tmpA = a.intValue();//3
        int tmpB = b.intValue();//5
        valueField.set(a,tmpB);

        //Integer.IntegerCache.cache 中的数组的值已经被改变
        valueField.set(b,tmpA);
    }

}
