/*La funzione restituisce un array allocato dinamicamente contenente tutte le coppie cognome - nome
presenti nel file elenco.txt in cui il cognome inizia con la lettera cercata. Il p. di output restituisce la taglia*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "xmalloc.h"
#define TAGMAX 20		//ricorda di inserire lo spazio per il tappo

typedef struct{
	char cognome[TAGMAX+1];	
	char nome[TAGMAX+1];
} Persona

Persona * sottoElenco (char iniz_c, int *dim);

Persona * sottoElenco (char iniz_c, int *dim)
{
	FILE *fin;
	char *cognome;
	char *nome;
	int n=0;
	fin = fopen("elenco.txt", "r");
	if(fin == NULL)
	{
		printf("Errore in apertura del file\n");
		*dim = 0;
		return NULL;
	}
	
	while(!feof(fin))
	{
		fscanf(fin, "%s\n%s", cognome, nome);
		n++;
	}
	Persona *elenco = calloc(n, sizeof(Persona));
	
}