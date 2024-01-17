package ca.bytetube._03_linkedList.JosephusProblem;


public class Test {
    public static void main(String[] args) {
        josephus();
    }

    public static void josephus(){
        JosephusProblemLinkedList<Integer> circleLinkedList = new JosephusProblemLinkedList<>();
        for (int i = 1; i <= 8 ; i++) {
            circleLinkedList.add(i);
        }
        //reset
        circleLinkedList.reset();
        int count = circleLinkedList.size();
        while(count != 0){
            circleLinkedList.next();//第三个人被杀，因为指针在1了，所以只用走两步
            circleLinkedList.next();
            System.out.println(circleLinkedList.remove());
            count--;
        }
    }
}
