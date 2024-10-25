﻿#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* switchVastEmptines(const char* og) {
    int len = strlen(og);
    char* nc = (char*)malloc((len + 1) * sizeof(char));

    if (nc == NULL) {
        printf("Nisam bio u mogucnosti da alociram memoriju, bacam gresku, izvinjavam se, bice bolje sledeceg puta (valjda)!\n");
        exit(EXIT_FAILURE);
    }

    int j = 0;
    int last_empty = 0;

    for (int i = 0; i < len; i++) {
        if (og[i] == ' ') {
            if (!last_empty) {
                nc[j++] = ' ';
                last_empty = 1;
            }
        }
        else {
            nc[j++] = og[i];
            last_empty = 0;
        }
    }
    nc[j] = '\0';

    return nc;
}

int main() {
    char original[100];
    printf("Unesite string: ");
    fgets(original, sizeof(original), stdin);
    original[strcspn(original, "\n")] = '\0';

    char* newString = switchVastEmptines(original);
    printf("Novi string: %s\n", newString);

    free(newString);

    return 0;
}
