package ca.bytetube.day18_thread;

import java.util.concurrent.Callable;

public class MyCallable2 implements Callable<Integer> {

    int x = 3;
    int y = 5;

    public MyCallable2() {}

    public MyCallable2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Integer call() throws Exception {
        return x+y;
    }
}
