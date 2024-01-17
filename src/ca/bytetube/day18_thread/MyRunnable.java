package ca.bytetube.day18_thread;

/**
 * Runnable 是 thread 具体实现的任务 ---> 线程任务
 *
 * 优点：
 * 实现Runnable接口，将线程任务单独分离出来，封装成对象
 * Runnable接口将线程对象和线程任务进行解耦
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " is executing " + i);
        }
    }

}
