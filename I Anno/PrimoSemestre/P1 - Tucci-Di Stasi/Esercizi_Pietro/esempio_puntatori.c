/*I puntatori sono indirizzi di variabili che consentono di condividere dati fra diverse parti del programma (passaggio per riferimento
Vanno dichiarati usando un'asterisco * dopo aver indicato il tipo: int * p è un puntatore ad intero;
dopo la dichiarazione punterà ad un'area a caso della memoria, dunque bisognerà assegnarvi un valore*/

/*Il programma utilizza i parametri output per restituire il risultato di una divisione*/ 
/*L'operatore e commerciale & serve a prendere l'indirizzo di un oggetto*/ 

#include <stdio.h>
void divIntera(int num, int div, int *q, int *p);		//si aspetta di ricevere due int seguiti da due indirizzi di interi
int main(void);

void divIntera(int num, int div, int *q, int *p)	//la funzione opera sugli indirizzi ricorrendo ai puntatori
{
	*q=num/div;		//in questo modo la variabile quoziente conterrà il risultato della divisione
	*p=num%div;		//in questo modo la variabile resto conterrà il resto della divisione
}

int main(void)
{
	int quoziente, resto;
	divIntera(15, 7, &quoziente, &resto);	//la funzione passa come parametri le locazioni di memoria delle variabili
	printf("15 diviso 7 fa %d con resto %d\n", quoziente, resto);
	return 0;
}