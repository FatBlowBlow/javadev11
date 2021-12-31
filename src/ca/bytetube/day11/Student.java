package ca.bytetube.day11;

public class Student {
    private String name;
    private int age;
    private int sid;
    public static int numOfStudent = 0;//一般被static修饰的数据，是共享状态，设置为共有public

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSid() {
        show();//成员方法中可以调用静态方法
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        sid = ++numOfStudent;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sid=" + sid +
                '}';
    }

    public static void show(){
        System.out.println(numOfStudent);//静态方法中只能调用静态变量or静态方法
        //原因：所属关系不同，static关键字所修饰的变量or方法属于类，成员变量or成员方法属于对象

//        System.out.println(name);//不能在静态方法中调用成员变量
//        getSid();//不能在静态方法中调用成员方法
    }

    public static void main(String[] args) {
        Student student1 = new Student("fang", 26);
        Student.show();
        Student student2 = new Student("huan",6);
        Student.show();
        Student student3 = new Student("shuo", 36);
        Student.show();
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
        Student.show();//类直接调用静态方法
        student1.show();//对象可以调用静态方法，但不建议

    }
}
