package grafovi.zadatak3;

import java.io.*;

// Obilazak grafa po dubini i stampanje rednog broja cvora koji je posecen
// Koren racunati kao nulti cvor
public class mein {
    public static void main(String[] args) {

        BufferedReader br = null;

        try {

            File file = new File("D:\\CS202-Resenja\\Resenja\\src\\main\\java\\grafovi\\zadatak3\\ulaz.txt");
            br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                System.out.println(st);
            }

            loadFromFile();

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

    private static Graph loadFromFile() {
        BufferedReader reader = null;
        Graph g;

        try {
            reader = new BufferedReader(new FileReader("D:\\CS202-Resenja\\Resenja\\src\\main\\java\\grafovi\\zadatak3\\ulaz.txt"));
            String line = null;

            int vertices = Integer.parseInt(reader.readLine());
            g = new Graph(vertices);

            for (int i = 0; i < vertices; i++) {

                line = reader.readLine();
                String[] array = line.split(" ");

                for (int j = 1; j < array.length; j++) {
                    g.addEdge(Integer.parseInt(array[0]), Integer.parseInt(array[j]));
                }

            }

            System.out.println(g.isCyclic());

            return g;

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }
}
