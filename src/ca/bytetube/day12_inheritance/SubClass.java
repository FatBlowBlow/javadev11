package ca.bytetube.day12_inheritance;

/**
 * 在父类与子类属性相同的时候，子类会优先调用自己的属性
 *
 * 如果要调用父类的值：关键字 super
 *
 */
public class SubClass extends SuperClass {
    int num = 50;
//    int SubAttr;

//    public SubClass(int superAttr, int SubAttr) {
//        super(superAttr);
//        this.SubAttr = SubAttr;
//    }

//
    public SubClass() {
        super();
        System.out.println("SubClass constructor");
    }

    public void show1() {
        System.out.println("superClass num:" + super.num);
        System.out.println("subClass num:" + this.num);
    }

    /**
     * Override：方法重写
     * 发生前提：1.两个类之间必须发生子父类关系
     *          2.子类与父类当中的方法完全相同（返回值类型，方法名和参数列表都相同）
     */
    @Override
    public void show(){
        System.out.println("subClass show");
    }

    public void setNum(int num) {//int num --> 形式参数
        this.num = num;//当形式参数名称和属性值相同时，this不能省略
    }

    public static void main(String[] args) {
//        SubClass subClass = new SubClass();
//        subClass.show1();
//        subClass.setNum(100);//调用setNum方法时，100 --> 实际参数
//        System.out.println(subClass.num);//50
//        subClass.show();//subClass show

//        SuperClass sb = new SubClass();
//        System.out.println(sb.num);//5
//        sb.show();//subClass show

        //no answer
//        SubClass sb = (SubClass) new SuperClass();
//        System.out.println(sb.num);
//        sb.show();


//        SubClass sb = new SubClass();

    }


}
