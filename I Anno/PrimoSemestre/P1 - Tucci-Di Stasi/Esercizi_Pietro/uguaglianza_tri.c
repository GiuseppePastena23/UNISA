#include <stdio.h>
#include <stdlib.h>
#include "xmalloc.h"

typedef struct punto {
	double x;
	double y;
} Punto;

void inserisci(struct punto* T);
int main(void);
int verifica(struct punto* T1, struct punto* T2);
void ordina(double A[], int num);

void inserisci(struct punto* T)
{
	for(int i=0; i<3; i++)				//riempie i campi delle strutture
	{
		printf("Inserire l'ascissa\n");
		scanf("%lf", &T[i].x);
		printf("Inserire l'ordinata\n");
		scanf("%lf", &T[i].y);
	}
}

int main(void)
{
	printf("Questo programma verifica che due triangoli siano uguali a meno di traslazioni, rotazioni e ribaltamenti\n");
	struct punto* T1 = xmalloc(3*sizeof(struct punto));
	struct punto* T2 = xmalloc(3*sizeof(struct punto));
	printf("Inserire le coordinate dei tre vertici del primo triangolo\n");	
	inserisci(T1);
	printf("Inserire le coordinate dei tre vertici del secondo triangolo\n");	
	inserisci(T2);
	printf("Le coordinate del primo triangolo sono: \n");
	for(int i=0; i<3; i++)
	{
		printf("%lf ", T1[i].x);
		printf("%lf ", T1[i].y);
	}
	printf("\nLe coordinate del secondo triangolo sono: \n");
	for(int i=0; i<3; i++)
	{
		printf("%lf ", T2[i].x);
		printf("%lf ", T2[i].y);
	}
	if (verifica(T1, T2) == 1)			
	{
		printf("\nI triangoli sono uguali\n");
	}
	else
	{
		printf("\nI triangoli sono diversi\n");
	}
	return 0;
}

int verifica(struct punto* T1, struct punto* T2)
{
	double A[3]={0}, B[3]={0};								//dichiaro 2 array dove salvare le lunghezze dei lati
	int p=0;
	for(int i=0; i<3; i++)
	{
		A[i]=(T1[i].x - T1[(i+1)%3].x)*(T1[i].x - T1[(i+1)%3].x) + (T1[i].y - T1[(i+1)%3].y)*(T1[i].y - T1[(i+1)%3].y);
		B[i]=(T2[i].x - T2[(i+1)%3].x)*(T2[i].x - T2[(i+1)%3].x) + (T2[i].y - T2[(i+1)%3].y)*(T2[i].y - T2[(i+1)%3].y);
	}
	printf("\nLe distanze appena ottenute sono:\n");
	for(int i=0; i<3; i++)
	{
		printf("A: %lf ", A[i]);
		printf("B: %lf ", B[i]);
	}
	ordina(A, 3);								//pone i lati in ordine crescente per facilitare i confronti
	ordina(B, 3);
	printf("\nLe distanze messe in ordine crescente sono:\n");
	for(int i=0; i<3; i++)
	{
		printf("A: %lf ", A[i]);
		printf("B: %lf ", B[i]);
	}
	for(int i=0; i<3; i++)
	{
		if(A[i]!=B[i])
		{
			p=0;
			break;
		}
		else
		{
			p=1;
		}
	}
	return p;
}

void ordina(double A[], int num)
{
	double temp;
	for(int i=0; i<num; i++)								//il maggiore andrà sicuramente in fondo
	{
		if(A[i] < A[i-1])
		{
			temp = A[i];
			A[i] = A[i-1];
			A[i-1] = temp;
		}
	}
	if(A[1] < A[0]) 									//a fine ciclo i primi due potrebbero non essere in ordine
	{
		temp = A[0];
		A[0] = A[1];
		A[1] = temp;
	}
}