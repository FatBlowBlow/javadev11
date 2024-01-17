package ca.bytetube.day13_interface.homework;

public class Test {

    public static void main(String[] args) {
        Laptop laptop = new Laptop();
        laptop.startUp();

//        Mouse mouse = new Mouse();
//        laptop.useUsbDevice(mouse);//参数可以传父类/接口类，及其子类/实现类

        USB usb = new Mouse();
        laptop.useUsbDevice(usb);
//        USB usb = null;
        laptop.shutDown();


    }
}
