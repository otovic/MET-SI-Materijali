package binarno_stablo.zadatak1;

class BinaryTree {
    TreeNode root;

    // Metod za sabiranje elemenata na putu od korena do zadatog čvora
    public int sumPathToNode(TreeNode node, int target) {
        // Bazni slučaj: ako je stablo prazno ili nismo našli čvor
        if (node == null) {
            return 0;
        }

        // Ako smo našli zadati čvor, vrati njegovu vrednost
        if (node.value == target) {
            return node.value;
        }

        // Ako je cilj u levom podstablu
        if (target < node.value) {
            int leftSum = sumPathToNode(node.left, target);
            if (leftSum != 0) {
                return node.value + leftSum;
            }
        }
        // Ako je cilj u desnom podstablu
        else if (target > node.value) {
            int rightSum = sumPathToNode(node.right, target);
            if (rightSum != 0) {
                return node.value + rightSum;
            }
        }

        // Ako čvor nije pronađen u stablu, vrati 0
        return 0;
    }
}
