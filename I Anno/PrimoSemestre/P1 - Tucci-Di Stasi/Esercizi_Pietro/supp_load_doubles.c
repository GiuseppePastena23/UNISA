//Funzione per scrivere un file binario

#include <stdio.h>
#include <stdlib.h>
#include "xmalloc.h"

int main(void)
{
	int numero = 6;
	double array [6]= {8.8,6.1,4.12,2.1,-0.5,-2.1};
	FILE *fin;
	fin = fopen("lista_float", "wb");
	fwrite(&numero, sizeof(int), 1, fin);
	fwrite(array, sizeof(double), 6, fin);
	fclose(fin);
	return 0;
}