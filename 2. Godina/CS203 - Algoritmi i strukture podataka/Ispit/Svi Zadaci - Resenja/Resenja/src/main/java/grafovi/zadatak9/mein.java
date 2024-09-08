package grafovi.zadatak9;

import java.util.Arrays;
import java.util.List;
// Provera da li je graf neusmeren
// Graf je neusmeren ako ima i AB i BA granu

public class mein {
    public static void main(String[] args) {

        List<Edge> edges = Arrays.asList(
                new Edge(0, 1), new Edge(0, 3), new Edge(1, 2),
                new Edge(1, 3), new Edge(3, 2), new Edge(3, 4),
                new Edge(3, 0), new Edge(5, 6), new Edge(6, 3));

        int n = 7;

        Graph g = new Graph(edges, n);

        System.out.println(Graph.isGraphUndirected(n));

    }
}
