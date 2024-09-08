package grafovi.zadatak9;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    static List<List<Integer>> adjList;

    public Graph(List<Edge> edges, int n) {
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (Edge edge : edges) {
            adjList.get(edge.source).add(edge.destination);
        }
    }

    private static int DFS(int v, boolean[] discovered, int[] departure, int time) {
        discovered[v] = true;

        for (int u : adjList.get(v)) {
            if (!discovered[u]) {
                time = DFS(u, discovered, departure, time);
            }
        }

        departure[v] = time++;

        return time;
    }

    public static boolean isGraphUndirected(int n) {
        boolean[] discovered = new boolean[n];
        int[] departure = new int[n];
        int time = 0;

        for (int i = 0; i < n; i++) {
            if (!discovered[i]) {
                time = DFS(i, discovered, departure, time);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int v : adjList.get(i)) {
                if (departure[i] <= departure[v]) {
                    return true;
                }
            }
        }

        return false;
    }
}
