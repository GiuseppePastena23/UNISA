/*Questo programma calcola il fattoriale di un numero*/
#include <stdio.h>

int main ()
{
	int n, i, fattoriale;
	
	printf("Questo programma calcola il fattoriale di un numero \n");
	printf("Inserire un valore non negativo \n");
	scanf("%d", &n);
	
	if (n >= 0) 
	{
		fattoriale = 1;
		for(i=2; i<=n; i++)
			fattoriale = fattoriale * i;
		printf("Fattoriale di %d : %d \n", n, fattoriale);
		
	}
	else 
	{
		printf("Ti ho detto di non metterlo negativo testa di c \n");
		printf("Chiedo venia egregio signore, ma gradirei un input positivo \n");
	}
}