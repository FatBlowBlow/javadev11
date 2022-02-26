package ca.bytetube.day12_inheritance;

/**
 * Overload 方法的重载  / Override 方法的重写
 * 区别：
 * 1. Overload 在同一个类中， Override 发生在两个类中（父子类）
 * 2. Overload 只要求2个方法的方法名相同，参数列表不同即可（3种：类型，个数，顺序不同）
 *    Override 要求子类方法的权限（可见度，eg: public, private..）必须大于等于父类同名方法的权限
 *    并且要求子类父类同名方法的返回值类型，方法名称，参数列表必须一模一样
 */
public class SmartPhone extends Phone {

    @Override
    public void showNum() {
        super.showNum();//调用父类已经存在的功能
        System.out.println("show image");//增强自己特有的功能
    }

    public static void main(String[] args) {
        SmartPhone sp = new SmartPhone();
        sp.call();
        sp.showNum();
    }
}
