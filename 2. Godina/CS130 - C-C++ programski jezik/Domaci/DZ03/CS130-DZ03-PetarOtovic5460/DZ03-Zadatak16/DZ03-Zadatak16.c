#include <stdio.h>
#include <string.h>

void countNonSpace() {
    char line[21];

    printf("Unesite tekst (max 20 karaktera):\n");

    while (fgets(line, sizeof(line), stdin) != NULL) {
        int count = 0;

        for (int i = 0; i < strlen(line); i++) {
            if (line[i] != ' ' && line[i] != '\n' && line[i] != '\0') {
                count++;
            }
        }

        printf("Broj znakova koji su razliciti od praznine: %d\n", count);
        printf("Unesite sledecu liniju teksta (max 20 karaktera):\n");
    }
}

int main() {
    countNonSpace();
    return 0;
}