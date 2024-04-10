package org.example;
import  org.example.ListNode;

public class Main {
        public static ListNode reverseLinkedList(ListNode head) {
            ListNode previous = null;
            ListNode current = head;
            ListNode next = null;

            while (current != null) {
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }

            return previous;
        }

        public static void printLinkedList(ListNode head) {
            ListNode current = head;
            while (current != null) {
                System.out.print(current.val + " ");
                current = current.next;
            }
            System.out.println();
        }

        public static void main(String[] args) {
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(4);
            head.next.next.next.next = new ListNode(5);

            System.out.println("Pocetna lista:");
            printLinkedList(head);

            ListNode reversedHead = reverseLinkedList(head);

            System.out.println("Obrnuta lista: ");
            printLinkedList(reversedHead);
        }
}