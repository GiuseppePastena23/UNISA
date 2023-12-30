#include "song.h"
#include "artist.h"
#include "utilities.h"
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

FILE *open_songs_db(const char *filename, const char *mode)
{
    FILE *f;
    if ((f = fopen(filename, mode)) == NULL)
    {
        fprintf(stderr, "Non e' possibile usare il db\n");
        exit(EXIT_FAILURE);
    }
    return f;
}

FILE *open_df_songs_db(const char *mode)
{
    return open_songs_db(DEFAULT_SONGS_DB, mode);
}

void print_song(Song *s, FILE *f)
{
    fprintf(f, "%s %s\n", s->title, s->artist);
}

Song read_song(FILE *f)
{
    Song canzone;
    fscanf(f, "%s%s", canzone.title, canzone.artist);
    return canzone;
}

Song read_song_prompt()
{
    printf("Inserisci il nome della canzone, nel formato corretto (Es: titolo_canzone autore_canzone)\n");
    return read_song(stdin);
}

int search_songs_by_artist(const char *name_art)
{
    Song canzone;
    int s_trovate = 0;
    int order;

    FILE *file = open_df_songs_db("r");
    while (!feof(file))
    {
        canzone = read_song(file);
        order = strncmp(canzone.artist, name_art, STRING_MAX_LENGHT);
        if (order == 0)
        {
            if (s_trovate == 0)
                printf("Sono state trovate le seguenti canzoni:\n");
            s_trovate++;
            print_song(&canzone, stdout);
            printf("\n");
        }
        else if (order > 0)
            break;
    }
    if (s_trovate == 0)
        printf("Non sono state trovate canzoni dell'artista\n");

    fclose(file);
    return s_trovate;
}

bool insert_song(Song *s)
{
    Song i;
    int order_art, order_song;
    FILE *f = open_df_songs_db("r");
    FILE *tmp = open_songs_db(TMP_SONG_DB, "w");

    if (is_file_empty(f) == true)
    {
        print_song(s, tmp);
        printf("E' necessario inserire le informazioni del nuovo artista\n");
        Artist art = read_artist_prompt_forced(s->artist);
        insert_artist(&art);
    }

    else
    {
        while (!feof(f))
        {
            i = read_song(f);
            order_art = strncmp(i.artist, s->artist, STRING_MAX_LENGHT);
            order_song = strncmp(i.title, s->title, STRING_MAX_LENGHT);

            if (order_art == 0)
            {
                if (order_song == 0)
                {
                    printf("La canzone esiste gia'\n");
                }
                else if (order_song > 0)
                {
                    print_song(s, tmp);
                }
            }
            else if (order_art > 0)
            {
                print_song(s, tmp);
                printf("E' necessario inserire le informazioni del nuovo artista\n");
                Artist art = read_artist_prompt_forced(s->artist);
                insert_artist(&art);
            }
            print_song(&i, tmp);
        }
    }

    fclose(f);
    fclose(tmp);
    rename(TMP_SONG_DB, DEFAULT_SONGS_DB);
    return true;
}
