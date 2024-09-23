/*. Scrivere una funzione      int copia_unici(int src[], int dest[], int size)
che prende come parametri due array d’interi src[] e dest[], entrambi di taglia size, e copia all’inizio di dest[] 
gli elementi di src[] evitando le ripetizioni: se un elemento di src[] compare due o più volte, anche non consecutive, 
soltanto la sua prima occorrenza sarà copiata. La funzione restituisce il numero di elementi copiati.
Per esempio: se src[] = { -6, 2, 0, 2, 13, -6, -6, 2, 0 }
e invochiamo copia_unici(src, dest, 9)
i primi 4 elementi di dest[] diventeranno { -6, 2, 0, 13 },
e la funzione restituirà 4.*/

#include <stdio.h>
#include <stdlib.h>
#include "xmalloc.h"

int copia_unici(int src[], int dest[], int size);
int check(int inc, int ncopia, int dest[]);
int main(void);

int copia_unici(int src[], int dest[], int size)
{
	int ncopia = 0;
	for(int i=0; i<size; i++)
	{
		if(!check(src[i], ncopia, dest))
		{
			ncopia++;
		}
	}
	//dest = realloc(dest, ncopia * sizeof(int));
	ncopia = 0;
	for(int i=0; i<size; i++)
	{
		if(!check(src[i], ncopia, dest))
		{
			dest[ncopia++] = src[i];
		}
	}
	return ncopia;
}

int check(int inc, int ncopia, int dest[])
{
	for(int i=0; i<ncopia; i++)
	{
		if(dest[i] == inc)
		{
			return 1;
		}
	}
	return 0;
}

int main(void)
{
	int n = 8;
	int src[8] = {1,2,3,4,1,2,3,4};
	int dest[8] = {2,5,7,6,3};
	int copiati = copia_unici(src, dest, n);
	printf("%d ", copiati);
	return 0;
}