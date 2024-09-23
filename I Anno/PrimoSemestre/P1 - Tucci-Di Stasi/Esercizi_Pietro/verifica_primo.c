/*Questo programma stabilisce se il numero inserito sia primo o meno*/

#include <stdio.h>

int verifica_primo(int n)
{
	int i, primo;
	
	for(i = 2; i < n;)
		{
			if(n % i == 0)
				{
					primo = 0;
					break;
				}
			else
				{
					primo = 1;
					i++;
				}
		}
	return primo;
}

int main()
{
	int n;
	int check = 1;
	printf("Questo programma stabilisce se il numero inserito sia primo o meno \n");
	printf("Per terminare inserire 0 \n");
	
	while(check != 0)
	{
		printf("Inserire un numero intero \n");
		scanf("%d", &n);
	
		if(n == 0)
			{
				check = 0;
			}
		else if ((n == 2) || ((n != 0) && (verifica_primo(n) == 1)))
			{
				printf("Il numero inserito è primo \n");
				check = 1;
			}
		else if ((n == 1) || ((n != 0) && (verifica_primo(n) == 0)))
			{
				printf("Il numero inserito non è primo \n");
				check = 1;
			}
	}
	return 0;
}