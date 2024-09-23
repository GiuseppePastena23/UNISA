//Generico programma per testare la scrittura di file binari
#include <stdio.h>
#define NOME "lista_elem_minori"
#define NMAX 10

int main(void)
{
	FILE *fin;
	int array[NMAX] = {0};			//riempi un array a taglia definita di 0
	fin = fopen(NOME, "rb");		//apre il file binario scelto in lettura
	if(fin == NULL)
	{
		printf("Errore in apertura file\n");
		return 0;
	}
	int n = fread(array, sizeof(int), NMAX, fin);		//inserisci il sizeof necessario
	for(int i=0; i<NMAX; i++)
	{
		printf("%d ", array[i]);	//attento a cosa stampi
	}
	return 0;
}