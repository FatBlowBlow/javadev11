package ca.bytetube.day18_thread;

public class ThreadDemo01 {
    String name;

    public ThreadDemo01(String name) {
        this.name = name;
    }

    public void show(){
        for (int i = 0; i <= 100 ; i++) {
            System.out.println("name=" + name +" ,i=" + i);
        }
    }

    /**
     * main : mainThread 主线程
     */
    public static void main(String[] args) {
        ThreadDemo01 d = new ThreadDemo01("fang");
        ThreadDemo01 d2 = new ThreadDemo01("shuo");
        d.show();
        d2.show();
        System.out.println("Hello world");
    }
}
