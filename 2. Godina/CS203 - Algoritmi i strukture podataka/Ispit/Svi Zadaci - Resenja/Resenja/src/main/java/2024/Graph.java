import java.util.LinkedList;

public class Graph {
    public int vertices;
    public LinkedList<Integer>[] adj;

    public Graph(int v) {
        this.vertices = v;
        this.adj = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int b) {
        this.adj[v].add(b);
    }

    public boolean isReachable(int f, int s) {
        if (f == s) return true;

        boolean[] visited = new boolean[this.vertices];
        LinkedList<Integer> q = new LinkedList<>();

        visited[f] = true;
        q.add(f);

        while (q.size() != 0) {
            int node = q.poll();

            for (Integer n : this.adj[node]) {
                if (n == s) return true;
                if (!visited[n]) {
                    visited[n] = true;
                    q.add(n);
                }
            }
        }

        return false;
    }
}
