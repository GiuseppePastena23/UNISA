/*Questo programma restituisce il prodotto dei primi n numeri*/

#include <stdio.h>

int main()
{
	int n;
	int prodotto = 1;
	int i = 2;
	printf("Questo programma restituisce il prodotto dei primi n numeri \n");
	printf("Inserisci n \n");
	scanf("%d", &n);
	
	while(i < n + 1)
	{
		prodotto = prodotto * i;
		i++;
	}
	printf("Il prodotto dei primi %d numeri vale %d \n", n, prodotto);
	
	return 0;
}