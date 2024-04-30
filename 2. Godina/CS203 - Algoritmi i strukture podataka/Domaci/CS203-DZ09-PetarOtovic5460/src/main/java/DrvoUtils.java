public class DrvoUtils {
    public static int sumaLevihListova(DrvoNoud root) {
        if (root == null) return 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            return root.left.value + sumaLevihListova(root.right);
        } else {
            return sumaLevihListova(root.left) + sumaLevihListova(root.right);
        }
    }

    public static int sumaDesnihListova(DrvoNoud root) {
        if (root == null) return 0;
        if (root.right != null && root.right.left == null && root.right.right == null) {
            return root.right.value + sumaDesnihListova(root.left);
        } else {
            return sumaDesnihListova(root.left) + sumaDesnihListova(root.right);
        }
    }
}
