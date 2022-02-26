package ca.bytetube.day13_interface;

public class Test {

    public static void main(String[] args) {

//        Animal animal = new Dog();
//        System.out.println(animal.feet);//4,父类的属性
//        animal.eat();//eat bones

//        Dog dog = (Dog) animal;//向下造型
//        dog.watchHouse();

        //向下造型中可能会发生的错误
//        Cat cat =(Cat) animal;//创建的对象是Dog，不能转换成Cat对象的
//        cat.catchMouse();//ClassCastException

        //solution --->instanceof
//        if (animal instanceof Cat) {
//            Cat cat =(Cat) animal;
//            cat.catchMouse();
//        }else if(animal instanceof Dog){
//            Dog dog = (Dog) animal;
//            dog.watchHouse();
//        }



        Dog dog = new Dog();
        Cat cat = new Cat();
//        showDog(dog);
//        showCat(cat);
//        Animal animal1 = new Dog();
//        Animal animal2 = new Cat();
//        animal1.eat();//eat bones
//        animal2.eat();//eat fish
        showAnimal(cat);

    }


    public static void showDog(Dog dog){
        dog.eat();
    }

    public static void showCat(Cat cat){
        cat.eat();
    }

    public static void showAnimal(Animal animal){
        animal.eat();
    }
}
