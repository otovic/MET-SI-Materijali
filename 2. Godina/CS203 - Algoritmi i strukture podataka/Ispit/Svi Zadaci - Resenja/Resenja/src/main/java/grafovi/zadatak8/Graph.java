package grafovi.zadatak8;

import java.util.ArrayList;
import java.util.Stack;

public class Graph {
    static class AdjList {

        int v;
        int weight;

        public AdjList(int v, int w) {
            this.v = v;
            this.weight = w;
        }

        public int getV() {
            return v;
        }

        public int getWeight() {
            return weight;
        }

    }

    static class G {

        int vertices;
        ArrayList<ArrayList<AdjList>> adj;

        public G(int v) {
            this.vertices = v;
            adj = new ArrayList<>(vertices);
            for (int i = 0; i < v; i++) {
                adj.add(new ArrayList<>());
            }
        }

        public void addEdge(int u, int v, int weight) {
            AdjList node = new AdjList(v, weight);
            adj.get(u).add(node);
        }

        private void topologicalSort(int v, boolean[] visited, Stack<Integer> stack) {
            visited[v] = true;

            for (int i = 0; i < adj.get(v).size(); i++) {
                AdjList node = adj.get(v).get(i);
                if (!visited[node.getV()]) {
                    topologicalSort(node.getV(), visited, stack);
                }
            }

            stack.push(v);
        }

        public void longestPath(int s) {
            Stack<Integer> stack = new Stack<>();
            int dist[] = new int[vertices];
            boolean[] visited = new boolean[vertices];

            for (int i = 0; i < vertices; i++) {
                visited[i] = false;
            }

            for (int i = 0; i < vertices; i++) {
                if (!visited[i]) {
                    topologicalSort(i, visited, stack);
                }
            }

            for (int i = 0; i < vertices; i++) {
                dist[i] = Integer.MIN_VALUE;
            }

            dist[s] = 0;

            while (!stack.isEmpty()) {
                int u = stack.peek();
                stack.pop();

                if (dist[u] != Integer.MIN_VALUE) {
                    for (int i = 0; i < adj.get(u).size(); i++) {
                        AdjList node = adj.get(u).get(i);
                        if (dist[node.getV()] < dist[u] + node.getWeight()) {
                            dist[node.getV()] = dist[u] + node.getWeight();
                        }
                    }
                }
            }

            for (int i = 0; i < vertices; i++) {
                if (dist[i] == Integer.MIN_VALUE) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i] + " ");
                }
            }

        }

    }
}
