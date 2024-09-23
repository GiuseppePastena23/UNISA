#include <stdio.h>
#include <stdlib.h>
#define NOME "primi_numeri.txt"
#define NMAX 10

int main(void)
{
	FILE *pf;
	int cont;
	pf = fopen(NOME, "r - w - a");
	if (!pf)
		exit(1);
	for(cont = 1; cont <= NMAX; cont++)
	{
		fprintf(pf, "%d\n", cont);
	}
	fclose(pf);
	return 0;
}