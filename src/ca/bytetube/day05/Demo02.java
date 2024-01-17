package ca.bytetube.day05;

public class Demo02 {
    public static void main(String[] args) {
        try {
            double[] arr1 = new double[10];
            arr1[5] = 55;
            System.out.println(arr1[5]);
            double[] arr2 = arr1;//一段内存可以被多个引用对象指向
            arr2[5] = 555;
            System.out.println(arr1[5]);
        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
