/*Scrivere una funzione			Libro * libri_nuovi(Libro a[], int n, int anno0, int * nnuovi)
che riceve come parametri un array a[] di n oggetti di tipo Libro e restituisce un nuovo array, 
contenente copie di tutti i libri in a[] pubblicati nell’anno anno0 o successivamente. 
L’array restituito va allocato dinamicamente sulla base della dimensione strettamente necessaria.
La funzione libri_nuovi() comunica al chiamante la dimensione dell’array restituito usando il parametro di output nnuovi.
Se nessun libro è abbastanza recente, libri_nuovi() restituisce NULL*/
/*Scrivere una funzione			int copia_nuovi(FILE *fin, int nlibri, FILE *fout, int anno0)
che lavora su due file binari già aperti rispettivamente in lettura e scrittura, con descrittori fin e fout.
Il file input fin contiene una serie di nlibri oggetti di tipo Libro. La funzione copia
nel file output fout tutti i libri pubblicati nell’anno anno0 o successivamente, e restituisce
il numero di libri copiati, senza lasciare file aperti all’uscita o memoria allocata inaccessibile.*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "xmalloc.h"

typedef struct {
char autore[50];
char titolo[100];
int anno;
} Libro;

Libro * libri_nuovi(Libro a[], int n, int anno0, int * nnuovi);
void copia_Libro(Libro *dest, Libro *src);
int copia_nuovi(FILE *fin, int nlibri, FILE *fout, int anno0);

Libro * libri_nuovi(Libro a[], int n, int anno0, int * nnuovi)
{
	*nnuovi = 0;
	for(int i=0; i<n; i++)
	{
		if(a[i].anno >= anno0)
		{
			(*nnuovi)++;
		}
	}
	if((*nnuovi) == 0)
	{
		printf("Non ci sono libri così recenti\n");
		return NULL;
	}
	Libro *array = xmalloc((*nnuovi) * sizeof(Libro));
	for(int i=0, j=0; i<n; i++)
	{
		if(a[i].anno >= anno0)
		{
			copia_Libro(&array[j], &a[i]);
			j++;
		}
	}
	return array;
}

void copia_Libro(Libro *dest, Libro *src)
{
	strcpy(dest->autore, src->autore);
	strcpy(dest->titolo, src->titolo);
	dest->anno = src->anno;
}

int copia_nuovi(FILE *fin, int nlibri, FILE *fout, int anno0)
{
	Libro *tutti, *recenti;
	int nuova_taglia;
	tutti = xmalloc(nlibri * sizeof(Libro));
	int num = fread(tutti, sizeof(Libro), nlibri, fin);
	if(num != nlibri)
	{
		printf("Errore durante la lettura del file\n");
		fclose(fin);
		fclose(fout);
		free(tutti);
		exit(-4);
	}
	recenti = libri_nuovi(tutti, num, anno0, &nuova_taglia);
	int ncopiati = fwrite(recenti, sizeof(Libro), num, fout);
	if(ncopiati != nuova_taglia)
	{
		printf("Errore durante la scrittura del file\n");
		fclose(fin);
		fclose(fout);
		free(tutti);
		free(recenti);
		exit(-4);
	}
	fclose(fin);
	fclose(fout);
	free(tutti);
	free(recenti);
	return nuova_taglia;
}