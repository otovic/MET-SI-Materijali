#include <stdio.h>

void modifyArray(int array[], int length) {
    for (int i = 0; i < length; i++) {
        if ((i + 1) % 3 == 0) {
            array[i] *= 2;
        }
        else if ((i + 1) % 5 == 0) {
            array[i] /= 2;
        }
    }
}

int main() {
    int array[10] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    int length = sizeof(array) / sizeof(array[0]);

    printf("Pocetni niz:\n");

    for (int i = 0; i < length; i++) {
        printf("%d ", array[i]);
    }

    printf("\n");

    modifyArray(array, length);

    printf("Modifikovani niz:\n");

    for (int i = 0; i < length; i++) {
        printf("%d ", array[i]);
    }

    printf("\n");

    return 0;
}