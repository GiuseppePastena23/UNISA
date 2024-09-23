/*Questo programma stampa l'intersezione di due vettori*/

#include <stdio.h>
#define NMAX 30

int main();
int intersez(int a[], int n);


int main()
{
	int a[NMAX];
	int n, i;
	printf("Questo programma stampa i valori comuni alle due serie immesse\n");
	printf("Quanti sono i valori da inserire nella prima serie?\n");
	scanf("%d", &n);
	
	if((n < 0) || (n > 30))
	{
		printf("Inserire valori interi compresi tra 0 e 30\n");
		return 0;
	}
	
	printf("Inserire la prima serie di valori e premere invio ad ogni numero\n");
	for(i = 0; i < n; i++)
	{
		scanf("%d", &a[i]);
	}
	intersez(a, n);
}

int intersez(int a[], int n)
{
	int b[NMAX];
	int c[NMAX];
	int m, i, j, k;
	int valido = 0;
	
	printf("Quanti sono i valori da inserire nella seconda serie?\n");
	scanf("%d", &m);
	
	if((m < 0) || (m > 30))
	{
		printf("Inserire valori interi compresi tra 0 e 30\n");
		return 0;
	}
	
	printf("Inserire la seconda serie di valori e premere invio ad ogni numero\n");
	for(j = 0; j < m; j++)
	{
		scanf("%d", &b[j]);
	}
	
	for(i = 0; i < NMAX; i++)
	{
		c[i] = 0;
	}
	
	for(i=0; i<n; i++)
	{
		if(a[i] != 0)
		{
			for(j=0; j<m; j++)
			{
				if(a[i] == b[j])
				{
					valido = 1;
					break;
				}
				else
				{
					valido = 0;
				}
			}
			
			if(valido == 1)
			{
				for(k=0; k<NMAX; k++)
				{
					if(c[k] == 0)
					{
						c[k] = a[i];
						a[i] = 0;
						b[j] = 0;
					}
				}
			}
		}
	}
	
	for(i=0; i<k; i++)
	{
		if(c[i] == 0)
		{
			k--;
			i--;
		}
	}
	
	printf("I valori comuni sono:\n");
	for(i=0; i<k; i++)
	{
		printf("%d ", c[i]);
	}
	return 0;
}