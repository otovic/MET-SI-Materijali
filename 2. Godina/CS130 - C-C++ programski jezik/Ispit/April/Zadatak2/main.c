/*
Korišćenjem programskog jezika C kreirati konzolnu aplikaciju i formirati dva
niza A[] i B[] od M i N slučajno odabranih celih brojeva  iz intervala 0 - 500.

Napisati funkciju formiraj u kojoj se formira niz C[] od dva uneta niza tako što
svi elementi nizova A i B čiji je koren ceo broj postaju elementi trećeg niza C.

Memorija za niz C se alocira u okviru funkcije formiraj. Pokazivač na dinamički
alocirani niz vratiti kao rezultat funkcije formiraj. Kao argument funkcije formiraj vratiti korišćenjem pokazivača dimenziju novonastalog niza.

Odštampati na ekran brojeve iz niza C, ali tako da se formira matricu sa n kolona.
Poslednju vrstu dopuniti nulama, ukoliko je to neophodno.
*/
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

void formiraj(int A[], int M, int B[], int N, int **C, int *dimC)
{
    *dimC = 0;
    for (int i = 0; i < M; i++)
    {
        if (floor(sqrt(A[i])) == sqrt(A[i]))
        {
            (*dimC)++;
        }
    }
    for (int i = 0; i < N; i++)
    {
        if (floor(sqrt(B[i])) == sqrt(B[i]))
        {
            (*dimC)++;
        }
    }
    *C = (int *)malloc(*dimC * sizeof(int));
    int index = 0;
    for (int i = 0; i < M; i++)
    {
        if (floor(sqrt(A[i])) == sqrt(A[i]))
        {
            (*C)[index++] = A[i];
        }
    }
    for (int i = 0; i < N; i++)
    {
        if (floor(sqrt(B[i])) == sqrt(B[i]))
        {
            (*C)[index++] = B[i];
        }
    }
}

int main()
{
    int M, N, n;
    printf("Unesite broj elemenata za niz A (M): ");
    scanf("%d", &M);
    printf("Unesite broj elemenata za niz B (N): ");
    scanf("%d", &N);
    printf("Unesite broj kolona za matricu (n): ");
    scanf("%d", &n);

    int A[M], B[N];
    for (int i = 0; i < M; i++)
    {
        A[i] = rand() % 501;
    }
    for (int i = 0; i < N; i++)
    {
        B[i] = rand() % 501;
    }
    // Ispisivanje nizova A i B
    printf("\nNiz A: ");
    for (int i = 0; i < M; i++)
    {
        printf("%d ", A[i]);
    }
    printf("\nNiz B: ");
    for (int i = 0; i < N; i++)
    {
        printf("%d ", B[i]);
    }

    int *C;
    int dimC;
    formiraj(A, M, B, N, &C, &dimC);

    // Ispisivanje rezultujućeg niza C
    printf("\nNiz C: ");
    for (int i = 0; i < dimC; i++)
    {
        printf("%d ", C[i]);
    }

    printf("\nMatrica:\n");
    for (int i = 0; i < dimC; i++)
    {
        printf("%d ", C[i]);
        if ((i + 1) % n == 0)
        {
            printf("\n");
        }
    }
    if (dimC % n != 0)
    {
        for (int i = 0; i < n - dimC % n; i++)
        {
            printf("0 ");
        }
        printf("\n");
    }

    free(C);
    return 0;
}
