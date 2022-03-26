package ca.bytetube.day19_mutiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadDemo {
    public static void main(String[] args) {
        int numOfThread = 2;
        ExecutorService threadPool = Executors.newFixedThreadPool(numOfThread);
        ThreadTask task = new ThreadTask();
        //3. 从线程池中获取线程对象，然后调用run()方法
        for (int i = 0; i < numOfThread; i++) {
            threadPool.submit(task);
        }
        //4.关闭线程池
        threadPool.shutdown();

    }
}
