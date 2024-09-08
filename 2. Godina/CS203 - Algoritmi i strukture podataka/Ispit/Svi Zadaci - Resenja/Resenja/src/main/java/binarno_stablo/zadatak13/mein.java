package binarno_stablo.zadatak13;

import java.util.ArrayList;
import java.util.List;

// Pretvaranje binarnog stabla u sortiranu listu
// Preko parametra, bira se da li je sortiranje rastuce ili opadajuce
// Vremenska slozenost treba da bude O(n)
public class mein {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(9);
        tree.add(4);
        tree.add(6);

        List<Node> list = new ArrayList<>();
        System.out.println(tree.toSortedList(list, 1));

    }
}
