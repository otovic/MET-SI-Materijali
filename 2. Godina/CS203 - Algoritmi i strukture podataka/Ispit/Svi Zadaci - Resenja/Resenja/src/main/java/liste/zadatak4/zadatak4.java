package liste.zadatak4;

// Ubacivanje elemenata u kruzno povezanu listu
// Izracunavanje sume elemenata liste

import static liste.zadatak4.Node.push;
import static liste.zadatak4.Node.sumOfList;

public class zadatak4 {

    public static void main(String[] args) {

        Node head = null;

        head = push(head, 12);
        head = push(head, 56);
        head = push(head, 2);
        head = push(head, 11);

        System.out.println("Sum of elements of circular linked list is: " + sumOfList(head)); // 81

    }

}
