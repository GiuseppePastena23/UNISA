/*Questo programma stampa un triangolo di asterischi */

#include<stdio.h>
int main();
int spazisx(int a, int t);
int asterischif(int a);

int main()
{
	int n, h, a, i, t;
	printf("Questo programma genera un triangolo fatto di * \n");
	printf("Quanto è lunga la base? \n");
	scanf("%d", &n);
	
	if(n <= 0) 
		{
			printf("Inserire valori interi positivi \n");
			return 0;
		}
	else 
		{
			if(n % 2 == 0) 
				{
					n = n - 1;
				}
			h = (n + 1) / 2;
			t = h;
			a = 1;
			
			for(i = 0; i < h; i++)
			{
				spazisx(a, t);
				asterischif(a);
				a = a + 2;
				t--;
				printf("\n");
			}
		}
		
	return 0;
}

int spazisx(int a, int t)
{
	int j;
	for(j = 0; j < t - 1; j++)
	{
		printf(" ");
	}
}

int asterischif(int a)
{
	int m;
	for(m = 0; m < a; m++)
	{
		printf("*");
	}
}