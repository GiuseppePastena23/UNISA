/*La funzione diagon_acrostic() prende come parametro un array
di n stringhe strings[], unitamente alla sua dimensione n. Il risultato è una nuova
stringa, allocata dinamicamente, che ha in prima posizione il primo carattere della
prima stringa, in seconda posizione il secondo carattere della seconda stringa, e così
via: in ultima posizione si troverà l’n-esimo carattere dell’n-esima stringa.
Per esempio:
stringhe[] = { "abc", "definitivo", "ghiro" }
diagon_acrostic(stringhe, 3) = "aei"
Ognuna delle stringhe in strings[] dev’essere lunga almeno n caratteri. Se la funzione
scopre un elemento di strings[] che è lungo meno di n, restituisce NULL. Scrivere
diagon_acrostic().*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "xmalloc.h"
#define MAX 30

char * diagon_acrostic(char *strings[], int n);
int conta_stringhe_corte(FILE *fp, int limite);

char * diagon_acrostic(char *strings[], int n)
{
	int i;
	if(strlen(strings[i])<n)
		{
			printf("Errore: una delle stringhe è di lunghezza inferiore a quella aspettata\n");
			return NULL;
		}
	char *diagonale;
	diagonale = xmalloc(n + 1);	//la stringa risultante sarà lunga n, cui si aggiunge lo spazio per il tappo
	for(i=0; i<n; i++)
	{
		diagonale[i] = strings[i][i];	//array di puntatori a char, dunque necessita di due campi durante l'assegnamento
	}
	diagonale[i] = '\0';	//tappo aggiunto
	return diagonale;
}

/*Un file di testo, già aperto per la lettura, contiene una serie di stringhe prive di spazi, una
per riga, ognuna lunga al più MAX caratteri (MAX è una costante che assumiamo predefinita).
(a) Scrivere una funzione
conta_stringhe_corte(FILE *fp, int limite)
che legge il file e restituisce il numero di stringhe di lunghezza inferiore a limite.*/

int conta_stringhe_corte(FILE *fp, int limite)
{
	char buffer[MAX];
	int check = 1;	//servirà da sentinella per verificare che il file non sia finito
	int counter = 0;
	while(1){
		check = fscanf(fp, "%s", &buffer[0]);
		if(check != 1)
		{
			break;	//Ricorda: fscanf restituisce il numero di elementi letti/assegnati
		}
		else
		{
			if(strlen(&buffer[0]) < limite)
			{
				counter++;
			}
		}
	}
	return counter;		//non è richiesta la chiusura del file
}