package ca.bytetube.day13_interface.homework;

public class KeyBoard implements USB {

    @Override
    public void openUSB() {
        System.out.println("keyboard's USB opens");
    }

    @Override
    public void closeUSB() {
        System.out.println("keyboard's USB closes");
    }


    public void type() {
        System.out.println("keyboard is typing");
    }

}
