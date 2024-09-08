package liste.zadatak4;

public class Node {

    int data;
    Node next;

    public static Node push(Node head, int data) {
        Node x = new Node();
        Node z = head;
        x.data = data;
        x.next = head;

        if (head != null) {
            while (z.next != head) {
                z = z.next;
            }
            z.next = x;
        } else {
            x.next = x;
        }

        head = x;

        return head;
    }

    public static int sumOfList(Node head) {
        Node temp = head;
        int sum = 0;

        if (head != null) {
            do {
                temp = temp.next;
                sum += temp.data;
            } while (temp != head);
        }

        return sum;
    }

}
