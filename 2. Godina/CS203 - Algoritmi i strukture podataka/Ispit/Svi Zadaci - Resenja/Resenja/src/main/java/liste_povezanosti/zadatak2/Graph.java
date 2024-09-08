package liste_povezanosti.zadatak2;

import java.util.LinkedList;

public class Graph {
    private int V; // Broj čvorova u grafu
    private LinkedList<Integer>[] adjList; // Lista povezanosti

    // Konstruktor
    public Graph(int v) {
        V = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adjList[i] = new LinkedList<>();
    }

    // Dodavanje grane u graf
    public void addEdge(int v, int w) {
        adjList[v].add(w);
    }

    // BFS metod koji vraća broj grana na putu od start do cilj, ako postoji put
    private int BFS(int start, int cilj) {
        boolean[] visited = new boolean[V];
        int[] distance = new int[V]; // Pamti broj grana od starta do svakog čvora

        LinkedList<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while (queue.size() != 0) {
            int node = queue.poll();

            // Prolazak kroz sve susedne čvorove
            for (int n : adjList[node]) {
                if (!visited[n]) {
                    visited[n] = true;
                    distance[n] = distance[node] + 1; // Povećanje broja grana
                    queue.add(n);

                    // Ako smo stigli do cilja, vraćamo broj grana
                    if (n == cilj) {
                        return distance[n];
                    }
                }
            }
        }

        // Ako ne postoji put
        return -1;
    }

    // Metod koji proverava put između dva čvora u oba smera
    public void checkPaths(int A, int B) {
        int pathAToB = BFS(A, B);
        int pathBToA = BFS(B, A);

        if (pathAToB != -1) {
            System.out.println("Postoji put od " + A + " do " + B + " sa " + pathAToB + " grana.");
        } else {
            System.out.println("Ne postoji put od " + A + " do " + B + ".");
        }

        if (pathBToA != -1) {
            System.out.println("Postoji put od " + B + " do " + A + " sa " + pathBToA + " grana.");
        } else {
            System.out.println("Ne postoji put od " + B + " do " + A + ".");
        }
    }
}
