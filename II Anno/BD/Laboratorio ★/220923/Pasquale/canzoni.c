#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define STRING_MAX_LENGHT 40
#define PATH_NAME "database.txt"

typedef struct song_tag {
    char title[STRING_MAX_LENGHT];
    char artist[STRING_MAX_LENGHT];
} song;

void print_song(song *s, FILE *f) {
    fprintf(f, "%s - %s", s->title, s->artist);
}

song read_song(FILE *f) {
    song canzone;
    fscanf(f, "%s - %s", canzone.title, canzone.artist);
    return canzone;
}

song read_song_prompt() {
    song canzone;
    printf("Inserisci il nome della canzone nel formato corretto\n");
    fscanf(stdin, "%s - %s", canzone.title, canzone.artist);
    return canzone;
}

void search_by_artist(FILE *f);
void insert_new_song(FILE *f);
void modify_artist(FILE **f);
void delete_artist(FILE **f);

void search_by_artist(FILE *f) {
    char new_artist[STRING_MAX_LENGHT];
    printf("Inserisci il nome dell'artista: ");
    scanf("%s", new_artist);

    while (!feof(f)) {
        song canzone = read_song(f);
        if (strncmp(new_artist, canzone.artist, STRING_MAX_LENGHT) == 0) {
            print_song(&canzone, stdout);
            printf("\n");
        }
    }
    rewind(f);
}

void insert_new_song(FILE *f) {
    fclose(f);
    song canzone = read_song_prompt();
    f = fopen(PATH_NAME, "a");
    fprintf(f, "\n");
    print_song(&canzone, f);
    fclose(f);
    f = fopen(PATH_NAME, "r");
}

void modify_artist(FILE **f) {
    char previous_name[STRING_MAX_LENGHT], new_name[STRING_MAX_LENGHT];
    printf("Inserisci il nome dell'artista da modificare: ");
    scanf("%s", previous_name);
    printf("Inserisci il nuovo nome per l'artista: ");
    scanf("%s", new_name);

    FILE *tmp = fopen("db_tmp.txt", "w");

    /*
    leggo dal file le canzoni, se trovo una
    canzone fatta dal autore col vecchio nome
    lo sovrascrivo con il nuovo.
    stampo la canzone
    */
    while (!feof(*f)) {
        song canzone = read_song(*f);
        if (strncmp(previous_name, canzone.artist, STRING_MAX_LENGHT) == 0) {
            strcpy(canzone.artist, new_name);
        }
        print_song(&canzone, tmp);
        if (!feof(*f)) fprintf(tmp, "\n");
    }

    fclose(*f);
    fclose(tmp);
    rename("db_tmp.txt", PATH_NAME);
    *f = fopen(PATH_NAME, "r");
}

void delete_artist(FILE **f) {
    char elim[STRING_MAX_LENGHT];
    printf("Inserisci il nome dell'artista da eliminare: ");
    scanf("%s", elim);

    int new_line_mark = 0;
    FILE *tmp = fopen("db_tmp.txt", "w");
    while (!feof(*f)) {
        song canzone = read_song(*f);
        if (strncmp(elim, canzone.artist, STRING_MAX_LENGHT) != 0) {
            if (new_line_mark) {
                fprintf(tmp, "\n");
            }
            print_song(&canzone, tmp);
            new_line_mark = 1;
        }
    }

    fclose(*f);
    fclose(tmp);
    rename("db_tmp.txt", PATH_NAME);
    *f = fopen(PATH_NAME, "r");
}


int main() {
    int scelta = 1;
    FILE *f_in;
    if ((f_in = fopen(PATH_NAME, "r")) == NULL) {
        fprintf(stderr, "Non e' stato trovato il db\n");
        return EXIT_FAILURE;
    }
    else {
        printf("db caricato\n");
    }

    while (scelta) {
        printf("Inserisci l'operazione da svolgere:\n");
        printf("1. cerca tutte le canzoni di un artista\n");
        printf("2. inserisci una nuova canzone\n");
        printf("3. modifica il nome di un artista\n");
        printf("4. cancella un artista e le sue canzoni\n");
        printf("altro per uscire\n> ");
        scanf("%d", &scelta);
        switch (scelta) {
            case 1: 
                search_by_artist(f_in);
                break;
            case 2:
                insert_new_song(f_in);
                break;
            case 3:
                modify_artist(&f_in);
                break;
            case 4:
                delete_artist(&f_in);
                break;
            default:
                scelta = 0;
                break;
        }

        printf("\n");
    }

    fclose(f_in);
    return 0;
}
