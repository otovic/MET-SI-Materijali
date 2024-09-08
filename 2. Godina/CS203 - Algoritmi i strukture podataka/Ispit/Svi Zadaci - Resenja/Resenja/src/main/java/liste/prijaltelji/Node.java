package liste.prijaltelji;

public class Node {

    String name;
    Node next;

    public Node() {

    }

    public Node(String name) {
        this.name = name;
        this.next = null;
    }

    public Node(String data, Node next) {
        this.name = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", next: =" + next;
    }

    public static Node addNode(Node node, String name) {
        Node head = node;
        Node current = new Node(name);

        if (head == null) {
            current.next = current;
            node = current;
            return node;
        } else {
            Node temp = head;

            while (temp.next != head) {
                temp = temp.next;
            }

            temp.next = current;
            current.next = head;
        }

        return head;
    }

    public static void print(Node node) {
        if (node == null) {
            return;
        }

        Node current = node;

        do {
            System.out.print(current.name + " - ");
            current = current.next;
        } while (current != node);

        System.out.println(node.name);
    }

    public static Node deleteKthNode(Node node, int k) {
        Node head = node;

        if (head == null) {
            return null;
        }

        Node current = head, previous = null;

        while (true) {
            if (current.next == head && current == head) {
                break;
            }

            print(head);

            for (int i = 0; i < k; i++) {
                previous = current;
                current = current.next;
            }

            if (current == head) {
                previous = head;

                while (previous.next != head) {
                    previous = previous.next;
                }

                head = current.next;
                previous.next = head;
                node = head;
            } else if (current.next == head) {
                previous.next = head;
            } else {
                previous.next = current.next;
            }
        }

        return head;
    }

}
