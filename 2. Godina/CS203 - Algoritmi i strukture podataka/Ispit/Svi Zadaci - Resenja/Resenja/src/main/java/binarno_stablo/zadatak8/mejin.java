package binarno_stablo.zadatak8;
// Prebrojavanje koliko elemenata binarnog stabla ima vrednost vecu od zadate vrednosti
public class mejin {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(9);
        tree.add(4);
        tree.add(6);

        System.out.println("Number of nodes that are greater than 4: " + tree.nodesGreaterThanX(4)); // 4
        System.out.println("Number of nodes that are greater than 6: " + tree.nodesGreaterThanX(6)); // 2
        System.out.println("Number of nodes that are greater than 1: " + tree.nodesGreaterThanX(1)); // 7

    }
}
