package ca.bytetube.day12_inheritance.RedPack;

import java.util.ArrayList;
import java.util.Random;

public class Host extends User {
    ArrayList<Double> redPacks;

    public Host(String userName, double balance) {
        super(userName, balance);
    }


    //均分红包
//    public void sendMoney(double amount, int n){
//       this.setBalance(this.getBalance() - amount);
//       double unit = amount / n;
//       redPacks = new ArrayList<>();//自动维护数组的大小
//       for (int i = 0; i < n ; i++) {
//            redPacks.add(unit);
//        }
//    }

    //随机红包
//    public void sendMoney(double amount, int n){
//        this.setBalance(this.getBalance() - amount);
//        Random random = new Random();
//        redPacks = new ArrayList<>();
//
//        double unit = 0;
//        double rest = amount;
//        double res = 0;
//
//        for (int i = 0; i < n - 1; i++) {
//            rest = rest - unit;
//            unit = random.nextDouble() * rest;//random.nextDouble()数据范围 (0,1)
//            redPacks.add(unit);
//            res += unit;
//        }
//        redPacks.add(amount - res);//最后一个红包
//    }


    //随机红包
    public void sendMoney(double amount, int n){
        this.setBalance(this.getBalance() - amount);
        Random random = new Random();
        redPacks = new ArrayList<>();
        Double[] arr = new Double[n];
        double unit = 0;
        double rest = 1;

        for (int i = 0; i < n - 1; i++) {
            arr[i] = rest - random.nextDouble();



            unit = arr[i] * amount;
            redPacks.add(unit);
        }

    }


}
