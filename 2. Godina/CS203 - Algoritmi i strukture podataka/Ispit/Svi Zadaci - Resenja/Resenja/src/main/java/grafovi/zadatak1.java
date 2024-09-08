package grafovi;

//napisati funkciju za obilzak grafa u sirinu bfs koja ce kao rezultat vratiti udaljenost od
// cvora a do cvora b. bfs treba pokrenuti iz cvora a i zaustaviti se kada se dodje u covr b

import java.util.*;

public class zadatak1 {
    static class Graph {
        private final Map<Integer, List<Integer>> adjList = new HashMap<>();

        // Dodaj granu u graf
        public void addEdge(int src, int dest) {
            adjList.computeIfAbsent(src, k -> new ArrayList<>()).add(dest);
            adjList.computeIfAbsent(dest, k -> new ArrayList<>()).add(src); // Ako je graf neusmeren
        }

        // Udaljenost između dva čvora koristeći BFS
        public int bfsDistance(int start, int end) {
            // Ako je početni čvor isti kao krajnji, udaljenost je 0
            if (start == end) {
                return 0;
            }

            // Koristimo Queue za BFS i Set za praćenje posetjenih čvorova
            Queue<Integer> queue = new LinkedList<>();
            Map<Integer, Integer> distances = new HashMap<>();

            queue.add(start);
            distances.put(start, 0);

            while (!queue.isEmpty()) {
                int current = queue.poll();
                int currentDistance = distances.get(current);

                // Prolazak kroz sve susede trenutnog čvora
                for (int neighbor : adjList.getOrDefault(current, new ArrayList<>())) {
                    // Ako sused nije posetjen
                    if (!distances.containsKey(neighbor)) {
                        // Postavljanje udaljenosti i dodavanje u red
                        distances.put(neighbor, currentDistance + 1);
                        queue.add(neighbor);

                        // Ako smo stigli do krajnjeg čvora, vraćamo udaljenost
                        if (neighbor == end) {
                            return distances.get(neighbor);
                        }
                    }
                }
            }

            // Ako nije pronađen put do krajnjeg čvora, vraćamo -1
            return -1;
        }
    }

    public static void main(String[] args) {
        // Kreiranje grafa i dodavanje grana
        Graph graph = new Graph();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);
        graph.addEdge(4, 7);
        graph.addEdge(5, 8);

        // Definišemo čvorove
        int startNode = 1;
        int endNode = 8;

        // Izračunavanje udaljenosti između čvorova
        int distance = graph.bfsDistance(startNode, endNode);
        if (distance != -1) {
            System.out.println("Udaljenost između čvora " + startNode + " i čvora " + endNode + " je: " + distance);
        } else {
            System.out.println("Nema puta između čvora " + startNode + " i čvora " + endNode);
        }
    }
}
