/*Questo programma calcola la somma dei quadrati di due numeri usando una funzione*/

#include <stdio.h>
float quadrato(float X);

int main ()
{
	float a,b;
	printf("Questo programma calcola la somma dei quadrati di due numeri \n");
	
	printf("Inserire il primo numero \n");
	scanf("%f", &a);
	printf("Inserire il secondo numero \n");
	scanf("%f", &b);
	
	printf("La somma dei loro quadrati è %f \n", quadrato(a)+quadrato(b));
	
	return 0;
}

float quadrato(float X)
{
	float z;
	z = X * X;
	return (z);
}