package liste_povezanosti.zadatak2;

//Listom povezanosti zadat je usmeren graf. Za dva čvora (A, B), proveriti pomoću BFS da li
//        postoji put od A do B, kao i od B do A. Ispisati i broj grana puteva, ako postoje.

public class main {
    public static void main(String[] args) {
        Graph g = new Graph(6);

        // Dodavanje grana u graf
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);

        // Provera puteva između dva čvora
        int A = 0;
        int B = 3;

        g.checkPaths(A, B);
    }
}
