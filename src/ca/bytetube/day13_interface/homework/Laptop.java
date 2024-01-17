package ca.bytetube.day13_interface.homework;

public class Laptop{

    public void startUp(){
        System.out.println("laptop starts");
    }

    public void shutDown(){
        System.out.println("laptop shutDown");
    }


    public void useUsbDevice(USB usb){//public方法，需要对参数做判断
//        if (usb == null) return;//return直接把程序停掉
        if (usb != null) {

            usb.openUSB();//开启

            if (usb instanceof Mouse) {
                Mouse m = (Mouse) usb;
                m.click();
            }else if(usb instanceof KeyBoard){
                KeyBoard k = (KeyBoard) usb;
                k.type();
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            usb.closeUSB();//关闭
        }

    }

}
