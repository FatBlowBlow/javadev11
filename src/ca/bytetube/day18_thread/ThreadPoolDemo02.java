package ca.bytetube.day18_thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolDemo02 {
    public static void main(String[] args) throws Exception {
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        MyCallable2 c = new MyCallable2(100, 200);
        MyCallable2 c2 = new MyCallable2(10, 20);

        Future<Integer> res = threadPool.submit(c);
        Integer sum = res.get();
        System.out.println("sum=" + sum);

        res = threadPool.submit(c2);
        sum = res.get();
        System.out.println("sum=" + sum);
        threadPool.shutdown();


    }
}
