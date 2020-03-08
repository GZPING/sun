package com.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream 练习
 *
 * @author : GD
 * @date :2020/3/8 : 15:35
 */
public class StreamTest {


    /**
     * get dictionary list info
     * @return
     */
    private List<Dict> getList() {
        List<Dict> list = new ArrayList<>();
        list.add(new Dict("heeel", "f", 10));
        list.add(new Dict("gsa", "m", 20));
        list.add(new Dict("test", "m", 50));
        list.add(new Dict("user", "f", 60));
        list.add(new Dict("suma", "f", 30));
        list.add(new Dict("sumb", "m", 40));

        return list;
    }

    /**
     * get stream info test
     */
    @Test
    public void stream(){
        Stream stream = getList().stream();
        stream.forEach((e)-> System.out.println(e));
    }


    /**
     * test map
     */
    @Test
    public void filter(){
        Stream<Dict> stream = getList().stream().filter(e -> e.getSex().equals("f"));
        stream.forEach((e)-> System.out.println(e));
    }

    /**
     * test map , map(Function) ,处理数据转换成其他类型list
     */
    @Test
    public void map(){
        Stream stream = getList().stream().map(e -> e.getName());
        stream.forEach((e)-> System.out.println(e));
    }
    /**
     * distinct a list
     */
    @Test
    public void distinct(){
        Stream stream = getList().stream().map(e -> e.getSex()).distinct();
        stream.forEach((e)-> System.out.println(e));
    }

    /**
     * sort a list
     */
    @Test
    public void sort(){
        Stream stream = getList().stream().map(e -> e.getAge()).sorted();
        stream.forEach((e)-> System.out.println(e));
    }
    /**
     * sort a list
     */
    @Test
    public void peek(){
        Stream stream = getList().stream().map(e -> e.getAge()).sorted();
        stream.forEach((e)-> System.out.println(e));
    }

    /**
     * reduce a list
     * 所有的list 数据进行聚合处理
     */
    @Test
    public void reduce(){
        // 列表元素累加
        System.out.println(getList().stream().map(e -> e.getAge()).reduce(1,(i,j) -> i + j));
        // 列表元素累积
        System.out.println(getList().stream().map(e -> e.getAge()).reduce(0,(i,j) -> i * j));
    }

    /**
     * sort a list
     * java.lang.IllegalStateException: stream has already been operated upon or closed
     * 流一旦使用后，就无法再次使用
     */
    @Test
    public void match(){
        //Stream<Integer> stream = getList().stream().map(e -> e.getAge());
        // 所有的信息都满足条件
        System.out.println(getList().stream().map(e -> e.getAge()).allMatch(i-> i < 40));
        // 部分信息满足条件，
        System.out.println(getList().stream().map(e -> e.getAge()).anyMatch(i-> i < 40));
        // 全部不满足条件
        System.out.println(getList().stream().map(e -> e.getAge()).noneMatch(i-> i < 40));
        getList().stream().map(e -> e.getAge()).forEach((e)-> System.out.println(e));
    }

    class Dict {
        public Dict() {
        }

        public Dict(String name, String sex, Integer age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        private String name;
        private String sex;
        private Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Dict{" +
                    "name='" + name + '\'' +
                    ", sex='" + sex + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}
