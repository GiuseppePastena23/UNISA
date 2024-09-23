/*Scrivere una funzione elementi_minori che conta quanti elementi di un array siano inferiori ad un certo valore 
e restituisca un array allocato dinamicamente contenente tali elementi; l'array dovrà essere di taglia sartoriale,
inoltre dovrà restituire come parametro di output la taglia del nuovo array
2. Scrivere una funzione				void salva_minori (FILE *fout, int A[ ], int n, int val)
che, ricevendo un vettore A di n interi, scrive in un file binario già aperto in precedenza il valore 
di val, il numero degli elementi di A che hanno valore inferiore a val, poi tutti i valori stessi.
Per esempio, se A = { 18, -14, 21, 36, 63, -1 } e val = 36, il file puntato da fout conterrà i seguenti valori interi: 36 4 18 -14 21 -1. 
Se invece val = -100, il file conterrà i seguenti valori interi: -100 0*/

#include <stdio.h>
#include <stdlib.h>
#include "xmalloc.h"
#define NMAX 10
#define VAL 5
#define NOME "lista_elem_minori"

int * elementi_minori(int a[], int n, int val, int *newsize);
void salva_minori (FILE *fout, int A[ ], int n, int val);
int main(void);

int * elementi_minori(int a[], int n, int val, int *newsize)
{
	*newsize=0;
	for(int i=0; i<n; i++)
	{
		if(a[i]<val)
		{
			(*newsize)++;											//incrementa il valore della taglia del nuovo array 
		}
	}
	printf("Il valore puntato da newsize è: %d \n", *newsize);
	if((*newsize) == 0)
	{
		return NULL;
	}
	int *arr = xmalloc((*newsize) * sizeof(int));					//alloca dinamicamente un'array di taglia esatta 
	
	int j=0;
	for(int i=0; i<n; i++)											//copia i valori desiderati nel nuovo array
	{
		if(a[i]<val)
		{
			arr[j]=a[i];
			j++;
		}
	}

	printf("I valori dopo la copia sono:\n");
	for(int i=0; i<(*newsize); i++)
	{
		printf("%d ", arr[i]);
	}
	return arr;
	
	
}

void salva_minori (FILE *fout, int A[ ], int n, int val)
{
	int nuova_taglia = 0;
	fwrite(&val, sizeof(int), 1, fout);
	int *arr_min = elementi_minori(A, NMAX, VAL, &nuova_taglia);
	fwrite(&nuova_taglia, sizeof(int), 1, fout);
	fwrite(arr_min, sizeof(int), nuova_taglia, fout);
}

int main(void)
{
	int A[NMAX]={1,2,3,4,5,6,7,8,9,10};
	FILE *fout;
	fout = fopen(NOME, "wb");
	if(fout == NULL)
	{
		printf("Errore in apertura file\n");
		exit(-3);
	}
	salva_minori(fout, A, NMAX, VAL);
	return 0;	
}