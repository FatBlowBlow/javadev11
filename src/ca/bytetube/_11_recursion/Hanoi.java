package ca.bytetube._11_recursion;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Hanoi {
    public static void main(String[] args) {//递推式递归
        System.out.println(hanoi1(3,"A", "C", "B"));;
    }


    public static void hanoi(int n, String from, String to, String help){
        if (n == 1) {
            System.out.println("move " + 1 + " from " + from + " to " + to);//将第1个plate A--->C
        }else {
            hanoi(n - 1, from, help, to);//前n-1个plates 从 A--->B
            System.out.println("move " + n + " from " + from + " to " + to);//将第n个plate A--->C
            hanoi(n - 1, help, to, from);//前n-1个plates 从 B--->C
        }
    }


    public static Set<MoveInfo> hanoi1(int n, String from, String to, String help){
        Set<MoveInfo> moveInfo = new LinkedHashSet<>();//必须有序！
        hanoi1(n, from, to, help, moveInfo);
        return moveInfo;
    }

    private static void hanoi1(int n, String from, String to, String help, Set<MoveInfo> moveInfo) {
        if (n == 1) {
            moveInfo.add(new MoveInfo(n,from,to));
            return;
        }
        hanoi1(n - 1, from, help, to, moveInfo);
        moveInfo.add(new MoveInfo(n,from,to));
        hanoi1(n - 1, help, to, from, moveInfo);
    }


    static class MoveInfo {
        int index;
        String from;
        String to;

        public MoveInfo(int index, String from, String to){
            this.index = index;
            this.from = from;
            this.to = to;
        }

        @Override
        public String toString() {
            return "move " +
                    index +
                    " from " + from +
                    " to " + to;
        }
    }
}
