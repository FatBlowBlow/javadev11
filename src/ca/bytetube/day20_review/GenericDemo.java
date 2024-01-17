package ca.bytetube.day20_review;


// 泛型类
public class GenericDemo<E> {
    private E data;

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public <T> T showData(T data){
        return data;
    }

    public static void main(String[] args) {
        GenericDemo<String> s = new GenericDemo<>();
        s.setData("fang");
//        System.out.println(s.getData());

        //泛型类不影响泛型方法,泛型方法是独立的，可以接受任意数据
        System.out.println(s.showData(10));
    }


}
