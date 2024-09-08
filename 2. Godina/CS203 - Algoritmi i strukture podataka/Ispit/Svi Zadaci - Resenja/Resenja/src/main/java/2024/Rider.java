import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Rider {
    public static List<String> ridFajls() throws IOException {
        List<String> failNames = new ArrayList<>();

        BufferedReader r = new BufferedReader(new FileReader("fails.txt"));

        String line;
        while ((line = r.readLine()) != null) {
            failNames.add(line);
        }

        return failNames;
    }

    public static List<String> SelectionSort(List<String> fails) {
        int n = fails.size();

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                String ext1 = fails.get(i).split("\\.")[1];
                String ext2 = fails.get(j).split("\\.")[1];

                if (ext2.compareTo(ext1) < 0) {
                    minIndex = j;
                }
            }

            String temp = fails.get(minIndex);
            fails.set(minIndex, fails.get(i));
            fails.set(i, temp);
        }

        return fails;
    }

    public static List<String> mergeSort(List<String> files) {
        if (files.size() <= 1) {
            return files;
        }

        int mid = files.size() / 2;
        List<String> left = mergeSort(files.subList(0, mid));
        List<String> right = mergeSort(files.subList(mid, files.size()));

        return merge(left, right);
    }

    public static List<String> bubbleSort(List<String> files) {
        int n = files.size();
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                String ext1 = files.get(j).split("\\.")[1];
                String ext2 = files.get(j + 1).split("\\.")[1];

                if (ext1.compareTo(ext2) > 0) {
                    // Swap files[j] and files[j+1]
                    String temp = files.get(j);
                    files.set(j, files.get(j + 1));
                    files.set(j + 1, temp);
                    swapped = true;
                }
            }

            // If no two elements were swapped in the inner loop, break
            if (!swapped) {
                break;
            }
        }

        return files;
    }

    private static List<String> merge(List<String> left, List<String> right) {
        List<String> merged = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            String ext1 = left.get(i).split("\\.")[1];
            String ext2 = right.get(j).split("\\.")[1];

            if (ext1.compareTo(ext2) <= 0) {
                merged.add(left.get(i));
                i++;
            } else {
                merged.add(right.get(j));
                j++;
            }
        }

        while (i < left.size()) {
            merged.add(left.get(i));
            i++;
        }

        while (j < right.size()) {
            merged.add(right.get(j));
            j++;
        }

        return merged;
    }

//    public static void main(String[] args) {
//        List<String> files = new ArrayList<>();
//        files.add("file1.txt");
//        files.add("file2.pdf");
//        files.add("file3.doc");
//        files.add("file4.jpg");
//
//        List<String> sortedFiles = mergeSort(files);
//
//        for (String file : sortedFiles) {
//            System.out.println(file);
//        }
//    }

    public static void vrajt(List<String> s) throws IOException {
        BufferedWriter w = new BufferedWriter(new FileWriter("izlaz.txt", true));

        for (String l : s) {
            w.write(l );
            w.newLine();
        }

        w.close();
    }
}
