/*La funzione legge un file binario 
prima fread per leggere quanti numeri sono, poi allochiamo l'array di double, poi leggiamo uno per uno i double
il parametro di output scrive quanti sono i numeri letti
in caso di problema la funzione restituisce NULL e stampa un appropriato messaggio*/
	//6, 8.8,6.1,4.12,2.1,-0.5,-2.1
	//alloca con calloc
	//funzione da usare per gli errori
#include <stdio.h>
#include <stdlib.h>
#include "xmalloc.h"
#define NOME "lista_float"

double * load_doubles(FILE *fp, int *n);
double media_neg(FILE *fin);

double * load_doubles(FILE *fp, int *n)
{
	fp = fopen(NOME, "rb");
	if(fp == NULL)
	{
		printf("Errore in apertura del file\n");
		*n = 0;
		return NULL;
	}
	if (fread(n, sizeof(int), 1, fp) != 1)
	{
		printf("Errore nel formato del file\n");
		*n = 0;
		return NULL;
	}
	double *doubles = calloc(*n, sizeof(double));
	if(doubles == NULL)
	{
		printf("Errore durante l'allocazione\n");
		*n = 0;
		return NULL;
	}
	if(feof(fp)) //controlla che EOF sia vero (restituisce un valore diverso da 0 se la lettura tenta di leggere oltre la fine del file
	{
		printf("Errore dovuto ad un diverso numero di elementi presenti\n");
		*n = 0;
		free(doubles);
		return NULL;
	}
	if(fread(doubles, sizeof(double), *n, fp) != *n)
	{
		printf("Errore in lettura del file\n");
		*n = 0;
		free(doubles);
		return NULL;
	}
	return doubles;
}

double media_neg(FILE *fin)
{
	int size, num;
	double somma, media;
	double *doubles = load_doubles(fin, &size);
	for(int i=0; i<size; i++)
	{
		if(doubles[i] < 0)
		{
			num++;
			somma = somma + doubles[i];
		}
	}
	free(doubles);
	if(num == 0)
	{
		printf("Non ci sono numeri negativi\n");
		return 0;
	}
	media = somma / num; 
	return media;
}