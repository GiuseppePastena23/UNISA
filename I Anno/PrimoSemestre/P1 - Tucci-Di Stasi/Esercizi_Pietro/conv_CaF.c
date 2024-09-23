/*Questo programma converte i gradi da Celsius a Fahrenheit
°F = ((°C * 9) / 5) + 32 */

#include <stdio.h>

int main()
{
	float c;
	int check = 1;
	printf("Questo programma converte i gradi da Celsius a Fahrenheit \n");
	printf("Inserire i valori e concludere digitando -274 \n");		//primo int inferiore allo zero assoluto
	while(check != 0)
	{
		printf("Inserire un valore \n");
		scanf("%f", &c);
		if(c == -274)
			{
				check = 0;
			}
		else if(c < -274)
			{
				printf("Non inserire valori inferiori a -274 \n");
				check = 1;
			}
		else
			{
				float f;
				f = ((c * 9) / 5) + 32;
				printf("Il valore in Fahrenheit è %4.2f \n", f);	//larghezza = 4; precisione = 2, max num di cifre a dx della virgola
				check = 1;
			}
	}
	return 0;
}