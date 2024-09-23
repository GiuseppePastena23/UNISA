/*Questo programma prende in input una sequenza di numeri e determina quanti sono pari e quanti sono dispari */

#include <stdio.h>

int main()
{
	int n;
	int check = 1;
	int pari = 0;
	int dispari = 0;
	printf("Questo programma conta quanti numeri pari e quanti dispari vengono inseriti \n");
	printf("Inserire i valori e terminare digitando -1 \n");
	
	while(check == 1)
		{
			printf("Inserire un valore \n");
			scanf("%d", &n);
			
			if(n % 2 == 0)
				{
					pari++;
					check = 1;
				}
			else if (n % 2 == 1)
				{
					dispari++;
					check = 1;
				}
			else
				{
					check = 0;
				}
		}
	printf("Sono stati inseriti %d pari e %d dispari \n", pari, dispari);
	
	return 0;
}