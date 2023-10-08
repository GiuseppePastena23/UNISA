#ifndef SONG_H
#define SONG_H

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#ifndef STRING_MAX_LENGHT
#define STRING_MAX_LENGHT 40
#endif

#ifndef DEFAULT_SONGS_DB
#define DEFAULT_SONGS_DB "songs_db.txt"
#endif

#ifndef TMP_SONG_DB
#define TMP_SONG_DB "songs_db.tmp"
#endif

typedef struct song_tag {
    char title[STRING_MAX_LENGHT];
    char artist[STRING_MAX_LENGHT];
} Song;

void print_song(Song *s, FILE *f);
Song read_song(FILE *f);
Song read_song_prompt();

/*
apre nella modalità specificata il file DEFAULT_SONG_DB
*/
FILE *open_df_songs_db(const char *mode);
/*
apre nella modalità specificata il filename passato
*/
FILE *open_songs_db(const char *filename, const char *mode);

/*
stampa in stdout tutte le occorrenze delle canzoni di un artista specificato
restituisce il numero delle canzoni trovate
*/
int search_songs_by_artist();


bool insert_song(Song *s);



#endif
