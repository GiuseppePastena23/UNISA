/*Questo programma verifica la validità di una data in accordo al calendario gregoriano
il formato con cui inserirla da tastiera è ggmmaaaa
il calendario è stato introdotto il primo ottobre 1582
un anno è bisestile se divisibile per 4 ma non per 100 oppure se è divisibile per 400*/

#include <stdio.h>
int annof(int data);
int mesef(int data);
int giornof(int data);
int bisestilef(int anno);
int verificaf(int anno, int mese, int giorno, int bisestile);
int main ();

int annof(int data)
{
	int anno;
	anno = data % 10000;
	return anno;
}

int mesef(int data)
{
	int mese;
	mese = (data / 10000) % 100;
	return mese;
}

int giornof(int data)
{
	int giorno;
	giorno = data / 1000000;
	return giorno;
}

int bisestilef(int anno)
{
	if ((anno % 4 == 0 && anno % 100 !=0) || (anno % 400 ==0))
		{
			return 1;
		}
	else 
		{
			return 0;
		}
}

int verificaf(int anno, int mese, int giorno, int bisestile)
{
	
	if (((mese == 1) || (mese == 3) || (mese == 5) || (mese == 7) || (mese == 8) || (mese == 10 ) || (mese == 12)) && (giorno >=1 && giorno <=31))
		{
			return 1;
		}
		else if (((mese == 4) || (mese == 6) || (mese == 9) || (mese == 11)) && (giorno >= 1 && giorno <=30))
			{
				return 1;
			}
			else if (mese == 2) 
				{
					if(bisestile == 1)
						{
							if (giorno >= 1 && giorno <=29)
								{
									return 1;
								}
						}
					else 
						{
							if (giorno >= 1 && giorno <=28)
								{
									return 1;
								}
						}
				}
				
				return 0;
				
}

int main()
{
	int data;
	printf("Questo programma verifica la validità di una data scritta in formato ggmmaaaa \n");
	
	printf("Inserisci la data da controllare \n");
	scanf("%d", &data);
	
	int anno = annof(data);
	int mese = mesef(data);
	int giorno = giornof(data);
	int bisestile = bisestilef(data);
	
	if ((data >= 1) && (data <= 31129999) && (verificaf(anno, mese, giorno, bisestile) == 1))
		{
			printf("La data inserita è valida \n");
		}	
	else 
		{
			printf("La data inserita non è valida \n");
		}
		
	return 0;
}
