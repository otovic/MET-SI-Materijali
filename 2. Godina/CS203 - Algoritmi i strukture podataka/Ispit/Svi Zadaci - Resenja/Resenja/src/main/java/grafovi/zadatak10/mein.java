package grafovi.zadatak10;
// Graf je predstavljen preko liste povezanosti
// DFS i BFS pretrage grafova
public class mein {
    public static void main(String[] args) {

        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(5, 4);

        System.out.print("Obilazak grafa po sirini -> ");
        g.BFS(2); // 2 0 1 3 4 5

        System.out.println();
        System.out.println("---------------------------------------");

        System.out.print("Obilazak grafa po dubini -> ");
        g.DFS(2); // 2 0 1 3 4 5
        System.out.println();

    }
}
