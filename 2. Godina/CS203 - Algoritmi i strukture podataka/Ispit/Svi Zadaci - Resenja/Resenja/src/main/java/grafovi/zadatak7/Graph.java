package grafovi.zadatak7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {
    private int vertices;
    private int e;
    private int[][] adj;

    public Graph(int v, int e) {
        this.vertices = v;
        this.e = e;
        adj = new int[v][v];
        for (int row = 0; row < v; row++) {
            Arrays.fill(adj[row], 0);
        }
    }

    public void addEdge(int v, int u) {
        adj[v][u] = 1;
        adj[u][v] = 1;
    }

    public void BFS(int vStart) {
        boolean[] visited = new boolean[vertices];
        Arrays.fill(visited, false);

        List<Integer> q = new ArrayList<>();
        q.add(vStart);
        visited[vStart] = true;

        int vis;
        while (!q.isEmpty()) {
            vis = q.get(0);

            System.out.print(vis + " ");
            q.remove(q.get(0));

            for (int i = 0; i < vertices; i++) {
                if (adj[vis][i] == 1 && (!visited[i])) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }

    }

    public void DFS(int vStart) {
        boolean[] visited = new boolean[vertices];
        DFS(vStart, visited);
    }

    private void DFS(int vStart, boolean[] visited) {
        System.out.print(vStart + " ");
        visited[vStart] = true;

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                DFS(i, visited);
            }
        }
    }
}
