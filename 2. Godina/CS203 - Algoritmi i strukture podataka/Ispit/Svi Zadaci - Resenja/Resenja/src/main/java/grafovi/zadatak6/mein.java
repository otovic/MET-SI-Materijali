package grafovi.zadatak6;

import java.util.InputMismatchException;
import java.util.Scanner;
// Neusmereni graf predstavljen pomocu liste povezanosti
// Unos cvora i ispisivanje svih dostiznih cvorova iz unetog cvora
public class mein {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {

            Graph g = new Graph(10);
            g.addEdge(0, 1);
            g.addEdge(0, 3);
            g.addEdge(1, 2);
            g.addEdge(2, 3);
            g.addEdge(4, 5);
            g.addEdge(4, 6);
            g.addEdge(7, 6);
            g.addEdge(8, 9);

            /*
           0 -- 1    4 -- 6    8
           |    |    |    |    |
           |    |    |    |    |
           3 -- 2    5    7    9
             */

            System.out.print("Enter node: ");
            int n = input.nextInt();

            if (n < 0 || n > 9) {
                System.out.println("Graph doesn't contain that node!");
                System.exit(0);
            }

            System.out.print("Reachable nodes from node " + n + " are: ");
            g.BFS(n);
            System.out.println();

        } catch (InputMismatchException ex) {
            System.out.println("Invalid input!");
        }

        input.close();
    }
}
