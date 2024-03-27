#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#define MAX_SONGS 100

struct Song {
    char title[100];
    char artist[100];
    int year;
};

int main() {
    int n;
    struct Song songs[MAX_SONGS];
    int count_2017 = 0;

    printf("Unesite broj pesama: ");
    scanf_s("%d", &n);
    getchar();

    printf("Unesite podatke o pesmama (naziv, izvodjac, godina izvodjenja):\n\n");
    for (int i = 0; i < n; i++) {
        printf("Pesma %d:\n", i + 1);

        printf("Naziv -> ");
        fgets(songs[i].title, sizeof(songs[i].title), stdin);
        songs[i].title[strcspn(songs[i].title, "\n")] = '\0';

        printf("Izvodjac -> ");
        fgets(songs[i].artist, sizeof(songs[i].artist), stdin);
        songs[i].artist[strcspn(songs[i].artist, "\n")] = '\0';

        char year_str[10];
        printf("Godina izvodjenja -> ");
        fgets(year_str, sizeof(year_str), stdin);
        year_str[strcspn(year_str, "\n")] = '\0';
        int j;
        for (j = 0; year_str[j] != '\0'; j++) {
            if (!isdigit(year_str[j])) {
                printf("Godina mora biti broj. Ponovite unos.\n");
                i--;
                break;
            }
        }
        if (year_str[j] != '\0')
            continue;

        songs[i].year = atoi(year_str);

        if (songs[i].year == 2017) {
            count_2017++;
        }

        printf("\n");
    }

    printf("Od %d pesama/a/e, %d je izdato/a/e u 2017. godini.\n", n, count_2017);

    return 0;
}
