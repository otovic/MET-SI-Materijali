package grafovi.zadatak3;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    private int vertices;
    private LinkedList<Integer> adj[];

    public Graph(int v) {
        this.vertices = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int u) {
        adj[v].add(u);
        adj[u].add(v);
    }

    public boolean isCyclic() {
        boolean visited[] = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            visited[i] = false;
        }

        for (int u = 0; u < vertices; u++) {
            if (!visited[u]) {
                if (isCyclic(u, visited, -1)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isCyclic(int v, boolean visited[], int parent) {
        visited[v] = true;
        Iterator<Integer> it = adj[v].iterator();

        while (it.hasNext()) {
            int i = it.next();
            if (!visited[i]) {
                if (isCyclic(i, visited, v)) {
                    return true;
                }
            } else if (i != parent) {
                return true;
            }
        }

        return false;
    }
}
