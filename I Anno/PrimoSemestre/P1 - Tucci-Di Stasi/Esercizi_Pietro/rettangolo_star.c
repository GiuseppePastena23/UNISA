/*Questo programma costruisce rettangoli fatti di asterischi*/

#include <stdio.h>

int base(int a);
int altezza(int a, int b);
int main();


int base(int a)
{
	int i;
	
	for(i = 0; i < a; i++)
		{
			printf("* ");
		}
	printf("\n");
}

int altezza(int a, int b)
{
	while(b > 2)
		{
			int check;
			check = a;
			
			printf("* ");
			while(check > 2)
				{
					printf("  ");
					check--;
				}
			printf("* \n");
			b--;
		}
}


int main()
{
	int a, b;
	printf("Questo programma stampa un rettangolo date le sue misure \n");
	
	printf("Inserire la base \n");
	scanf("%d", &a);
	printf("Inserire l'altezza \n");
	scanf("%d", &b);
	
	if ((a <= 0) || (b <= 0))
		{
			printf("Non inserire valori negativi o uguali a 0 \n");
			return 0;
		}
		
	else if ((a == 1) && (b == 1))
		{
			printf("* \n");
		}
	
	else 
		{
			base(a);
			altezza(a, b);
			base(a);
		}
		
	return 0;
}