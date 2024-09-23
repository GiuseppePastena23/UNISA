/*Questo programma genera un vettore che compatta i valori inseriti dall'utente nel primo vettore
e inoltre non considera né le ripetizioni né gli zeri*/

#include <stdio.h>
#define NMAX 20

int main();
int copia_val(int a[], int n);

int main()
{
	int a[NMAX], n, i;
	printf("Questo programma ristampa i valori inseriti escludendo zeri e ripetizioni\n");
	printf("Quanti valori desidera inserire?\n");
	scanf("%d", &n);
	
	if((n <= 0) || (n >= 20))
	{
		printf("Inserire un intero positivo minore di 20\n");
		return 0;
	}
	else 
	{
		printf("Inserire i valori e premere invio ogni volta\n");
		for(i = 0; i < n; i++)
		{
			scanf("%d", &a[i]);
		}
	}
	copia_val(a, n);
}

int copia_val(int a[], int n)
{
	int i, j, k;
	int b[n];
	int valido = 0;
	
	for(i = 0; i < n; i++)
	{
		b[i] = 0;
	}
	
	for(i = 0; i < n; i++)
	{
		if(a[i] != 0)		          // numero candidato ad una possibile copia in b
		{
			for(j = 0; j < n; j++)
			{
				if(a[i] != b[j])
				{
					valido = 1;
				}
				else
				{
					valido = 0;
					break;
				}
			}
			
			if(valido == 1)
			{
				for(k = 0; k < n; k++)
				{
					if(b[k] == 0)
					{
						b[k] = a[i];
						a[i] = 0;
					}
				}
			}
		}
	}
	
	for(i = 0; i < n; i++)
	{
		if(b[i] == 0)
		{
			n--;
			i--;
		}
	}
	
	printf("La serie compattata è:\n");
	
	for(i = 0; i < n; i++)
	{
		printf("%d ", b[i]);
	}
	
	return 0;
}