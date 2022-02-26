package ca.bytetube.day15_collection;

public class MyGenericClass<MVP> {

    private MVP mvp;

    public MVP getMvp() {
        return mvp;
    }

    public void setMvp(MVP mvp) {
        this.mvp = mvp;
    }

    public static void main(String[] args) {
        MyGenericClass<String> my = new MyGenericClass<String>();
        my.setMvp("fang");
        String mvp = my.getMvp();
        System.out.println(mvp);


        MyGenericClass<Double> my2 = new MyGenericClass<>();
        my2.setMvp(1.0);
        Double mvp1 = my2.getMvp();
        System.out.println(mvp1);
    }
}
