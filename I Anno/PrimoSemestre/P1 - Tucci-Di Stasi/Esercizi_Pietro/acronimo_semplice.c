/*Scrivere una funzione che prenda in input un array di stringhe e restituisca 
una stringa contenente le iniziali di ogni stringa in maiuscolo;
parole è un array di n stringhe;
prendiamola a caso, posizione data da un'altra funzione; 1 vuol dire posto 1*/
/*scrivere una funzione che prende come parametri un array di stringhe e un array di posizioni spostate di 1, con le rispettive lunghezze,
e scrive in un file di testo la posizione, la stringa, e infine una riga vuota seguita dall'acronimo*/
/*funzione che prende in input due stringhe, apre i file corrispondenti (parole.txt. e posizioni.txt)
(parole è 4  //Non // Abbiamo // Saputo // Aspettare)(posizioni è 4 // 1*/
//definisci un MAXSTR e tronca nel caso serva
//comando di shell: number(numero) e lui lo scrive a lettere, in inglese; tabelle di array di stringhe almeno fino a 19 

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>		//toupper si trova qui
#include "xmalloc.h"
#define FILE "acronimi.txt"

char * acronimo_semplice(char **parole, int n);
char * acronimo_difficile(char **parole, int n1, int posizioni[], int n2);

char * acronimo_semplice(char **parole, int n)
{
	char *acr;
	acr = xmalloc((n+1)*sizeof(char));
	if(n !=0)
	{
		for(int k=0; k<n; k++)
			{
				acr[k] = toupper(parole[k][0]);		//da minuscole a maiuscole
			}
	}
	acr[n] = '\0'; 		//eccoti il tappo
	return acr;
}

char * acronimo_difficile(char **parole, int n1, int posizioni[], int n2);
{
	char *acr;
	acr = xmalloc(n1 * sizeof(char) + 1);
	if(n != 0)
	{
		for(int k=0; k<n1; k++)
		{
			int i=0;
			if(k<n1)
			{
				i = posizioni[k];
			}
		}
	}
}