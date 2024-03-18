#include <stdio.h>
#include <string.h>
#include <ctype.h>

int jePalindrom(const char* str) {
    const char* p = str;
    const char* q = str + strlen(str) - 1;

    while (p < q) {
        if (*p != *q) return 0;
        p++;
        q--;
    }
    return 1;
}

int main() {
    char str[100];

    printf("Unesite string: ");
    fgets(str, sizeof(str), stdin);
    str[strcspn(str, "\n")] = '\0';

    if (jePalindrom(str)) printf("\"%s\" jeste palindrom.\n", str);
    else printf("\"%s\" nije palindrom.\n", str);

    return 0;
}
