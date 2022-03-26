package ca.bytetube.day19_mutiThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ticket implements Runnable {
    int ticket = 100;

    //获取锁
    Lock ck = new ReentrantLock();


    @Override
    public void run() {
      while (true){
          if (ticket <= 0) break;
          //同步代码块
//          synchronized(this){
//              if (ticket > 0){
//                  try {
//                      Thread.sleep(20);
//                  } catch (InterruptedException e) {
//                      e.printStackTrace();
//                  }
//                  System.out.println(Thread.currentThread().getName()+ " is selling ticket: "+ ticket--);
//              }
//          }


//          sellTicket();

          ck.lock();//表示从第30行开始，代码加锁
          if (ticket > 0){
                  try {
                      Thread.sleep(20);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  System.out.println(Thread.currentThread().getName()+ " is selling ticket: "+ ticket--);
              }
          ck.unlock();//代码解锁
      }
    }


    //同步方法, 内置锁对象 this
//    public synchronized void sellTicket(){
//        if (ticket > 0){
//            try {
//                Thread.sleep(20);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName()+ " is selling ticket: "+ ticket--);
//        }
//    }
}
