package grafovi.zadatak4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {
    private int vertices;
    private LinkedList<Integer>[] adj;

    public Graph(int v) {
        this.vertices = v;
        adj = new LinkedList[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int u) {
        adj[v].add(u);
    }

    public void DFS() {
        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            visited[i] = false;
        }

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                DFS(i, visited);
            }
        }
    }

    private void DFS(int v, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(v);

        while (!stack.isEmpty()) {
            v = stack.peek();
            stack.pop();

            if (visited[v] == false) {
                System.out.print(v + " ");
                visited[v] = true;
            }

            Iterator<Integer> it = adj[v].iterator();

            while (it.hasNext()) {
                int i = it.next();
                if (!visited[i]) {
                    stack.push(i);
                }
            }
        }

    }
}
