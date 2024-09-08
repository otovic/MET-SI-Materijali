package liste_povezanosti.zadatak1;

import java.util.*;

public class Graph {
    private Map<Integer, List<Integer>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    public void addEdge(int u, int v) {
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.get(u).add(v);
        adjList.putIfAbsent(v, new ArrayList<>());
        adjList.get(v).add(u); // ako je neusmereni graf
    }

    public int bfs(int start, int end) {
        if (start == end) {
            return 0;
        }

        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> distance = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(start);
        distance.put(start, 0);
        visited.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            int dist = distance.get(node);

            for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    distance.put(neighbor, dist + 1);
                    visited.add(neighbor);
                    queue.add(neighbor);

                    if (neighbor == end) {
                        return distance.get(neighbor);
                    }
                }
            }
        }

        return -1; // Putanja ne postoji
    }
}

