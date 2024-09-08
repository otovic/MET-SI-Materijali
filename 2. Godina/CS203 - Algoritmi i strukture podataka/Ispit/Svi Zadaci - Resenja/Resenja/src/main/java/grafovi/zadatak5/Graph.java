package grafovi.zadatak5;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {
    private int vertices;
    private LinkedList<Integer> adj[];

    public Graph() {

    }

    private void addEdge(int v, int u) {
        adj[v].add(u);
    }

    public int[] topologicalSort(int numCourses, int[][] prerequisites) {
        vertices = numCourses;
        adj = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            adj[i] = new LinkedList<>();
        }

        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < prerequisites.length; i++) {
            addEdge(prerequisites[i][1], prerequisites[i][0]);
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                DFS(i, visited, stack);
            }
        }

        int[] result = new int[vertices];
        int i = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (!stack.isEmpty()) {
            map.put(stack.peek(), i);
            result[i] = stack.peek();
            i++;
            stack.pop();
        }

        for (i = 0; i < vertices; i++) {
            Iterator<Integer> it = adj[i].listIterator();
            while (it.hasNext()) {
                int temp = it.next();
                if (map.get(temp) < map.get(i)) {
                    return new int[0];
                }
            }
        }

        return result;
    }

    private void DFS(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        Iterator<Integer> it = adj[v].listIterator();

        while (it.hasNext()) {
            int i = it.next();
            if (!visited[i]) {
                DFS(i, visited, stack);
            }
        }

        stack.push(v);
    }
}
