package ca.bytetube._06_binaryTree;

import ca.bytetube._06_binaryTree.file.Files;
import ca.bytetube._06_binaryTree.printer.BinaryTrees;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        test1();
    }

    private static class PersonComparator implements Comparator<Person> {

        @Override
        public int compare(Person p1, Person p2) {
            return (int)(p1.getSalary() - p2.getSalary());
        }
    }


    public static void test1() {
        int[] arr = {7,4,9,2,5,8,11,1,3,6};
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        for (int i = 0; i < arr.length; i++) {
            binarySearchTree.add(arr[i]);
        }

        //树型结构文本化
        String str = BinaryTrees.printString(binarySearchTree);
        str += "\n";
        Files.writeToFile("/Users/phoenixgu/Desktop/text.txt",str,true);
        BinaryTrees.println(binarySearchTree);

//        System.out.println("=============================================");
//        binarySearchTree.remove(3);
//        BinaryTrees.println(binarySearchTree);

//        binarySearchTree.levelOrderTraversal();

//        BinaryTrees.println(binarySearchTree, BinaryTrees.PrintStyle.INORDER);
    }

    public static void test2() {
        Person[] ps = {new Person(10), new Person(100), new Person(110), new Person(120), new Person(18),
                new Person(60), new Person(150), new Person(310),};
        BinarySearchTree<Person> binarySearchTree = new BinarySearchTree<>();
        for (Person p : ps) {
            binarySearchTree.add(p);
        }

        BinaryTrees.println(binarySearchTree);
    }


    public static void test3() {
        Person[] ps = {new Person(10), new Person(100), new Person(110), new Person(120), new Person(18),
                new Person(60), new Person(150), new Person(310),};
        BinarySearchTree<Person> binarySearchTree = new BinarySearchTree<>(new PersonComparator());
        for (Person p : ps) {
            binarySearchTree.add(p);
        }

        BinaryTrees.println(binarySearchTree);
    }



    public static void test4() {
        int[] arr = {7,4,9,2,5,8,11,1,3,12};
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        for (int i = 0; i < arr.length; i++) {
            binarySearchTree.add(arr[i]);
        }

        BinaryTrees.println(binarySearchTree);
        binarySearchTree.preorderTraversal(new BinaryTree.Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                System.out.print(element + " ");
                return element == 2? true : false;
            }
        });

    }

}
