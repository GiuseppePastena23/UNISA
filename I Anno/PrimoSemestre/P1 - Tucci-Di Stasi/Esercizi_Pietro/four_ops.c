/*Questo programma esegue le 4 operazioni fondamentali*/
#include <stdio.h>

int main()
{
	float a, b, sum, diff, prod, div;
	printf("Questo programma esegue le 4 operazioni fondamentali dati due numeri reali \n");
	
	printf("Inserire il primo valore \n");
	scanf("%f", &a);
	
	printf("Inserire il secondo valore \n");
	scanf("%f", &b);
	
	sum = a + b;
	diff = a - b;
	prod = a * b;
	div = a / b;
	
	printf("I valori inseriti sono %f e %f \n", a, b);
	printf("La somma vale %4.2f \n", sum);
	printf("La differenza vale %4.2f \n", diff);
	printf("Il prodotto vale %4.2f \n", prod);
	printf("La divisione vale %4.2f \n", div);
	
	return 0;
}