package com.lambda;

import org.junit.Test;

import java.util.function.*;

/**
 * @Description
 * @Author GD
 * @Date 2020/3/7 21:13
 */
public class Lambda {


    /**
     *
     * Function 传入一个值，返回一个处理后的值  Function<Integer, Integer> name = e -> e * 2
     * Supplier
     * Predicate
     * Consumer
     * UnaryOperator
     * BinaryOperator
     *
     * Consumer	Consumer< T >	接收T对象，不返回值
     * Predicate	Predicate< T >	接收T对象并返回boolean
     *
     * Function	Function< T, R >	接收T对象，返回R对象
     * 传入一个值，返回一个处理后的值  Function<Integer, Integer> name = e -> e * 2
     *
     * Supplier	Supplier< T >	提供T对象（例如工厂），不接收值
     * UnaryOperator	UnaryOperator	接收T对象，返回T对象
     * BinaryOperator	BinaryOperator	接收两个T对象，返回T对象
     *
     */


    @Test
    public void function(){
        Function<Integer, Integer> name = e -> e * 2;
        Function<Integer, Integer> square = e -> e * e;
        int value = name.andThen(square).apply(3);
        System.out.println("andThen value=" + value);
        int value2 = name.compose(square).apply(3);
        System.out.println("compose value2=" + value2);
        //返回一个执行了apply()方法之后只会返回输入参数的函数对象
        Object identity = Function.identity().apply("huohuo");
        System.out.println(identity);
    }

    /**
     * 接收T对象并返回boolean
     */
    @Test
    public void predicate(){
        Predicate<Integer> predicate = e -> e.equals(1);
        System.out.println(predicate.test(1));
        System.out.println(predicate.test(2));
    }

    /**
     * 接收T对象没有返回
     */
    @Test
    public void consumer(){
        Consumer consumer = e -> System.out.println(e);
        consumer.accept(1);
        consumer.accept("agc");
    }


    /**
     * 无传参，返回一个值
     */
    @Test
    public void supplier(){
        Supplier consumer = () -> 100;
        System.out.println(consumer.get());
    }

    /**
     * 传递两个值，返回一个值
     */
    @Test
    public void binaryOperator(){
        BinaryOperator<Integer> binaryOperator = (a,b)->a+b;
        System.out.println(binaryOperator.apply(1,2));
    }

    /**
     * 传递两个值，返回一个值,返回类型与传递类型一致
     */
    @Test
    public void unaryOperator(){
        UnaryOperator<Integer> unaryOperator = (b)->b+100;
        System.out.println(unaryOperator.apply(1));
    }

}
