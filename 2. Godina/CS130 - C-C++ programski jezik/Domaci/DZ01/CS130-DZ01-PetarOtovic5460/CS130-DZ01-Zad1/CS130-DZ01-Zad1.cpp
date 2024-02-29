#include <iostream>

int main()
{
    float stranica, povrsina, obim;

    printf("Unesite stranicu kvadrata: ");
    scanf_s("%f", &stranica);

    povrsina = stranica * stranica;
    obim = 4 * stranica;

    printf("Povrsina duplo veceg kvadrata je: %.2f\n", povrsina * 4);
    printf("Obim duplo veceg kvadrata je: %.2f", obim * 2);

    return 0;
}