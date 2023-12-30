#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include "song.h"
#include "artist.h"


// FUNZIONI SOLO MAIN

/*
chiede il nome dell'artista all'utente
e ritorna il numero delle canzoni che ha composto
*/
int search_songs() {
    char art[STRING_MAX_LENGHT];
    printf("Inserisci il nome dell'artista: ");
    scanf("%s", art);
    return search_songs_by_artist(art);
}

bool info_artist() {
    char art[STRING_MAX_LENGHT];
    printf("Inserisci il nome dell'artista: ");
    scanf("%s", art);
    return search_artist(art);
}

bool insert() {
    Song s = read_song_prompt();
    insert_song(&s);
    printf("\n");
}







// modifica il nome di un artista in tutte le canzoni che ha composto e restituisce il puntatore al file modificato
FILE *modify_artist();

// cancella tutte le canzoni di un artista nel file e restituisce il puntatore al file modificato
FILE *delete_artist();

/////////////////////////////////

int main() {
    while (1) insert();
    return 0;
}

int asdf() {
    int scelta = 1;

    while (scelta) {
        printf("Inserisci l'operazione da svolgere:\n");
        printf("1. cerca tutte le canzoni di un artista\n");
        printf("2. informazioni artista\n");
        printf("3. inserisci una nuova canzone\n");
        printf("4. modifica il nome di un artista\n");
        printf("5. cancella un artista e le sue canzoni\n");
        printf("altro per uscire\n> ");
        scanf("%d", &scelta);
        switch (scelta) {
            case 1:
                search_songs();
                break;
            case 2:
                info_artist();
            case 3:
                // insert_new_song();
                break;
            case 4:
                // f_in = modify_artist();
                break;
            case 5:
                // f_in = delete_artist();
                break;
            default:
                scelta = 0;
                break;
        }
        printf("\n");
    }

    return 0;
}





// void insert_new_song(FILE *f) {
//     fclose(f);
//     song canzone = read_song_prompt();
//     if ((f = fopen(DB_PATH, "a")) == NULL ) exit(EXIT_FAILURE); // apro il file in modalità append
//     fprintf(f, "\n");
//     print_song(&canzone, f); // aggiungo la canzone al file
//     fclose(f);
//     if ((f = fopen(DB_PATH, "r")) == NULL ) exit(EXIT_FAILURE); // riapro il file in lettura
// }

// FILE *modify_artist(FILE *f) {
//     char previous_name[STRING_MAX_LENGHT], new_name[STRING_MAX_LENGHT];
//     printf("Inserisci il nome dell'artista da modificare: ");
//     scanf("%s", previous_name);
//     printf("Inserisci il nuovo nome per l'artista: ");
//     scanf("%s", new_name);

//     FILE *tmp = fopen("db_tmp.txt", "w");

//     /*
//     leggo dal file le canzoni, se trovo una
//     canzone fatta dal autore col vecchio nome
//     lo sovrascrivo con il nuovo.
//     stampo la canzone
//     */
//     while (!feof(f)) {
//         song canzone = read_song(f);
//         if (strncmp(previous_name, canzone.artist, STRING_MAX_LENGHT) == 0) {
//             strcpy(canzone.artist, new_name);
//         }
//         print_song(&canzone, tmp);
//         if (!feof(f)) fprintf(tmp, "\n");
//     }

//     /*
//     chiudo tutti i file
//     sovrascrivo il db con quello temporaneo rinominandolo
//     apro il nuovo db in lettura, ritorno il puntatore al nuovo file
//     */
//     fclose(f);
//     fclose(tmp);
//     if (rename("db_tmp.txt", DB_PATH) != 0) exit(EXIT_FAILURE);
//     if ((f = fopen(DB_PATH, "r")) == NULL) exit(EXIT_FAILURE);
//     return f;
// }

// FILE *delete_artist(FILE *f) {
//     char elim[STRING_MAX_LENGHT];
//     printf("Inserisci il nome dell'artista da eliminare: ");
//     scanf("%s", elim);

//     /*
//     se trovo una canzone con autore diverso da quello definito lo stampo
//     */
//     int new_line_mark = 0;
//     FILE *tmp = fopen("db_tmp.txt", "w");
//     while (!feof(f)) {
//         song canzone = read_song(f);
//         if (strncmp(elim, canzone.artist, STRING_MAX_LENGHT) != 0) {
//             if (new_line_mark) {
//                 fprintf(tmp, "\n");
//             }
//             print_song(&canzone, tmp);
//             new_line_mark = 1;
//         }
//     }

//     /*
//     chiudo tutti i file
//     sovrascrivo il db con quello temporaneo rinominandolo
//     apro il nuovo db in lettura, ritorno il puntatore al nuovo file
//     */
//     fclose(f);
//     fclose(tmp);
//     if (rename("db_tmp.txt", DB_PATH) != 0) exit(EXIT_FAILURE);
//     if ((f = fopen(DB_PATH, "r")) == NULL) exit(EXIT_FAILURE);
//     return f;
// }
