/*Questo programma utilizza il crivello di Eratostene per ricercare i numeri primi*/

#include <stdio.h>
#define NMAX 10000

int main();
int eratostene(int a[], int n);
int shift(int a[], int n);


int main()
{
	int n, a[NMAX], i;
	printf("Questo programma ricerca i numeri primi entro 10000 \n");
	printf("Fino a che numero bisogna cercare? \n");
	scanf("%d", &n);
	
	if(n < 0)
	{
		printf("Non inserire valori negativi \n");
		return 0;
	}
	else if((n == 0) || (n == 1))
	{
		printf("Non ci sono numeri primi \n");
		return 0;
	}
	else if(n > 10000)
	{
		printf("Non inserire valori superiori a 10000 \n");
		return 0;
	}
	else 
	{
		for(i = 0; i < n; i++)
		{
			a[i] = i;
		}
	eratostene(a, n);
	}
}

int eratostene(int a[], int n)
{
	int i, j, m;
	a[1] = 0;
	for(i = 0; i < n; i++)
	{
		if(a[i] != 0)
		{
			j = a[i];
			while(j*a[i] < n)
			{
				a[j*a[i]] = 0;
				j++;
			}
		}
	}
	shift(a, n);
}

int shift(int a[], int n)
{
	int i, j, k;
	for(i = 0; i < n; i++)
	{		
		if(a[i] != 0)
		{
			for(k = 0; k < n; k++)
				{
					if(a[k] == 0)
						{
							a[k] = a[i];
							a[i] = 0;
						}
				}
		}
	}
	
	for(i=0; i<n; i++)
	{
		if(a[i] == 0)
		{
			n--;
			i--;
		}
	}
	
	for(i = 0; i < n; i++)
	{
		printf("%d ", a[i]);
	}
	
	printf("\n");
	
	int p=0;
	for(i=0; i<n; i++)
	{
		if(a[i] != 0)
			p++;
	}
	printf("Sono stati trovati %d numeri primi \n", p);
	printf("N.B.: non c'è stato alcun controllo riguardante il valore inserito all'inizio, \n");
	printf("il programma ricerca i numeri da 0 a n-1 \n");
	return 0;
}