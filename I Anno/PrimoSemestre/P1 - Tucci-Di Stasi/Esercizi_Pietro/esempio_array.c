/*Questo programma legge i numeri inseriti in un array e li ristampa
ristampa poi una seconda riga di numeri a partire dalla precedente in cui 
i numeri dispari vengono trasformati in pari tramite una moltiplicazione per 2
infine cercherà massimo e minimo della sequenza*/

#include <stdio.h>
#define N 10
int main();
void raddoppia(int a[]);
void trova_minmax(int a[]);

int main()
{
	int i;
	int a[N];
	printf("Questo programma stampa la sequenza di numeri inserita e poi raddoppia i numeri dispari \n");
	printf("Il programma determinerà poi quali siano massimo e minimo \n");
	
	printf("Inserire 10 numeri interi \n");
	for(i = 0; i < N; i++)
	{
		scanf("%d", &a[i]);
	}
	
	for(i = 0; i < N; i++)
	{
		printf("%d ", a[i]);
	}
	
	printf("\n");
	
	trova_minmax(a);
	printf("\n");
	
	raddoppia(a);

	return 0;
}

void raddoppia(int a[])
{
	int i;
	for(i = 0; i < N; i++)
	{
		if(a[i] % 2 == 0)
		{
			a[i]= a[i];
		}
		else
		{
			a[i]= a[i] * 2;
		}
		printf("%d ", a[i]);
	}
}
	
void trova_minmax(int a[])
{
	int i, minimo, massimo;
	minimo = a[0];
	massimo = a[0];
	
	for(i = 0; i < N; i++)
	{
		if(a[i] < minimo)
		{
			minimo = a[i];
		}
		if(massimo < a[i])
		{
			massimo = a[i];
		}
	}
	printf("Il minimo è %d \n", minimo);
	printf("Il massimo è %d \n", massimo);
}