package ca.bytetube.day14_exception;

//一般工具类中的方法用static， 因为不希望创建对象，可以直接通过类名.的方式调用方法
public class ArrayTools {

    public static int getElement(int[] arr, int index) throws NullPointerException, ArrayIndexOutOfBoundsException{
        if (arr == null ) {
            throw new NullPointerException("array is null!");
        }

        if (index < 0 || index > arr.length - 1) {
            throw new ArrayIndexOutOfBoundsException("error index, " + index + " does not exists");
        }
        int ele = arr[index];
        return ele;


    }
}
