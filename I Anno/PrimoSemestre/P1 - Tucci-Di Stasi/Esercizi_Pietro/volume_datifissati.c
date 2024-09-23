/*Questo programma calcola il volume di un parallelepipedo di dimensioni fissate */

#include<stdio.h>
int main(void)
{
	int height, lenght, width, volume;
	height = 8;
	lenght = 10;
	width = 12;
	volume = height * lenght * width; 			//formula
	
	printf("Dimensioni parallelepipedo: %d, %d, %d \n", height, lenght, width);
	
	printf("Il volume è: %d \n", volume);
	
	return 0;
}