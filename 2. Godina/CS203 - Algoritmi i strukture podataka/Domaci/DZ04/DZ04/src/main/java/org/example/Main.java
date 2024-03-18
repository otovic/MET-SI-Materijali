package org.example;

public class Main {
    public static int najveciIkada(int[] arr, int n) {
        if (n == 1) return arr[0];

        int maxNMinus1 = najveciIkada(arr, n - 1);

        return Math.max(maxNMinus1, arr[n - 1]);
    }

    public static void main(String[] args) {
        int[] arr = {5, 33, 3, 22, 10};
        int n = arr.length;

        int max = najveciIkada(arr, n);
        System.out.println("Najveci broj je: " + max);
    }
}
