#include "artist.h"
#include "utilities.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/*
typedef struct artist_tag {
    char name[STRING_MAX_LENGHT];
    bool group;
    int age;
    char genre[STRING_MAX_LENGHT];
} Artist;
*/



FILE *open_art_db(const char *filename, const char *mode)
{
    FILE *f;
    if ((f = fopen(filename, mode)) == NULL)
    {
        fprintf(stderr, "Non e' possibile usare il db\n");
        exit(EXIT_FAILURE);
    }
    return f;
}

FILE *open_df_art_db(const char *mode)
{
    return open_art_db(DEFAULT_ART_DB, mode);
}

void print_artist(Artist *art, FILE *f)
{
    fprintf(f, "%s %d %d %s\n", art->name, art->group, art->age, art->genre);
}

Artist read_artist(FILE *f)
{
    Artist art;
    fscanf(f, "%s%d%d%s", art.name, &art.group, &art.age, art.genre);
    return art;
}

Artist read_artist_prompt()
{
    Artist art;
    printf("Nome: ");
    scanf("%s", art.name);
    printf("Gruppo (yes:1 | no:0): ");
    scanf("%d", &art.group);
    printf("Inserisci l'eta' anagrafica o dalla fondazione del gruppo: ");
    scanf("%d", &art.age);
    printf("Inserisci il genere principale: ");
    scanf("%s", art.genre);
    return art;
}

Artist read_artist_prompt_forced(const char *forced_name) {
    Artist art;
    strncpy(art.name, forced_name, STRING_MAX_LENGHT);
    printf("Gruppo (yes:1 | no:0): ");
    scanf("%d", &art.group);
    printf("Inserisci l'eta' %s: ", art.group ? "dalla fondazione del gruppo" : "anagrafica");
    scanf("%d", &art.age);
    printf("Inserisci il genere principale: ");
    scanf("%s", art.genre);
    return art;
}

bool search_artist(const char *name)
{
    Artist i;
    int order;
    FILE *file = open_df_art_db("r");
    bool result = false;
    while (!feof(file))
    {
        i = read_artist(file);
        order = strncmp(i.name, name, STRING_MAX_LENGHT);
        if (order == 0)
        {
            result = true;
            print_artist(&i, stdout);
            break;
        }
        else if (order > 0)
        {
            break;
        }
    }
    fclose(file);

    if (!result)
        printf("Artista non trovato");
    return result;
}

bool insert_artist(Artist *art)
{
    Artist i;
    int order;
    bool stop_checks = false;
    FILE *f = open_df_art_db("r");
    FILE *tmp = open_art_db(TMP_ART_DB, "w");

    if (is_file_empty(f) == true)
    {
        print_artist(art, tmp);
    }

    while (!feof(f))
    {
        i = read_artist(f);
        order = strncmp(i.name, art->name, STRING_MAX_LENGHT);
        if (!stop_checks && order == 0)
        {
            printf("L'artista esiste gia'\n");
            stop_checks = true;
        }
        else if (!stop_checks && order > 0)
        {
            print_artist(art, tmp);
            fprintf(tmp, "\n");
            stop_checks = true;
        }
        print_artist(&i, tmp);
        fprintf(tmp, "\n");
    }

    fclose(f);
    fclose(tmp);
    rename(TMP_ART_DB, DEFAULT_ART_DB);
    return stop_checks;
}