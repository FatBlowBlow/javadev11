package ca.bytetube.day18_thread;

/**
 * extends Thread类
 * 线程对象和线程任务耦合在一起
 * 一旦创建Thread类的子类对象，既是线程对象，又有线程任务
 */
public class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " is executing " + i);
        }
    }


}
