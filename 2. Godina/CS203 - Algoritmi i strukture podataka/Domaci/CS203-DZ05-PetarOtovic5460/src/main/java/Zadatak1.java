//Kako spojiti 4 niza duzine n?
//Moze se iskoristiti dole napravljena funkcija za spajanje 2 niza,
// pa se onda koristi ta funkcija za spajanje 2 niza,
// pa rezultat te funkcije sa trecim nizom,
// pa rezultat te funkcije sa cetvrtim nizom.
//I tako bi se spojila 4 niza.

//Kako spojiti k nizova duzine n?
//Moze se iskoristiti dole napravljena funkcija za spajanje 2 niza,
// islo bi se iterativno dok se ne spoje svi nizovi.
//Nizovi koji treba da se spoje bi se cuvali u dvodimenzionalnom nizu.
//Pa bi se iteriralo kroz taj dvodimenzionalni niz i svaki put spajali 2 niza.

public class Zadatak1 {
    public static int[] mrdz(int[] A, int[] B) {
        int[] merged = new int[A.length + B.length];
        int i = 0, j = 0, k = 0;

        while (i < A.length && j < B.length) {
            if (A[i] < B[j]) merged[k++] = A[i++];
            else merged[k++] = B[j++];
        }

        while (i < A.length) merged[k++] = A[i++];
        while (j < B.length) merged[k++] = B[j++];

        return merged;
    }

    public static void stampajZni(int[] A){
        for (int num : A) {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 5, 7, 9};
        int[] B = {2, 4, 6, 8, 10};

        System.out.println("Niz 1:");
        stampajZni(A);
        System.out.println("\n");
        System.out.println("Niz 2:");
        stampajZni(B);
        System.out.println("\n");

        int[] merged = mrdz(A, B);

        System.out.println("Spojeni niz:");
        stampajZni(merged);
    }
}
