/*Questo programma legge il voto d'esame di un elenco di studenti e indica se si è promossi o bocciati*/

#include <stdio.h>

int confronto(int voto)
{
	int promossi;
	if(voto >= 18)
		{
			promossi = 1;
		}
	else
		{
			promossi = 0;
		}
	
	return promossi;
}

int main()
{
	int numstud, voto, bocciati;
	int promossi = 0;
	printf("Questo programma stabilisce il numero di studenti promossi e bocciati \n");
	printf("Inserire il numero totale degli studenti \n");
	scanf("%d", &numstud);
	
	if(numstud <= 0)
		{
			printf("Inserire un intero positivo \n");
			return 0;
		}
	else
		{
			int n = 0;
			while(n < numstud)
				{
					printf("Inserire il voto dello studente \n");
					scanf("%d", &voto);
					
					if(voto <= 0)
						{
							printf("Non inserire valori negativi \n");
							return 0;
						}
						
					else if(voto >= 31)
						{
							printf("Inserire interi compresi tra 1 e 30 inclusi \n");
							return 0;
						}
						
					else
						{
							if(confronto(voto) == 1)
								{
									promossi = promossi + 1;
								}							
							else
								{
									promossi = promossi;
								}
							n++;
						}
				}
			bocciati = numstud - promossi;
		}
	
	printf("Il numero di studenti promossi è %d \n", promossi);
	printf("Il numero di studenti bocciati è %d \n", bocciati);
	return 0;
}
