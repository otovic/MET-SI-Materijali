#include <iostream>


//Napisati logičku funkciju koja određuje da li je zbir cifara nekog celog broja paran.Testirati funkciju u glavnom programu.
int main()
{
    int num = 0;
    char numS[10];
    int sum = 0;

    printf("Unesite broj: ");
    scanf_s("%d", &num);
    sprintf_s(numS, "%d", num);

    for (int i = 0; i < strlen(numS); i++) {
        sum = sum + (numS[i] - '0');
    }

    printf("\nSuma cifara je: %d", sum);
}
