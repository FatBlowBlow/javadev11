package ca.bytetube.day13_interface.homework;

public class Mouse implements USB  {

    @Override
    public void openUSB() {
        System.out.println("mouse's USB opens");
    }

    @Override
    public void closeUSB() {
        System.out.println("mouse's USB closes");
    }


    public void click(){
        System.out.println("mouse is clicking");
    }

}
