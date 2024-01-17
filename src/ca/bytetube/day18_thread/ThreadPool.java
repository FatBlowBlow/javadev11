package ca.bytetube.day18_thread;

import java.util.concurrent.*;

/**
 * Callable: 有返回值，可抛异常
 * Runnable: 没有返回值，不能抛异常
 */
public class ThreadPool {
    public static void main(String[] args) throws Exception {

          //Runnable接口
//        //1.创建线程池对象
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        //2.创建Runnable接口子类对象
//        MyRunnable2 task = new MyRunnable2();
//        //3.提交Runnable接口子类对象
//        for (int i = 0; i < 5; i++) {//假如5个人落水
//            executorService.submit(task);
//        }
//        //4.关闭线程池
//        executorService.shutdown();

        //1.创建线程池对象
        ExecutorService executorService = Executors.newFixedThreadPool(2);//包含2个线程对象
        //创建Callable对象
        MyCallable c = new MyCallable();
        //从线程池中获取线程对象，然后调用MyCallable中的call()
        for (int i = 0; i < 5; i++) {
            Future submit = executorService.submit(c);
            Object o = submit.get();
            System.out.println(o);
        }
        //关闭线程池
        executorService.shutdown();


    }



}
