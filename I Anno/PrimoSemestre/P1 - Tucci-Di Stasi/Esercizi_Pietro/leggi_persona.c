#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "xmalloc.h"

typedef struct persona {
	char nome[21];
	char cognome[21];
}Persona;

Persona *leggi_persone_da_file(FILE *nomi_cognomi, int *numero_nomi_cognomi);
Persona *leggi_persona_lunghezza_minore(Persona *Persone, int *numero_nomi_cognomi, int tagmax);
Persona *leggi_Persona(Persona *dest, Persona *src);


Persona *leggi_persone_da_file(FILE *nomi_cognomi, int *numero_nomi_cognomi)
{	
	Persona *Persone;
	fscanf(nomi_cognomi, "%d", numero_nomi_cognomi);
	if(*numero_nomi_cognomi <= 0)
	{
		return NULL;
	}
	Persone = calloc(*numero_nomi_cognomi, sizeof(Persona));
	if(Persone == NULL)
	{
		printf("Errore durante l'allocazione\n");
		*numero_nomi_cognomi = 0;
		return NULL;
	}
	for(int i = 0; i< *numero_nomi_cognomi; i++)
	{
		fscanf(nomi_cognomi, "%s", Persone[i].nome);
		fscanf(nomi_cognomi, "%s", Persone[i].cognome);
		(*numero_nomi_cognomi)++;
	}
	fclose(nomi_cognomi);
	return Persone;
}

Persona *leggi_persona_lunghezza_minore(Persona *Persone, int *numero_nomi_cognomi, int tagmax)
{	
	int newsize= 0;
	Persona *Persone_minore = calloc(*numero_nomi_cognomi, sizeof(Persona));
	if(Persone_minore == NULL)
	{
		printf("Errore durante l'allocazione\n");
		return NULL;
	}
	for (int i = 0; i < *numero_nomi_cognomi; i++)
	{
		if (strlen(Persone[i].cognome) < tagmax)
		{
			leggi_Persona(&Persone_minore[newsize], &Persone[i]);
			newsize++;
		}
	}
	if (newsize == 0)
	{
		return NULL;
	}
	Persone_minore = realloc(Persone_minore, newsize*sizeof(Persone));
	free(Persone);
	*numero_nomi_cognomi = newsize;
	return Persone_minore;
}

Persona *leggi_Persona(Persona *dest, Persona *src)
{
	strcpy(dest->nome, src->nome);
	strcpy(dest->cognome, src->cognome);
	return dest;
}