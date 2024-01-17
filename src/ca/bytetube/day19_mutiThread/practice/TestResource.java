package ca.bytetube.day19_mutiThread.practice;

public class TestResource {
    public static void main(String[] args) {
        //资源
        Resource resource = new Resource();
        //任务类
        Input inputTask = new Input(resource);
        Output outputTask = new Output(resource);
        //线程类
        Thread t1 = new Thread(inputTask, "t1");
        Thread t2 = new Thread(outputTask, "t2");

        t1.start();
        t2.start();
    }

}
