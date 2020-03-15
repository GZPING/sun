package com.future;

import java.util.concurrent.*;

/**
 * @author : GD
 * @date :2020/3/15 : 21:45
 */
public class FutureTest1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> future = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("callable ok");
                return 1000;
            }
        });
        executorService.shutdown();
        System.out.println("main thread ");
        Thread.sleep(1000);
        System.out.println(future.get());
    }
}
