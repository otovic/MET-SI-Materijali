package grafovi;

//napisati program koji racuna ulazni i izlazni stepen cvora grafa predstavljenog pomocu matrica susedstva
public class zadatak2 {
    public static int getOutgoingDegree(int[][] adjacencyMatrix, int node) {
        int outgoingDegree = 0;
        for (int j = 0; j < adjacencyMatrix[node].length; j++) {
            if (adjacencyMatrix[node][j] == 1) {
                outgoingDegree++;
            }
        }
        return outgoingDegree;
    }

    // Metod za računanje ulaznog stepena čvora
    public static int getIncomingDegree(int[][] adjacencyMatrix, int node) {
        int incomingDegree = 0;
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[i][node] == 1) {
                incomingDegree++;
            }
        }
        return incomingDegree;
    }

    public static void main(String[] args) {
        // Primer matrice susedstva za graf
        int[][] adjacencyMatrix = {
                {0, 1, 0, 0},
                {0, 0, 1, 1},
                {1, 0, 0, 1},
                {0, 1, 1, 0}
        };

        // Čvor za koji želimo da izračunamo stepen
        int node = 1; // Primer čvora

        // Računanje stepena
        int outgoingDegree = getOutgoingDegree(adjacencyMatrix, node);
        int incomingDegree = getIncomingDegree(adjacencyMatrix, node);

        // Ispis rezultata
        System.out.println("Čvor " + node + " ima izlazni stepen: " + outgoingDegree);
        System.out.println("Čvor " + node + " ima ulazni stepen: " + incomingDegree);
    }
}
