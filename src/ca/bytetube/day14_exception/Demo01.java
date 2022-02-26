package ca.bytetube.day14_exception;

import com.sun.codemodel.internal.JArray;

public class Demo01 {

    public static void main(String[] args) {
//        int[] arr = new int[3];
//        System.out.println(arr[0]);
//        System.out.println(arr[3]);//ArrayIndexOutOfBoundsException
//        System.out.println("code is here");//异常产生后的代码不会生效，程序会停掉不会向下进行（异常未处理）

//        int[] arr = new int[1024*1024*1000];//OutOfMemoryError


        int[] arr = {42, 27, 88, 66};
        int num = ArrayTools.getElement(null, 2);
//        int num = ArrayTools.getElement(arr, 5);
        System.out.println("num = " + num);


    }
}
