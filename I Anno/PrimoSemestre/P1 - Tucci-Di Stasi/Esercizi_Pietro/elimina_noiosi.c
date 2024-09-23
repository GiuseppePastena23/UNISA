/*Questo programma ricerca i numeri interessani cioè quelli che rispettano 
una stessa proprietà: l'essere dispari ed avere resto 1 se se divisi per 3*/

#include <stdio.h>
#define NMAX 10000

int main();
int elimina_noiosi(int a[], int n);
int shift(int a[], int n);

int main()
{
	int a[NMAX], n, i;
	printf("Questo programma ricerca i numeri interessanti\n");
	printf("Quanti numeri desideri inserire?\n");
	scanf("%d", &n);
	
	if(n < 0)
	{
		printf("Non inserire valori negativi\n");
		return 0;
	}
	else if(n==0)
	{
		printf("Non ci sono numeri interessanti\n");
		return 0;
	}
	else if(n > 10000)
	{
		printf("Non inserire valori maggiori di 10000\n");
		return 0;
	}
	else
	{		
		printf("Inserire i valori\n");
		for(i = 0; i < n; i++)
		{
			scanf("%d", &a[i]);
		}
	}
	
	elimina_noiosi(a, n);
	
	/*for(i = 0; i < n; i++)
	{
		printf("%d ", a[i]);
	}
	return 0;*/
}

int elimina_noiosi(int a[], int n)
{
	int i;
	for(i = 0; i < n; i++)
	{
		if((a[i] % 2 == 0) || (a[i] % 3 == 0) || (a[i] % 3 == 2))
		{
			a[i] = 0;
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
	printf("Sono stati trovati %d numeri interessanti\n", p);
	
	return 0;
}