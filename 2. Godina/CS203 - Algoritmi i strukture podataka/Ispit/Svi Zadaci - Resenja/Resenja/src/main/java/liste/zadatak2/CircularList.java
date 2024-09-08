package liste.zadatak2;

public class CircularList {

    public Node head = null;
    public Node tail = null;

    public CircularList() {

    }

    public void add(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    public void deleteDuplicates() {
        Node current = head, index = null, temp = null;

        if (head == null) {
            System.out.println("List is empty.");
        } else {
            do {
                temp = current;

                index = current.next;
                while (index != head) {
                    if (current.data == index.data) {
                        temp.next = index.next;
                    } else {
                        temp = index;
                    }
                    index = index.next;
                }
                current = current.next;
            } while (current.next != head);
        }
    }

    public void print() {
        Node current = head;

        if (head == null) {
            System.out.println("List is empty.");
        } else {
            do {
                System.out.print(" " + current.data);
                current = current.next;
            } while (current != head);
            System.out.println();
        }
    }

}
