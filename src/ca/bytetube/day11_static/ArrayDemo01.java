package ca.bytetube.day11_static;


import java.util.Random;

public class ArrayDemo01 {
    public static void main(String[] args) {
        int[] arr = getRanArray(100, 10);
        printArray(arr);
        System.out.println();
        System.out.println("=============================");
        BubbleSort.sort(arr);//数据量大时，调用quickSort. 数据量小，insertSort/mergeSort
        printArray(arr);
//        int resIndex = Arrays.binarySearch(arr, 56);//返回的是元素所在数组的index
//        System.out.println();
//        System.out.println(resIndex);

//
//        Student student1 = new Student("fang", 26);
//        Student student2 = new Student("huan",6);
//        Student student3 = new Student("shuo", 36);
//        Student[] students = {student1, student2, student3};
//        printStudents(students);
//        System.out.println();
//        System.out.println("=============================");
//        Arrays.sort(students, new StudentComparator());
//        String StudentString = Arrays.toString(students);
//        System.out.println(StudentString);
    }

    public static int[] getRanArray (int bound, int size){
        int[] arr = new int[size];
        Random random = new Random();
        arr[0] = 56;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }

    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void printStudents(Student[] students){
        for (int i = 0; i < students.length; i++) {
            System.out.print(students[i] + " ");
        }
    }

//    //static也可以修饰类 --> 静态内部类，不希望被外界获取到，是个工具类，声明为private
//    private static class StudentComparator implements Comparator<Student> {
//        @Override
//        public int compare(Student s1, Student s2) {//compare用来写比较规则
//            //如果用 参数1的值 - 参数2的值 < 0 ---> 升序排 (1,2,3,4,5)
//            //如果用 参数1的值 - 参数2的值 > 0 ---> 降序排 (5,4,3,2,1)
//            return s2.getAge() - s1.getAge();
//
//        }
//    }
}
