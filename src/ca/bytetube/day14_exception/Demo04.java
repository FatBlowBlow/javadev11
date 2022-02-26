package ca.bytetube.day14_exception;

public class Demo04 {
    public static void main(String[] args) {

        try{
            int[] arr = new int[3];
            arr = null;
            if (arr == null) {
                throw new NullPointerException("arr is null!");
            }
        }catch (NullPointerException e){
            String message = e.getMessage();
            System.out.println(message);//arr is null!

            String s = e.toString();
            System.out.println(s);//java.lang.NullPointerException: arr is null!

            e.printStackTrace();
        }

    }
}
