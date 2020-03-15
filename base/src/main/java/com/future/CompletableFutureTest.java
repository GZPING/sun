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
        // thenApply 将返回的数据继续执行
        String localhost = CompletableFuture.supplyAsync(() -> {
            System.out.println("localhost ");
            return 10;
        }).thenApply(t -> t + "8080").join();
        System.out.println(localhost);
        // thenCombine 结合两个CompletableFuture 进行操作
        String join = CompletableFuture.supplyAsync(() -> {
            return "hello ";
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            return "world";
        }), (s1, s2) -> s1 + " " + s2).join();
        System.out.println(join);
        //applyToEither 两个CompletionStage，谁计算的快，就用那个CompletionStage的结果进行下一步的处理
        String result = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hi Boy";
        }).applyToEither(CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hi Girl";
        }),(s)->{return s;}).join();
        System.out.println(result);
        // 5、运行时出现了异常，可以通过exceptionally进行补偿
        // public CompletionStage<T> exceptionally(Function<Throwable, ? extends T> fn);
        String result2 = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(true) {
                throw new RuntimeException("exception test!");
            }
            return "Hi Boy";
        }).exceptionally(e->{
            System.out.println(e.getMessage());
            return "Hello world!";
        }).join();
        System.out.println(result2);
    }
}
