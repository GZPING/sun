package com.future;

import java.util.concurrent.*;

/**
 *
 * Future 接口的局限性
 *了解了Future的使用，这里就要谈谈Future的局限性。Future很难直接表述多个Future 结果之间的依赖性，
 * 开发中，我们经常需要达成以下目的：
 *
 * 1. 将两个异步计算合并为一个（这两个异步计算之间相互独立，同时第二个又依赖于第一个的结果）
 * 2. 等待 Future 集合中的所有任务都完成。
 * 3. 仅等待 Future 集合中最快结束的任务完成，并返回它的结果。
 * @author : GD
 * @date :2020/3/15 : 21:45
 */
public class FutureTest1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 第一种方式
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> future = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("callable ok");
                return 1000;
            }
        });
        executorService.shutdown();
        // 第二种方式



        System.out.println("main thread ");
        Thread.sleep(1000);
        System.out.println(future.get());
    }
}
