/* • Scrivere una funzione C         int rect_cmp(Rect *r1, Rect *r2)
che riceve come parametri gli indirizzi di due rettangoli e segnala quale dei due ha l’area più grande, restituendo: 
−1 se è il primo che ha l’area più grande; 1 se invece è il secondo; 0 se le due aree sono equivalenti.
 • Scrivere una funzione C           Rect * rect_smaller(Rect *A, int n, Rect *toobig, int *newsize)
che riceve come parametri un array A[] di n rettangoli e un puntatore toobig a un rettangolo. La funzione restituisce 
un array allocato dinamicamente contenente copie di tutti i rettangoli in A[] che hanno area minore del rettangolo puntato da toobig. 
Il parametro output newsize sarà impostato alla dimensione dell’array risultante. Nel caso nessun rettangolo in A[] 
soddisfi la condizione, rect_smaller() restituirà NULL e imposterà newsize a zero.
 • Scrivere una funzione C             int rect_save_smaller(FILE *savefile, Rect *A, int n, Rect *r0)
che riceve come parametri un file binario già aperto, un array di rettangoli A[] con la sua dimensione n, e un puntatore a rettangolo r0. 
La funzione salva nel file tutti i rettangoli in A[] che hanno un’area minore di quella di r0 e restituisce il numero di rettangoli salvati.*/

#include <stdio.h>
#include <stdlib.h>
#include "xmalloc.h"
#define NOME "rect_minori"

typedef struct{
	double x; 										// punto in alto a sinistra, coordinata x
	double y; 										// punto in alto a sinistra, coordinata y
	double w; 										// larghezza del rettangolo
	double h; 										// altezza del rettangolo
} Rect;

int rect_cmp(Rect *r1, Rect *r2);
double calcolo(Rect *p);
Rect * rect_smaller(Rect *A, int n, Rect *toobig, int *newsize);
int rect_save_smaller(FILE *savefile, Rect *A, int n, Rect *r0);

int rect_cmp(Rect *r1, Rect *r2)
{
	double area1 = calcolo(r1);
	double area2 = calcolo(r2);
	
	if(area1 > area2)
	{
		return -1;
	}
	else if(area1 < area2)
	{
		return 1;
	}
	else 
	{
		return 0;
	}
}

double calcolo(Rect *p)
{
	double a = p->w * p->h;
	return a;
}

Rect * rect_smaller(Rect *A, int n, Rect *toobig, int *newsize)
{
	*newsize = 0;
	for(int i=0; i<n; i++)
	{
		if(rect_cmp(&A[i], toobig) == 1)
		{
			(*newsize)++;
		}
	}
	//printf("%d\n", *newsize);
	if(*newsize == 0)
	{
		return NULL;
	}
	Rect *B = xmalloc(*newsize * sizeof(Rect));
	for(int i=0, j=0; i<(*newsize); i++)
	{
		if(rect_cmp(&A[i], toobig) == 1)
		{
			B[j++] = A[i];
		}
	}
	return B;
}

int rect_save_smaller(FILE *savefile, Rect *A, int n, Rect *r0)
{
	if(savefile == NULL)		//nel caso non fosse stato già controllato dalla funzione chiamante
	{
		exit(-3);
	}
	Rect *C;
	int taglia;
	C = rect_smaller(A, n, r0, &taglia);
	fwrite(C, sizeof(Rect), taglia, savefile);
	return 1;
}