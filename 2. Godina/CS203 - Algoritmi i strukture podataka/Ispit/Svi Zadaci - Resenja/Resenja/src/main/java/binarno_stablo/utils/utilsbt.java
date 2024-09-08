package binarno_stablo.utils;

public class utilsbt {
    class Node {
        int data;
        Node left, right;

        public Node(int value) {
            this.data = value;
            this.left = this.right = null;
        }
    }

    public class BinarnoStablo {
        private Node root;

        public BinarnoStablo() {
            this.root = null;
        }

        public void insert(int value) {
            root = insertRec(root, value);
        }

        private Node insertRec(Node root, int value) {
            if (root == null) {
                root = new Node(value);
                return root;
            }

            if (value < root.data) {
                root.left = insertRec(root.left, value);
            } else if (value > root.data) {
                root.right = insertRec(root.right, value);
            }

            return root;
        }

        //vraca odnos srednje vrednosti unutrasnjih cvorova i korena
        public boolean isAverageSmallerThanRoot() {
            Result result = new Result();
            int rootValue = root != null ? root.data : 0;

            if (root == null) {
                System.out.println("Stablo je prazno.");
                return false;
            }

            int internalNodeCount = countInternalNodes(root, result);

            if (internalNodeCount == 0) {
                System.out.println("Stablo nema unutrašnjih čvorova.");
                return false;
            }

            //pretvara vrednost u prosečnu vrednost
            double averageValue = (double) result.sum / internalNodeCount;

            System.out.println("Prosečna vrednost unutrašnjih čvorova: " + averageValue);
            System.out.println("Vrednost u korenu stabla: " + rootValue);

            return averageValue < rootValue;
        }

        //prebrojava unutrašnja stabla
        private int countInternalNodes(Node node, Result result)
        {
            if (node == null) {
                return 0;
            }

            if (node.left == null && node.right == null) {
                return 0;
            /* ako zelimo da racunamo listove
            result.sum += node.data;
            return 1;
             */
            }

            result.sum += node.data;

            return 1 + countInternalNodes(node.left, result) + countInternalNodes(node.right, result);
        }

        private static class Result {
            int sum;

            Result() {
                sum = 0;
            }
        }
        //_____________________________________________________________

        //pronalazi najveci zajednicki delilac proizvoda svih levih listova i proizvoda svih desnih listova u odnosu na prosledjeni cvor
        public int findGCDOfLeafProducts(Node node)
        {
            if(node == null)
                return -1;

            int leftLeafProduct = getProductOfLeafValues(node.left);
            int rightLeafProduct = getProductOfLeafValues(node.right);

            return findGCD(leftLeafProduct, rightLeafProduct);
        }


        //______________________________________________________________________

        //pronalazi najveci zajednicki delilac proizvoda svih levih cvorova koji nisu listovi i proizvoda svih desnih cvorova koji nisu listovi u odnosu na prosledjeni cvor

        public int findGCDOfInnerProducts(Node node)
        {
            if(node == null || (node.left == null && node.right == null))
                return 0;

            int productLeft = getProductOfInnerValues(node.left);
            int productRight = getProductOfInnerValues(node.right);

            return findGCD(productLeft, productRight);
        }
        //________________________________________________________________

        //pronalazi najveci zajednicki delilac proizvoda svih levih listova i desnih unutrasnjih cvorova
        public int findGCDOfLeftLeavesAndRightIneerProducts(Node node)
        {
            if(node == null)
                return 0;

            int leftProduct = getLeafSum(node.left);
            int rightProduct = getInnerSum(node.right);

            return findGCD(leftProduct, rightProduct);
        }
        //______________________________________________

        //vraća broj cvorova koji imaju vecu vrednost od uporedjene
        public int countNodesGreatherThanValue(Node node, int targetValue)
        {
            if (node == null)
                return 0;

            int count = 0;

            if(node.data > targetValue)
            {
                count++;
                System.out.println("Cvor " + node.data + " veci od " + targetValue);
            }

            count += countNodesGreatherThanValue(node.left, targetValue);
            count += countNodesGreatherThanValue(node.right, targetValue);

            return count;
        }

        //______________________________________


        //suma listova deljiva korenom
        public boolean isLeafSumDivisableByRoot()
        {
            if(root == null)
                return false;

            int leafSum = getLeafSum(root);
            int rootValue = root.data;

            System.out.println("Zbir vrednosti listova:\t" + leafSum);
            System.out.println("Vrednost u korenu stabla:\t" + rootValue);

            return leafSum % rootValue == 0;
        }




        //stablo u sortiranu listu
        public List<Integer> convertBSTToList(boolean ascending)
        {
            List<Integer> sortedList = new LinkedList<>();
            Stack<Node> stack = new Stack<>();
            Node current = root;

            while(current != null || !stack.empty())
            {
                while(current != null)
                {
                    stack.push(current);
                    current = ascending ? current.left : current.right;
                }

                current = stack.pop();
                sortedList.add(current.data);

                current = ascending ? current.right : current.left;
            }

            return sortedList;
        }

        //da li je zbir listova prost broj
        public boolean isSumOfLeavesPrime()
        {
            int sum = getLeafSum(root);
            return isPrime(sum);
        }

        private boolean isPrime(int number)
        {
            if (number < 2)
                return false;

            for(int i = 2; i <= Math.sqrt(number); i++)
            {
                if(number % 2 == 0)
                    return false;
            }

            return true;
        }

    /*
    UTIL
     */

        //vraca pomnozene listove
        public int getProductOfLeafValues(Node node)
        {
            if (node == null)
                return 1;

            if(node.left == null && node.right == null)
                return node.data;

            return getProductOfLeafValues(node.left) * getProductOfLeafValues(node.right);
        }

        //vraca pomnozene unutrasnje cvorove
        private int getProductOfInnerValues(Node node)
        {
            if(node == null)
                return 1;

            if(node.left == null && node.right == null)
                return 1;

            return node.data * getProductOfInnerValues(node.left) * getProductOfInnerValues(node.right);
        }

        //pronalazi najveci zajednici delilac
        private int findGCD(int left, int right)
        {
            while(right != 0)
            {
                int temp = right;
                right = left % right;
                left = temp;
            }

            return Math.abs(left);
        }

        //izracunava zbir listova
        private int getLeafSum(Node node)
        {
            if (root == null)
                return 0;

            if(node.left == null && node.right == null)
                return node.data;

            return getLeafSum(node.left) + getLeafSum(node.right);
        }

        //izracunava sumu unutrasnjih clanova
        public int getInnerSum(Node node)
        {
            if(node == null || (node.left == null && node.right == null))
                return 0;

            return node.data + getInnerSum(node.left) + getInnerSum(node.right);
        }


        public static void main(String[] args)
        {
            BinarnoStablo bst = new BinarnoStablo();
            bst.insert(8);
            bst.insert(4);
            bst.insert(12);
            bst.insert(2);
            bst.insert(6);
            bst.insert(10);
            bst.insert(14);

            //#####################################

            if (bst.isAverageSmallerThanRoot()) {
                System.out.println("Prosečna vrednost unutrašnjih čvorova je manja od vrednosti u korenu.");
            } else {
                System.out.println("Prosečna vrednost unutrašnjih čvorova je veća ili jednaka vrednosti u korenu.");
            }

            //#####################################

            Node currentNode = bst.root;

            int gcd = bst.findGCDOfLeafProducts(currentNode);

            if (gcd != -1) {
                System.out.println("Najveći zajednički delilac proizvoda levih i desnih listova: " + gcd);
            } else {
                System.out.println("Stablo je prazno.");
            }

            //#####################################

            Node curNode = bst.root;
            int comparison = 7;
            System.out.println("Broj vrednosti veće od poređene " + bst.countNodesGreatherThanValue(curNode, comparison));

            //#######################################

            System.out.println(bst.isLeafSumDivisableByRoot());

            //#######################################
            List<Integer> sortedList = bst.convertBSTToList(false);
            System.out.println(sortedList);

            //#######################################
            System.out.println(bst.isSumOfLeavesPrime());

            //#######################################
            System.out.println(bst.findGCDOfInnerProducts(curNode));

            System.out.println(bst.getInnerSum(curNode));
        }

    }
}
