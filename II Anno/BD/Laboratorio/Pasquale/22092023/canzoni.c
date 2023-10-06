#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define STRING_MAX_LENGHT 40
#define PATH_NAME "database.txt"

// Formato delle canzoni
// nome_canzone - nome_artista
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
    printf("Inserisci il nome della canzone nel formato corretto\n");
    return read_song(stdin);
}

/////////////////////////////////

// stampa in stdout tutte le occorrenze delle canzoni di un artista specificato
void search_by_artist(FILE *f);

// appende una nuova canzone in fondo al file
void insert_new_song(FILE *f);

// modifica il nome di un artista in tutte le canzoni che ha composto e restituisce il puntatore al file modificato
FILE *modify_artist(FILE *f);

// cancella tutte le canzoni di un artista nel file e restituisce il puntatore al file modificato
FILE *delete_artist(FILE *f);

/////////////////////////////////

int main() {
    int scelta = 1;
    FILE *f_in;
    if ((f_in = fopen(PATH_NAME, "r")) == NULL) {
        fprintf(stderr, "Non e' stato trovato il db\n");
        return EXIT_FAILURE;
    }
    printf("db caricato\n");

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
                f_in = modify_artist(f_in);
                break;
            case 4:
                f_in = delete_artist(f_in);
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

void search_by_artist(FILE *f) {
    char new_artist[STRING_MAX_LENGHT];
    printf("Inserisci il nome dell'artista: ");
    scanf("%s", new_artist);

    /*
    finché non finisce il file 
    se trovo l'artista corripondente stampo la canzone
    */
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
    if ((f = fopen(PATH_NAME, "a")) == NULL ) exit(EXIT_FAILURE); // apro il file in modalità append
    fprintf(f, "\n");
    print_song(&canzone, f); // aggiungo la canzone al file
    fclose(f);
    if ((f = fopen(PATH_NAME, "r")) == NULL ) exit(EXIT_FAILURE); // riapro il file in lettura
}

FILE *modify_artist(FILE *f) {
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
    while (!feof(f)) {
        song canzone = read_song(f);
        if (strncmp(previous_name, canzone.artist, STRING_MAX_LENGHT) == 0) {
            strcpy(canzone.artist, new_name);
        }
        print_song(&canzone, tmp);
        if (!feof(f)) fprintf(tmp, "\n");
    }

    /*
    chiudo tutti i file
    sovrascrivo il db con quello temporaneo rinominandolo
    apro il nuovo db in lettura, ritorno il puntatore al nuovo file
    */
    fclose(f);
    fclose(tmp);
    if (rename("db_tmp.txt", PATH_NAME) != 0) exit(EXIT_FAILURE);
    if ((f = fopen(PATH_NAME, "r")) == NULL) exit(EXIT_FAILURE);
    return f;
}

FILE *delete_artist(FILE *f) {
    char elim[STRING_MAX_LENGHT];
    printf("Inserisci il nome dell'artista da eliminare: ");
    scanf("%s", elim);

    /*
    se trovo una canzone con autore diverso da quello definito lo stampo
    */
    int new_line_mark = 0;
    FILE *tmp = fopen("db_tmp.txt", "w");
    while (!feof(f)) {
        song canzone = read_song(f);
        if (strncmp(elim, canzone.artist, STRING_MAX_LENGHT) != 0) {
            if (new_line_mark) {
                fprintf(tmp, "\n");
            }
            print_song(&canzone, tmp);
            new_line_mark = 1;
        }
    }

    /*
    chiudo tutti i file
    sovrascrivo il db con quello temporaneo rinominandolo
    apro il nuovo db in lettura, ritorno il puntatore al nuovo file
    */
    fclose(f);
    fclose(tmp);
    if (rename("db_tmp.txt", PATH_NAME) != 0) exit(EXIT_FAILURE);
    if ((f = fopen(PATH_NAME, "r")) == NULL) exit(EXIT_FAILURE);
    return f;
}
