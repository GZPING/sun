package com.future;

import java.util.concurrent.CompletableFuture;

/**
 *
 * 说明：Async结尾的方法都是可以异步执行的，如果指定了线程池，会在指定的线程池中执行，如果没有指定，默认会在ForkJoinPool.commonPool()中执行。
 * 下面很多方法都是类似的，不再做特别说明。
 *
 * 四个静态方法用来为一段异步执行的代码创建CompletableFuture对象，方法的参数类型都是函数式接口，所以可以使用lambda表达式实现异步任务
 *
 * runAsync方法：它以Runnabel函数式接口类型为参数，所以CompletableFuture的计算结果为空。
 *
 * supplyAsync方法以Supplier<U>函数式接口类型为参数，CompletableFuture的计算结果类型为U。
 * @author : GD
 * @date :2020/3/15 : 22:11
 */
public class CompletableFutureTest {

    public static void main(String[] args) {
        String localhost = CompletableFuture.supplyAsync(() -> {
            System.out.println("localhost ");
            return 10;
        }).thenApply(t -> t + "8080").join();
        System.out.println(localhost);
    }
}
