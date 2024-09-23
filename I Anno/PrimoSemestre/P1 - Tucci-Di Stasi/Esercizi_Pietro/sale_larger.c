/*Scrivere una funzione C				int sale_cmp(Sale *s1, Sale *s2)
che riceve come parametri gli indirizzi di due vendite e segnala quale delle due corrisponde
all’importo totale più grande, restituendo: −1 se è la prima che ha il totale più grande;
1 se invece è la seconda; 0 se i due importi sono equivalenti.
Scrivere una funzione C				Sale * sale_larger(Sale *A, int n, Sale *small, int *newsize)
che riceve come parametri un array A[] di n vendite e un puntatore small a una vendita. 
La funzione restituisce un array allocato dinamicamente contenente copie di tutte le vendite in A[]
che hanno un importo totale maggiore rispetto alla vendita puntata da small. Il parametro output
newsize sarà impostato alla dimensione dell’array risultante. Nel caso nessuna vendita in A[]
soddisfi la condizione, sale_larger() restituirà NULL e imposterà newsize a zero.
Scrivere una funzione C					int sale_save_larger(FILE *savefile, Sale *A, int n, Sale *small)
che riceve come parametri un file di testo già aperto, un array di vendite A[] con la sua
dimensione n, e un puntatore a vendita small. La funzione scrive nel file una riga per ogni
vendita in A[] che abbia un importo totale maggiore di quello di small. La riga relativa a
una vendita contiene la sua descrizione, la quantità, il prezzo unitario e l’importo totale. I
dati sono separati da una virgola e uno spazio. Ecco un possibile esempio di output:
Matite da disegno, 0.5, 10, 5.0
Peperoni, 1.3, 6.5, 8.45
La funzione restituisce il numero di righe scritte nel file.*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "xmalloc.h"

typedef struct {
	char description[50]; 		// what's being sold?
	double price1; 				// unit price (for 1 unit)
	double quantity;
} Sale;

int sale_cmp(Sale *s1, Sale *s2);
double total_import(Sale *s);
Sale * sale_larger(Sale *A, int n, Sale *small, int *newsize);
void copy_sale(Sale *dest, Sale *src);
int sale_save_larger(FILE *savefile, Sale *A, int n, Sale *small);

int sale_cmp(Sale *s1, Sale *s2)
{
	double import1 = total_import(s1);
	double import2 = total_import(s2);
	if(import1 < import2)
	{
		return 1;
	}
	else if(import1 > import2)
	{
		return -1;
	}
	else
	{
		return 0;
	}
}

double total_import(Sale *s)
{
	return s->price1 * s->quantity;
}

Sale * sale_larger(Sale *A, int n, Sale *small, int *newsize)
{
	*newsize = 0;
	for(int i=0; i<n; i++)
	{
		if(sale_cmp(&A[i], small) == -1)
		{
			(*newsize)++;
		}
	}
	if((*newsize) == 0)
	{
		printf("Non sono state trovate vendite superiori all'importo cercato\n");
		return NULL;
	}
	Sale *maggiori = xmalloc((*newsize) * sizeof(Sale));
	for(int i=0, j=0; i<n; i++)
	{
		if(sale_cmp(&A[i], small) == -1)
		{
			copy_sale(&maggiori[j++], &A[i]);
		}
	}
	return maggiori;
}

void copy_sale(Sale *dest, Sale *src)
{
	stpcpy(dest->description, src->description);
	dest->price1 = src->price1;
	dest->quantity = src->quantity;
}

int sale_save_larger(FILE *savefile, Sale *A, int n, Sale *small)
{
	//file già aperto e controllato
	int nuova_taglia;
	Sale *vendite = sale_larger(A, n, small, &nuova_taglia);
	for(int i=0; i<n; i++)
	{
		fprintf(savefile, "%s ", vendite[i].description);		
		fprintf(savefile, "%lf ", vendite[i].price1);		
		fprintf(savefile, "%lf ", vendite[i].quantity);		
		fprintf(savefile, "%lf \n", total_import(&vendite[i]));		
	}
	free(vendite);
	return nuova_taglia;
}