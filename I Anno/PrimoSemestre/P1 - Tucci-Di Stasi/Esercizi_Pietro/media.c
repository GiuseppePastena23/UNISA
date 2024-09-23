/*Questo programma calcola la media di due numeri*/
//Modificato per calcolare la media di n numeri
#include<stdio.h>

int main ()
{
	int n;
	float a, b, m, media;
	printf("Questo programma calcola la media di n numeri\n");
	/*printf("Inserire il primo valore\n");
	scanf("%d", &a);
	printf("Inserire il secondo valore\n");
	scanf("%d", &b);
	m = (a + b) / 2;	//in modo da conservare i numeri dopo la virgola in caso di divisioni non esatte
	printf("I valori inseriti sono %d e %d\n", a, b);
	printf("La loro media è %4.2f\n", m);*/
	printf("Quanti numeri desideri inserire?\n");
	scanf("%d", &n);
	if(n <= 0)
	{
		printf("Inserire solo valori positivi\n");
		return 0;
	}
	printf("Inserire il primo valore\n");
	scanf("%f", &a);
		if(n == 1)
	{
		printf("La media è: %f\n", a);
		return 0;
	}
	m = a;
	for(int i=0; i<(n-1); i++)
	{
		printf("Inserire il valore successivo\n");
		scanf("%f", &b);
		m = m + b;
	}
	media = m / n;
	printf("La loro media è %4.2f\n", media);
	return 0;
}