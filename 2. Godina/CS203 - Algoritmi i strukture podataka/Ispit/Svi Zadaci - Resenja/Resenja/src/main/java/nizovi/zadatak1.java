package nizovi;
// Podela niza u dve grupe, tako da je razlika zbirova elemenata u grupama minimalna
public class zadatak1 {
    public static void main(String[] args) {

        int[] array1 = {2, 4, 2, 7};
        int[] array2 = {7, 9, 5, 10};
        int[] array3 = {6, 6, 6};

        System.out.println("Minimum difference of subarrays is: " + minDifferenceSubArray(array1)); // 1
        System.out.println("Minimum difference of subarrays is: " + minDiffSubArray(array2)); // 1
        System.out.println("Minimum difference of subarrays is: " + minDifferenceSubArray(array3)); // 6

    }

    private static int minDifferenceSubArray(int[] array) {
        int n = array.length;
        int[] prefixSum = new int[n];

        prefixSum[0] = array[0];

        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + array[i];
        }

        int[] suffixSum = new int[n];

        suffixSum[n - 1] = array[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + array[i];
        }

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < n - 1; i++) {
            int diff = Math.abs(prefixSum[i] - suffixSum[i + 1]);

            if (diff < minDiff) {
                minDiff = diff;
            }
        }

        return minDiff;
    }

    private static int minDiffSubArray(int[] array) {
        int n = array.length;
        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum += array[i];
        }

        int prefixSum = 0;

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < n - 1; i++) {
            prefixSum += array[i];

            int diff = Math.abs((totalSum - prefixSum) - prefixSum);

            if (diff < minDiff) {
                minDiff = diff;
            }
        }

        return minDiff;
    }
}
