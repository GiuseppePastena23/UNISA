/*Questo programma spiega come stampare tabelle*/
#include <stdio.h>

int main ()
{
	int n, m, sum;
	printf("Questo programma esegue una somma \n");
	
	printf("Inserire il primo valore intero \n");
	scanf("%d", &n);
	
	printf("Inserire il secondo valore intero \n");
	scanf("%d", &m);
	
	sum = n + m;
	
	printf("n=%d\tm=%d\tsum=%d\n", n, m, sum);
	
	return 0;
}