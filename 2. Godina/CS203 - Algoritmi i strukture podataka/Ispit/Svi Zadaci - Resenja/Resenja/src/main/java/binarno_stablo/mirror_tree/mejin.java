package binarno_stablo.mirror_tree;

// Formiranje binarnog stabla i njegovog 'ogledala' (MirrorTree)
public class mejin {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        tree.add(4);
        tree.add(2);
        tree.add(5);
        tree.add(1);
        tree.add(3);

        System.out.print("Inorder obilazak stabla -> ");
        tree.printInorder(); // 1 2 3 4 5
        System.out.println();

        tree.mirror();

        System.out.print("Inorder obilazak stabla -> ");
        tree.printInorder(); // 5 4 3 2 1
        System.out.println();

    }
}
