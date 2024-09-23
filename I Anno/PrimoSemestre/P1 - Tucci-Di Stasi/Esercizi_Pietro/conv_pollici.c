/*Questo programma converte una misura da centimetri a piedi e pollici*/
/*Un pollice vale 2.54cm - Un piede vale 12 pollici*/

#include <stdio.h>

int main()
{
	int feet;
	float cm, inches, totInches;
	
	printf("Questo programma converte centimetri in piedi e pollici \n");
	printf("Inserire il valore non negativo dei centimetri \n");
	scanf("%f", &cm);
	
	totInches = cm / 2.54;
	feet = totInches / 12;
	inches = totInches - (feet * 12);
	
	printf("%f cm = %d ft + %f inches \n", cm, feet, inches);
	
	return 0;
}