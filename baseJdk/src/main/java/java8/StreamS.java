package java8;

/**
 * Created by GD on 2019/8/22.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

/**
 *
 * @Description 流编程
 * @Author GD
 * @Date 2019/8/22 22:02
 * @Version 1.0V
 */

public class StreamS {

    @Test
    public void test(){
        List<Integer> ints = new ArrayList<>();
        ints.add(10);ints.add(20);ints.add(1);ints.add(12);
        ints.add(13);ints.add(5);ints.add(3);ints.add(2);
        ints.forEach(s -> System.out.print(s + ","));
        Collections.sort(ints,(s1,s2) -> s1.compareTo(s2));
        System.out.println();
        ints.forEach(s -> System.out.print(s + ","));
        // filter 过滤器
        List<Integer> ints2 = ints.stream().filter(s -> s > 10).collect(Collectors.toList());
        System.out.println();
        // 循环遍历
        ints2.forEach(s -> System.out.print(s + ","));
    }

    @Test
    public void test2() {
        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());

        // 这个例子中100即为计算初始值，每次相加计算值都会传递到下一次计算的第一个参数。
        Integer reduce = Stream.of(1, 2, 3, 4).reduce(100, Integer::sum);
        System.out.println(reduce);
    }
}
