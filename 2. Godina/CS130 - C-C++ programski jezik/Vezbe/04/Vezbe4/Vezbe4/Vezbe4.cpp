#include <stdio.h>

void zad1(int* br) {
    *br = *br * 2;
}

void zad2(int* br) {

}

int main()
{
    int a = 10;
    zad1(&a);
    printf("%d", a);

    int b = 4;
    zad2(b);
    printf("%d", b);
}
