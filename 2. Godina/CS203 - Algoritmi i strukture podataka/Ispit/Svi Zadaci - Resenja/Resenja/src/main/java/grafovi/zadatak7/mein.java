package grafovi.zadatak7;
// Graf je predstavljen preko matrice povezanosti
// DFS i BFS pretrage grafova
public class mein {
    public static void main(String[] args) {

        int vertices = 6, edges = 7;

        Graph g = new Graph(vertices, edges);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(5, 4);

        System.out.print("Obilazak grafa po dubini -> ");
        g.DFS(2); // 2 0 1 3 4 5

        System.out.println();
        System.out.println("---------------------------------------");

        System.out.print("Obilazak grafa po sirini -> ");
        g.BFS(1); // 1 0 2 3 4 5
        System.out.println();

    }
}
