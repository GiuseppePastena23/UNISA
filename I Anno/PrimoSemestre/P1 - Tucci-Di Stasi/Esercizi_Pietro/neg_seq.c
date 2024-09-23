/*. Scrivere una funzione C                    int * copy_neg_seq(int a[], int n, int *seqlen)
che ha come parametri un array a[] di numeri interi con la sua taglia n e restituisce un nuovo array contenente 
la prima sequenza di numeri negativi consecutivi che appare in a[]. L’array restituito dev’essere allocato dinamicamente 
sulla base dell’effettivo numero di elementi necessario. Il parametro output seqlen rifletterà la taglia del risultato.
Ai fini di questo esercizio, anche un solo numero negativo costituisce una sequenza (di lunghezza 1). 
Se l’array a[] non contiene numeri negativi, la funzione restituisce NULL e imposta a zero seqlen.

2. Con riferimento all’esercizio precedente, scrivere una funzione             void list_neg(FILE *fout, int a[], int n)
in cui, come prima, a[] è un array di n interi, mentre fout è un file binario già aperto in scrittura. 
La funzione scrive nel file la prima sequenza di numeri negativi consecutivi che appare in a[].
Saranno preferite le soluzioni che usano la funzione scritta nell’esercizio precedente*/

#include <stdio.h>
#include <stdlib.h>
#include "xmalloc.h"
#define NOME "lista_neg"

int * copy_neg_seq(int a[], int n, int *seqlen);
void list_neg(FILE *fout, int a[], int n);
int main(void);

int * copy_neg_seq(int a[], int n, int *seqlen)
{
	*seqlen = 0; 
	int j = 0;
	for(int i=0; i<n; i++)
	{
		if(a[i]<0)
		{
			*seqlen = *seqlen + 1;
		}
	}
	if((*seqlen) == 0)
	{
		*seqlen = 0;
		return NULL;
	}
	//printf("seqlen vale %d \n", (*seqlen));
	int *arr = xmalloc((*seqlen) * sizeof(int));
	for(int i=0; i<n; i++)
	{
		if(a[i]<0)
		{
			arr[j] = a[i];
			j++;
		}
	}
	return arr; 
}

void list_neg(FILE *fout, int a[], int n)
{
	int lenght;
	int *negativi;
	fout = fopen(NOME, "wb");
	if(fout == NULL)
	{
		exit(-2);
	}
	negativi = copy_neg_seq(a, n, &lenght);
	//printf("lenght vale %d \n", lenght);
	/*for(int i=0; i<lenght; i++)
	{
		printf("%d ", negativi[i]);
	}*/
	if(negativi != NULL)
	{
		fwrite(negativi, sizeof(int), lenght, fout);
	}
	else
	{		
		printf("Qualcosa è andato storto\n");
		exit(-3);
	}
	fclose(fout);
	return;
}

int main(void)
{
	int n = 9;
	int a[]={1,2,-3,-67,345,0,-99,2,-3};
	FILE *fout;
	list_neg(fout, a, n);
	//verifichiamo che sia andato tutto bene
	int k;
	int b[10];
	FILE *fin; 
	fin = fopen(NOME, "rb");
	if(fin == NULL)
	{
		printf("Qualcosa è andato storto\n");
		exit(-3);
	}
	k = fread(b, sizeof(int), 10, fin);
	for(int i=0; i<10; i++)
	{
		printf("%d ", b[i]);
	}
	fclose(fin);
	return 0;
}