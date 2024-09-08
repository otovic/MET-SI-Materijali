package grafovi.zadatak6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
    private int vertices;
    private List<List<Integer>> adj;

    public Graph(int v) {
        this.vertices = v;
        adj = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adj.add(new LinkedList<>());
        }
    }

    public void addEdge(int v, int u) {
        adj.get(v).add(u);
        adj.get(u).add(v);
    }

    public void BFS(int vStart) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[vStart] = true;
        queue.offer(vStart);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int s : adj.get(node)) {
                if (!visited[s]) {
                    visited[s] = true;
                    queue.offer(s);
                }
            }
        }

    }
}
