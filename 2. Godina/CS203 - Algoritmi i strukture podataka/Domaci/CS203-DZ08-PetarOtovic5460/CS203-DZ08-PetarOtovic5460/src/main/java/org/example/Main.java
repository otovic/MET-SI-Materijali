package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Pod A - kopirati istim redosledom");
        Stack stack1 = new Stack();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);

        Stack stack2 = new Stack();

        stack1.transferSameOrder(stack2);

        System.out.println("Sadržaj stack2 nakon prebacivanja istim redosledom:");
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop());
        }

        System.out.println("\n\n");
        System.out.println("Pod B - kopirati inverznim redosledom");

        Stack stack3 = new Stack();

        stack1.transferReverseOrder(stack3);

        System.out.println("Sadržaj stack2 nakon prebacivanja inverznim redosledom:");
        while (!stack3.isEmpty()) {
            System.out.println(stack3.pop());
        }
    }
}