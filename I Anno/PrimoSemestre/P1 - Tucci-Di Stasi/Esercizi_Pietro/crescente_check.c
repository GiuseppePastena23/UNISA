/*Questo programma legge N numeri e stabilisce se sono disposti in ordine crescente, decrescente o nessuno dei due*/

#include <stdio.h>

int main()
{
	int num, p, s, i, n; 
	int crescente = 0;
	int decrescente = 0;
	
	printf("Questo programma verifica che una serie di numeri sia in ordine o meno \n");
	printf("Quanti valori desideri inserire? \n");
	scanf("%d", &num);
	
	if(num <= 0)
	{
		printf("Inserire un intero positivo \n");
		return 0;
	}
	
	printf("Inserire il primo valore \n");
	scanf("%d", &p);
	printf("Inserire il secondo valore \n");
	scanf("%d", &s);
	
	if((num == 2) && (p < s))
	{
		printf("La serie è in ordine crescente \n");
		return 0;
	}
	
    if((num == 2) && (p > s))
	{
		printf("La serie è in ordine decrescente \n");
		return 0;
	}
	
	for(i = 0; i < (num - 2); i++)
		{
			if(p < s)
				{
					printf("Inserire il valore successivo \n");
					scanf("%d", &n);
					if(s <= n)
						{
							crescente = 1;
						}
					else
						{
							crescente = 0;
						}
				}
			else
				{
					printf("Inserire il valore successivo \n");
					scanf("%d", &n);
					if(s >= n)
						{
							decrescente = 1;
						}
					else
						{
							decrescente = 0;
						}
				}
		}
		
	if(crescente == 1)
		{
			printf("I numeri sono in ordine crescente \n");
		}
	else if(decrescente == 1)
		{
			printf("I numeri sono in ordine decrescente \n");
		}
	else 
		{
			printf("I numeri non sono né in ordine crescente né in ordine decrescente \n");
		}
		
	return 0;
}