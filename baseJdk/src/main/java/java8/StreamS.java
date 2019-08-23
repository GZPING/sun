package java8;

/**
 * Created by GD on 2019/8/22.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
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
        List<Integer> ints2 = ints.stream().filter(s -> s > 10 ).collect(Collectors.toList());
        System.out.println();
        ints2.forEach(s -> System.out.print(s + ","));
        //ints;
    }
}
