/*Questo programma stampa il numero precedente e quello successivo ad un intero*/

#include<stdio.h>
int main()
{
	int numero, precedente, successivo;
	printf("Questo programma stampa il numero precedente e quello successivo di un numero \n");
	
	printf("Inserire un numero \n");
	scanf("%d", &numero);
	precedente = numero - 1;	//numero--
	successivo = numero + 1;	//numero++
	
	printf("Il precedente è: %d \n", precedente);
	printf("Il successivo è: %d \n", successivo);
	
	return 0;
}