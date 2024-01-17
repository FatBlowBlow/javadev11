package ca.bytetube._04_stack;


import ca.bytetube._03_linkedList.Asserts;
import ca.bytetube._03_linkedList.List;
import ca.bytetube._03_linkedList.circle.CircleLinkedList;

public class Test {
    public static void main(String[] args) {
        testList(new Stack<>());
    }


    public static void testList(Stack<Integer> stack){
        stack.push(11);
        stack.push(22);
        stack.push(33);
        stack.push(44);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("==============");
        System.out.println(stack.peek());

    }
}
