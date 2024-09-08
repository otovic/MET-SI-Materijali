package grafovi.zadatak8;
// Pronalazenje najvecih distanci od jednog cvora do svih ostalih cvorova usmerenog aciklicnog grafa
public class mein {
    public static void main(String[] args) {

        Graph.G g = new Graph.G(6);
        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 3, 6);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 4, 4);
        g.addEdge(2, 5, 2);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 5, 1);
        g.addEdge(3, 4, -1);
        g.addEdge(4, 5, -2);

        int s = 1;
        System.out.print("Longest distances from source vertex " + s + " \n");
        g.longestPath(s); // INF 0 2 9 8 10

        System.out.println();

    }
}
