package ca.bytetube.day09;

public class Phone {
    String brand;
    double price;
    String color;



    public void call(String name){
        System.out.println("call " + name);
    }

    public void sendMessage(){
        System.out.println("send mss to bytetube");
    }

    public void show(Phone phone){//形式参数,传递的是地址
        System.out.println(phone.brand + ", " + phone.price + ", " + phone.color);
    }

}
