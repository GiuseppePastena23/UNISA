/*Il programma ricerca le vendite ricche, cioè quelle il cui importo supera una certa soglia,
e le salva in un array creato dinamicamente di taglia sartoriale. La funzione restituisce
l'array creato ed il parametro output newsize che ne indica la taglia.*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "xmalloc.h"
#include "vendita.h"

Vendita * ricche(Vendita *arr, int num, double soglia, int* newsize);
double importo(Vendita *p1);
void copia(Vendita *dest, Vendita *src);

Vendita * ricche(Vendita *arr, int num, double soglia, int* newsize)
{
	*newsize = 0;
	for(int i=0; i<num; i++)
	{
		if(importo(&arr[i]) >= soglia)
		{
			(*newsize)++;
		}
	}
	if((*newsize) == 0)
	{
		printf("Non ci sono vendite superiori alla soglia richiesta\n");
		return NULL;
	}
	
	Vendita *maggiori = xmalloc((*newsize) * sizeof(Vendita));

	for(int i=0, j=0; i<num; i++)
	{
		if(importo(&arr[i]) >= soglia)
		{
			//maggiori[j++] = arr[i];
			copia(&maggiori[j++], &arr[i]);
		}
	}
	return maggiori;
}

double importo(Vendita *p1)
{
	double pagamento;
	pagamento = p1->unit_pr * p1->quant;
	return pagamento;
}


void copia(Vendita *dest, Vendita *src)
{
	strcpy(dest->desc, src->desc);
	//char * newdesc = strdup(src->desc);
	dest->unit_pr = src->unit_pr;
	dest->quant = src->quant;
}
