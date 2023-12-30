#ifndef ARTIST_H
#define ARTIST_H

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#ifndef STRING_MAX_LENGHT
#define STRING_MAX_LENGHT 40
#endif

#ifndef DEFAULT_ART_DB
#define DEFAULT_ART_DB "artist_db.txt"
#endif

#ifndef TMP_ART_DB
#define TMP_ART_DB "artist_db.tmp"
#endif

typedef struct artist_tag {
    char name[STRING_MAX_LENGHT];
    bool group;
    int age;
    char genre[STRING_MAX_LENGHT];
} Artist;

void print_artist(Artist *a, FILE *f);
Artist read_artist(FILE *f);
Artist read_artist_prompt();

// forced to have arg name
Artist read_artist_prompt_forced(const char *forced_name);

/*
apre nella modalità specificata il file DEFAULT_ART_DB
*/
FILE *open_df_art_db(const char *mode);
/*
apre nella modalità specificata il filename passato
*/
FILE *open_art_db(const char *filename, const char *mode);


// ritorna vero se l'autore esiste
bool search_artist(const char *name);

bool insert_artist(Artist *art);

#endif
