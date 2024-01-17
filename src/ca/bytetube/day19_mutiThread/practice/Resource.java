package ca.bytetube.day19_mutiThread.practice;

public class Resource {

    private String name;
    private String sex;
    private boolean haveResource = false;


    public synchronized void setResource(String name, String sex){
        //1. 有数据
        if (haveResource) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //2. 无数据
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.name = name;
        this.sex = sex;
        //设置完数据，Resource中有值了,改变haveResource状态为true
        haveResource = true;
        //唤醒output线程
        this.notify();
    }


    //output thread
    public synchronized void getResource(){
        //1. 无数据
        if (!haveResource) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //2. 有数据,将resource输出
        System.out.println("name: " + this.name + ", sex: " + this.sex);
        //输出完数据, Resource中无值了, haveResource 为 False
        haveResource = false;
        //唤醒input线程
        this.notify();
    }



}
