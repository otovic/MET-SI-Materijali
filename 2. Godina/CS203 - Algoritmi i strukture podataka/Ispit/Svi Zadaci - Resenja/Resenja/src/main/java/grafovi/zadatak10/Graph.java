package grafovi.zadatak10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
    private int num;
    private List<List<Integer>> adj;

    public Graph(int v) {
        this.num = v;
        adj = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            adj.add(new LinkedList<>());
        }
    }

    public void addEdge(int v, int u) {
        adj.get(v).add(u);
        adj.get(u).add(v);
    }

    public void DFS(int vStart) {
        boolean[] visited = new boolean[num];
        DFS(vStart, visited);
    }

    private void DFS(int vStart, boolean[] visited) {

        System.out.print(vStart + " ");
        visited[vStart] = true;

        for (int v : adj.get(vStart)) {
            if (!visited[v]) {
                DFS(v, visited);
            }
        }

    }

    public void BFS(int vStart) {
        boolean[] visited = new boolean[num];
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
