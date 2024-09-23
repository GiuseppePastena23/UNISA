/*(a) Scrivere una funzione     int numMultipli (int A[ ], int n, int val)
che riceve un vettore A di n interi e restituisce il numero di elementi di A che sono multipli di val.
(b) Scrivere una funzione       int * tuttiMultipli (int A[ ], int n, int val)
che riceve un vettore A di n interi e restituisce un array d’interi allocato dinamicamente e contenente tutti i
multipli di val contenuti in A. Usare la funzione scritta al punto precedente per determinare la taglia dell’array allocato dinamicamente.
ESERCIZIO 2) Scrivere una funzione           int salvaMultipli(FILE *fout, int A[ ], int n, int val)
che, ricevendo un vettore A di n interi, scrive in un file di testo già aperto in precedenza il valore di val, il
numero dei multipli di val contenuti in A, e poi i multipli stessi, ciascuno su una riga.
Per esempio, se A = {18, 14, 21, 36, 63} e val =7, il file conterrà 5 righe con i seguenti interi:
7
3
14
21
63
La funzione restituisce 1 se tutto è andato bene, 0 in caso d’errore. Usare le funzioni scritte all’esercizio
precedente.*/

#include <stdio.h>
#include <stdlib.h>
#include "xmalloc.h"
#define NOME "multipli_val"

int numMultipli (int A[], int n, int val);
int * tuttiMultipli (int A[], int n, int val);
int salvaMultipli(FILE *fout, int A[ ], int n, int val);
int main(void);

int numMultipli (int A[], int n, int val)
{
	int counter = 0;
	for(int i=0; i<n; i++)
	{
		if(A[i]%val == 0)
		{
			counter++;
		}
	}
	//printf("Counter vale %d \n", counter);
	return counter;
}

int * tuttiMultipli (int A[], int n, int val)
{
	int newsize, j=0;
	newsize	= numMultipli (A, n, val);
	//printf("newsize vale %d \n", newsize);
	int *arr = xmalloc(newsize * sizeof(int));
	for(int i=0; i<n; i++)
	{
		if(A[i]%val == 0)
		{
			arr[j] = A[i];
			j++;
			arr[j++] = A[i]
		}
	}
	return arr;
}

int salvaMultipli(FILE *fout, int A[ ], int n, int val)
{
	fout = fopen(NOME, "w");
	if(fout == NULL)
	{
		//printf("Errore durante l'apertura del file input");
		//exit(-2);
		return 0;
	}
	fprintf(fout, "%d\n", val);
	int nmult = numMultipli(A, n, 2);
	fprintf(fout, "%d\n", nmult);
	int *q = tuttiMultipli(A, n, 2);
	for(int i=0; i<nmult; i++)
	{
		fprintf(fout, "%d\n", q[i]);
	}
	return 1;
}

int main(void)
{
	int n = 9;
	int A[]={0,1,2,3,4,5,6,7,8};
	FILE *fout;
	//int *p = tuttiMultipli(A, n, 2);
	//int size = numMultipli(A, n, 2);
	/*for(int i=0; i<size; i++)
	{
		printf("%d ", p[i]);
	}*/
	if(salvaMultipli(fout, A, n, 2) == 1)
	{
		printf("Tutto bene");
	}
	else
	{
		printf("Qualcosa è andato storto");
	}
	fclose(fout);
	return 0;
}
