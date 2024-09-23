/* Questo programma riceva una serie di anni e verifica se siano bisestili o meno*/

#include <stdio.h>

int bisestilef(int anno)
{
	int bisestile;
	
	if ((anno % 4 == 0 && anno % 100 != 0) || anno % 400 == 0)
		{
			bisestile = 1;
		}
	else 
		{
			bisestile = 0;
		}
		
	return bisestile;
}

int main()
{
	int anno;
	int check;
	check = 1;
	
	printf("Questo programma verifca che un anno in formato aaaa sia bisestile o meno \n");
	printf("Inserisci gli anni da valutare e concludi digitando -1 \n");

	while(check != 0 )
		{			
	
			printf("Inserisci l'anno da controllare \n");
			scanf("%d", &anno);
			bisestilef(anno);
	
			if (anno == -1) 
			{
				check = 0;
			} 
			
			else if ((anno >= 1, anno <= 9999) && (bisestilef(anno) == 1)) 
			{
				printf("L'anno è bisestile \n");
				check = 1;
			}
			
			else if ((anno >= 1, anno <= 9999) && (bisestilef(anno) != 1)) 
			{
				printf("L'anno non è bisestile \n");
				check = 1;
			}
			
			else 
			{
				printf("Il valore inserito non è in formato corretto \n");
				check = 1;
			}
		}
		
	return 0;
}