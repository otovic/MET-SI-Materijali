package liste_povezanosti.zadatak1;

import java.util.*;

//Napisati program koji proverava da li se može doći od čvora A do čvora B grafa predstavljenog pomoću
//        liste povezanosti. Ispisati broj grana od čvora A do čvora B, a u slučaju da ne postoji putanja, ispisati
//        odgovarajuću poruku.

public class zadatak1 {

    public static void main(String[] args) {
        Graph graph = new Graph();

        // Dodavanje grana u graf
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        int start = 1;
        int end = 5;

        int result = graph.bfs(start, end);

        if (result != -1) {
            System.out.println("Broj grana od čvora " + start + " do čvora " + end + " je: " + result);
        } else {
            System.out.println("Ne postoji putanja od čvora " + start + " do čvora " + end);
        }
    }
}
