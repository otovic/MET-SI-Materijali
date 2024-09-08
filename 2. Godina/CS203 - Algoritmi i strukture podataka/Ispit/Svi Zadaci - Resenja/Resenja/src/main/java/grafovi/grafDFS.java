package grafovi;

import java.util.*;

//napisati funkciju za obilazak grafa u dubinu koja kada stampa svaki od cvora grafa pored njega ispisuje
//        i redni broj cvora koji je odradjen. koren racunati kao nulti cvor

public class grafDFS {
    public static void dfs(Map<Integer, List<Integer>> graf, int pocetniCvor) {
        // Set za praćenje posetjenih čvorova
        Set<Integer> posetjeni = new HashSet<>();
        // Brojač za redni broj čvora
        int[] brojac = {0};

        // Poziv rekurzivne DFS funkcije
        dfsRekurzivno(graf, pocetniCvor, posetjeni, brojac);
    }

    // Rekurzivna metoda za DFS obilazak
    private static void dfsRekurzivno(Map<Integer, List<Integer>> graf, int cvor, Set<Integer> posetjeni, int[] brojac) {
        // Obeležavamo trenutni čvor kao posetjen
        if (posetjeni.contains(cvor)) {
            return;
        }
        posetjeni.add(cvor);

        // Ispisujemo redni broj čvora
        brojac[0]++;
        System.out.println("Čvor: " + cvor + ", Redni broj: " + (brojac[0] - 1));

        // Rekurzivno obilazimo sve susedne čvorove
        for (int sused : graf.getOrDefault(cvor, Collections.emptyList())) {
            dfsRekurzivno(graf, sused, posetjeni, brojac);
        }
    }

    public static void main(String[] args) {
        // Kreiranje grafa koristeći mapu (lista povezanosti)
        Map<Integer, List<Integer>> graf = new HashMap<>();
        graf.put(0, Arrays.asList(1, 2));
        graf.put(1, Arrays.asList(0, 3, 4));
        graf.put(2, Arrays.asList(0, 5));
        graf.put(3, Arrays.asList(1));
        graf.put(4, Arrays.asList(1));
        graf.put(5, Arrays.asList(2));

        // Pokretanje DFS obilaska sa početnim čvorom 0
        dfs(graf, 0);
    }
}
