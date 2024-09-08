import binary.Node;

import java.io.IOException;
import java.util.List;

public class main {
    public static void main(String[] args) throws IOException {
        FailHesh h = new FailHesh(4);
        h.load();
        h.printHM();
    }
//    public static void main(String[] args) throws IOException {
//        List<String> s = Rider.ridFajls();
//
//        for (String file : s) {
//            System.out.println("File: " + file);
//        }
//
//        System.out.println("\n");
//
//        s = Rider.SelectionSort(s);
//
//        for (String file : s) {
//            System.out.println("File: " + file);
//        }
//
//        Rider.vrajt(s);
//    }
//    public static void main(String[] args) {
//        String text = "xyzabcabcabcabcpq";
//        List<String> ndemita = Utils.findLongestTandemSubstring(text);
//
//        for (String t : ndemita) {
//            System.out.println("Tandem: " + t);
//        }
//    }
//    public static void main(String[] args) {
//        System.out.println("Karaktera: " + Utils.nadji("testTtTtasdsa", 'a'));
//    }
//    public static void main(String[] args) {
//        Graph graph = new Graph(6);
//
//        // Dodaj ivice u graf
//        graph.addEdge(0, 1);
//        graph.addEdge(0, 2);
//        graph.addEdge(1, 3);
//        graph.addEdge(3, 4);
//        graph.addEdge(4, 5);
//        graph.addEdge(2, 5);
//
//        // Proveri da li se može doći od čvora 0 do čvora 5
//        if (graph.isReachable(0, 5)) {
//            System.out.println("Postoji put od čvora 0 do čvora 5.");
//        } else {
//            System.out.println("Ne postoji put od čvora 0 do čvora 5.");
//        }
//
//        // Proveri da li se može doći od čvora 3 do čvora 2
//        if (graph.isReachable(3, 2)) {
//            System.out.println("Postoji put od čvora 3 do čvora 2.");
//        } else {
//            System.out.println("Ne postoji put od čvora 3 do čvora 2.");
//        }
//    }
//    public static void main(String[] args) {
//        Node root = new Node(10);
//
//        root.left = new Node(5);
//        root.right = new Node(15);
//        root.left.left = new Node(3);
//        root.left.left.left = new Node(3);
//
//        Node current = root;
//
//        int sum = calculateSum(current);
//        System.out.println("Sum of all nodes in the tree: " + sum);
//
//        int sumLeft = calculateLeft(current);
//        System.out.println("Sum of all nodes in the left subtree: " + sumLeft);
//
//        int sumRight = calculateRight(current);
//        System.out.println("Sum of all nodes in the right subtree: " + sumRight);
//
//        int leaves = getLeaves(current);
//        System.out.println("Number of leaves in the tree: " + leaves);
//    }

    public static int calculateSum(Node node) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return node.value;
        }

        int sum = node.value;

        sum = sum + calculateSum(node.left) + calculateSum(node.right);

        return sum;
    }

    public static int calculateLeft(Node node) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return node.value;
        }

        int sum = node.value;

        sum = sum + calculateSum(node.left);

        return sum;
    }

    public static int calculateRight(Node node) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return node.value;
        }

        int sum = node.value;

        sum = sum + calculateSum(node.right);

        return sum;
    }

    public static int getLeaves(Node node) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return 0;
        }

        return 1 + getLeaves(node.left);
    }
}
