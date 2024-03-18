import java.util.Arrays;

public class Pokemon {
    public static boolean nadjiPar(int[] arr, int s) {
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == s) return true;
            else if (currentSum < s) left++;
            else right--;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 7, 9, 2, 5, 3};
        int s = 10;
        if(nadjiPar(arr, s)) {
            System.out.println("Postoji par ciji je zbir " + s);
        } else {
            System.out.println("Ne postoji par ciji je zbir " + s);
        }
    }
}
