package liste_povezanosti;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//na osnovu liste povezanosti proveriti rekurzivnom metodom da li je graf usmeren.
//        graf je neusmeren ako ima AB i BA granu. ova treba dda vazi za svaku granu

public class zadatak3 {
    public static boolean isUndirected(Map<Integer, List<Integer>> adjacencyList) {
        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
            Integer node = entry.getKey();
            List<Integer> neighbors = entry.getValue();

            // Proveravamo svaku granu od trenutnog čvora
            for (Integer neighbor : neighbors) {
                // Ako postoji grana od node do neighbor, proveravamo da li postoji i obrnuta grana
                if (!adjacencyList.containsKey(neighbor) ||
                        !adjacencyList.get(neighbor).contains(node)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Primer liste povezanosti za neusmereni graf
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

        adjacencyList.put(1, Arrays.asList(2, 3));
        adjacencyList.put(2, Arrays.asList(1, 4));
        adjacencyList.put(3, Arrays.asList(1));
        adjacencyList.put(4, Arrays.asList(2));

        // Provera da li je graf neusmeren
        boolean result = isUndirected(adjacencyList);
        if (result) {
            System.out.println("Graf je neusmeren.");
        } else {
            System.out.println("Graf je usmeren.");
        }
    }
}
