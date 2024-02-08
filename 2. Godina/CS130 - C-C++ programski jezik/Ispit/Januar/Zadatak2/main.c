/*
Korišćenjem programskog jezika C kreirati konzolnu aplikaciju koja će
formirati niz A[] od M slučajno odabranih celih brojeva  iz intervala [-200  200].

Napisati funkciju formiraj u kojoj se formira niz B[] od niza A tako što
svi elementi niza A deljivi sa K postaju elementi niza B.

Parametri K i M se učitavaju u glavnom programu. Memorija za niz B se alocira
u okviru funkcije formiraj. Pokazivač na dinamički alocirani niz B vratiti kao rezultat funkcije formiraj.

Kao argument funkcije formiraj vratiti korišćenjem pokazivača dimenziju novonastalog
niza B. Niz B zapisati u fajl pod nazivom “Zadatak2.txt” - svaki broj se zapisuje na 4 pozicije,
pri čemu se u jednoj liniji fajla zapisuje 10 brojeva.
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int *formiraj(int *A, int M, int K, int *dimenzija)
{
    int brojElemenata = 0;

    for (int i = 0; i < M; i++)
    {
        if (A[i] % K == 0)
        {
            brojElemenata++;
        }
    }

    *dimenzija = brojElemenata;

    int *B = (int *)malloc(brojElemenata * sizeof(int));
    if (B == NULL)
    {
        exit(1); // Greška pri alokaciji
    }

    int j = 0;
    for (int i = 0; i < M; i++)
    {
        if (A[i] % K == 0)
        {
            B[j++] = A[i];
        }
    }

    return B;
}

int main()
{
    srand(time(NULL));
    int M, K;

    printf("Unesite broj elemenata niza M: ");
    scanf("%d", &M);

    printf("Unesite broj K za proveru deljivosti: ");
    scanf("%d", &K);

    int A[M];
    for (int i = 0; i < M; i++)
    {
        A[i] = rand() % 401 - 200; // Slučajni brojevi iz intervala [-200, 200]
    }

    int dimenzijaB;
    int *B = formiraj(A, M, K, &dimenzijaB);

    FILE *f = fopen("Zadatak2.txt", "w");
    if (f == NULL)
    {
        printf("Greška pri kreiranju datoteke!\n");
        free(B);
        return 1;
    }

    for (int i = 0; i < dimenzijaB; i++)
    {
        fprintf(f, "%4d", B[i]);
        if ((i + 1) % 10 == 0)
        {
            fprintf(f, "\n");
        }
    }
    fprintf(f, "\n");

    fclose(f);
    free(B);

    return 0;
}
