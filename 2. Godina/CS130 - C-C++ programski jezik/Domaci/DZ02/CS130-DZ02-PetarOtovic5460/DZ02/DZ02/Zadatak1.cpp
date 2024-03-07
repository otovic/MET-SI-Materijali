#include <iostream>
#include <stdlib.h>


//1.	a) Napisati program koji formira 300 slučajno izabranih celih brojeva iz 
// intervala od 0 - 9, prikazuje ih po 20 u jednom redu ekrana.Koristiti funkciju
//rand() iz biblioteke stdlib.h
void zad1a() {
    srand(time(NULL));

    int count = 0;

    for (int i = 0; i < 300; i++) {
        int num = rand() % (10);

        if (count == 19) {
            printf("%d ", num);
            printf("\n");
            count = 0;
        }
        else {
            printf("%d ", num);
            count++;
        }
    }
}

//b) Isto kao pod a) samo se vrši izračunavanje sume svakog prvog broja u redu.
void zad1b() {
    srand(time(NULL));

    int count = 0;
    int sum = 0;

    for (int i = 0; i < 300; i++) {
        int num = rand() % (10);

        if (count == 0) {
            sum = sum + num;
            printf("%d ", num);
            count++;
        }
        else if (count == 19) {
            printf("%d ", num);
            printf("\n");
            count = 0;
        }
        else {
            printf("%d ", num);
            count++;
        }
    }

    printf("\nsuma je %d: ", sum);
}

int main()
{
    zad1b();
}