#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_STRING_LENGTH 100
#define MAX_ARRANGEMENTS 100

struct Arrangement {
    int id;
    char agency[MAX_STRING_LENGTH];
    char hotel[MAX_STRING_LENGTH];
    char location[MAX_STRING_LENGTH];
    int nights;
    float price;
};

int main() {
    FILE* file = NULL;

    if (fopen_s(&file, "aranzmani.txt", "r") != 0 || file == NULL) {
        printf("Unable to open file\n");
        return 1;
    }

    struct Arrangement arrangements[MAX_ARRANGEMENTS];
    int num_found = 0;

    while (num_found < MAX_ARRANGEMENTS &&
        fscanf(file, "%d %s %s %s %d %f", &arrangements[num_found].id, arrangements[num_found].agency, arrangements[num_found].hotel,
            arrangements[num_found].location, &arrangements[num_found].nights, &arrangements[num_found].price) == 6) {
        if (strcmp(arrangements[num_found].location, "Lefkada") == 0) {
            printf("ID: %d, Agency: %s, Hotel: %s, Location: %s, Nights: %d, Price: %.2f\n", arrangements[num_found].id,
                arrangements[num_found].agency, arrangements[num_found].hotel, arrangements[num_found].location,
                arrangements[num_found].nights, arrangements[num_found].price);
            num_found++;
        }
    }

    if (num_found == 0) {
        printf("No arrangements found with location 'Lefkada'\n");
    }

    fclose(file);

    return 0;
}
