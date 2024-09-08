package grafovi.zadatak4;
// Pretraga grafa po dubini (DFS) koriscenjem steka umesto rekurzije
public class mein {
    public static void main(String[] args) {

        Graph g = new Graph(5);
        g.addEdge(1, 0);
        g.addEdge(2, 1);
        g.addEdge(3, 4);
        g.addEdge(4, 0);

        System.out.print("Obilazak grafa po dubini -> "); // 0 1 2 3 4
        g.DFS();
        System.out.println();

    }
}
