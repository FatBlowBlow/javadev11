package ca.bytetube._07_AVLTree;

import ca.bytetube._07_AVLTree.file.Files;
import ca.bytetube._07_AVLTree.printer.BinaryTreeInfo;
import ca.bytetube._07_AVLTree.printer.BinaryTrees;

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

    static void test1() {
        Integer data[] = new Integer[]{
                85, 19, 69, 3, 7, 99, 95, 2, 1, 70, 44, 58, 11, 21, 14, 93, 57, 4, 56};

        AVLTree<Integer> avl = new AVLTree<>();
        for (int i = 0; i < data.length; i++) {
            avl.add(data[i]);
//			System.out.println("【" + data[i] + "】");
//			BinaryTrees.println(avl);
//			System.out.println("---------------------------------------");
        }
        BinaryTrees.println(avl);

//        avl.remove(1);
//        BinaryTrees.println(avl);
//        System.out.println("----------------------------");
    }




    public static void test2() {
        Person[] ps = {new Person(10), new Person(100), new Person(110), new Person(120), new Person(18),
                new Person(60), new Person(150), new Person(310),};
        ca.bytetube._07_AVLTree.BinarySearchTree<Person> binarySearchTree = new ca.bytetube._07_AVLTree.BinarySearchTree<>();
        for (Person p : ps) {
            binarySearchTree.add(p);
        }

        BinaryTrees.println((BinaryTreeInfo) binarySearchTree);
    }


    public static void test3() {
        Person[] ps = {new Person(10), new Person(100), new Person(110), new Person(120), new Person(18),
                new Person(60), new Person(150), new Person(310),};
        ca.bytetube._07_AVLTree.BinarySearchTree<Person> binarySearchTree = new ca.bytetube._07_AVLTree.BinarySearchTree<>(new PersonComparator());
        for (Person p : ps) {
            binarySearchTree.add(p);
        }

        BinaryTrees.println((BinaryTreeInfo) binarySearchTree);
    }


    public static void test4() {
        int[] arr = {7,4,9,2,5,8,11,1,3,12};
        AVLTree <Integer> binarySearchTree = new AVLTree<>();
        for (int i = 0; i < arr.length; i++) {
            binarySearchTree.add(arr[i]);
        }

        BinaryTrees.println((BinaryTreeInfo) binarySearchTree);
        binarySearchTree.preorderTraversal(new BinaryTree.Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                System.out.print(element + " ");
                return element == 2? true : false;
            }
        });

    }

}
