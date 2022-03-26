package ca.bytetube.day18_thread;



public class Test {
    public static void main(String[] args) {

        /**
         * 创建线程方式1: 继承Thread类
         * 调用start()后JVM才会开启新的内存空间，开启线程并让线程执行，JVM会内部直接调用该线程的run()
         * 直接调用run(),没有意义,没有开启新线程，只是对象调用方法
         */
//        MyThread myThread1 = new MyThread("fang1");
//        myThread1.start();
//        MyThread myThread2 = new MyThread("fang2");
//        myThread2.run();

//        Thread thread = new Thread("shuo");
//        thread.start();//通过源码可以发现，run() 什么也没有,是个空方法,什么也没有执行
//
//        System.out.println("code is here");


        /**
         * 创建线程方式2: 实现MyRunnable接口
         */
//        MyRunnable task = new MyRunnable();
//        Thread t1 = new Thread(task);
//        Thread t2 = new Thread(task);
//        t1.start();
//        t2.start();

        /**
         * 线程的匿名内部类, 使用场景：只使用一次
         * MyThread类可以删掉
         */
//        Thread myThread1 = new Thread("fang"){
//            @Override
//            public void run() {
//                for (int i = 0; i < 10; i++) {
//                    System.out.println(Thread.currentThread().getName() + " is executing " + i);
//                }
//            }
//        };
//        myThread1.start();
//
//        new Thread("shuo"){
//            @Override
//            public void run() {
//                for (int i = 0; i < 10; i++) {
//                    System.out.println(Thread.currentThread().getName() + " is executing " + i);
//                }
//            }
//        }.start();

        /**
         * 接口可以实现匿名内部类
         * MyRunnable类可以删掉
         */
        Runnable task = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " is executing " + i);
                }
            }
        };
        Thread t1 = new Thread(task,"huan");
        Thread t2 = new Thread(task,"jun");
        t1.start();
        t2.start();



    }
}
