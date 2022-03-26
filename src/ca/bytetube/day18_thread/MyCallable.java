package ca.bytetube.day18_thread;

import java.util.concurrent.Callable;

public class MyCallable implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("I need a dolphin:call");
        Thread.sleep(2000);
        System.out.println("dolphin is coming: " + Thread.currentThread().getName());
        System.out.println("Saved my life and dolphin went back to the pool");
        return null;
    }
}
