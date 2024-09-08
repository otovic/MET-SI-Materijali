package binarno_stablo.zadatak10NZD;
// Izracunavanje NZD-a proizvoda svih levih cvorova koji nisu listovi i proizvoda svih desnih cvorova koji nisu listovi
// Funkciji se prosledjuje koren stabla kao argument
public class mein {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        tree.add(10);
        tree.add(4);
        tree.add(3);
        tree.add(5);
        tree.add(6);
        tree.add(15);
        tree.add(16);
        tree.add(17);

        System.out.print("Inorder obilazak stabla -> ");
        tree.printInorder(); // 3 4 5 6 10 15 16 17
        System.out.println();

        System.out.println("GCD is: " + tree.findGCD(tree.root)); // 20 ^ 240 -> 20

    }
}
