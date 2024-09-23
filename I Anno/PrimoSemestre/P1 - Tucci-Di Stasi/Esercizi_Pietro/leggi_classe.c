/*Consideriamo un file contenente i voti riportati dagli studenti di una classe. Ogni studente
può avere un numero variabile di voti. I voti sono numeri interi compresi fra 1 e 10, separati
da spazi; la sequenza termina con il valore sentinella -1. Sappiamo che la classe contiene al
massimo MAXCLASSE studenti, ma non conosciamo il numero di voti di ogni studente.
Ecco un esempio di come potrebbe essere il file.
maria 6 5 7 6 -1
jessica -1
giovanni 3 4 6 6 5 -1
claudia 7 -1
marco 7 9 8 -1
Si definisca opportunamente un tipo Studente adatto a contenere il nome e la media dei
voti. Si scriva poi una funzione 			Studente * leggi_studente(FILE *fp)
che legga dal file già aperto i dati relativi a un solo studente, restituendo il puntatore ad
un oggetto di tipo Studente allocato dinamicamente, contenente il nome dello studente e la
sua media (oppure -1 se lo studente non ha voti). In caso di fine file, la funzione restituisce
un puntatore nullo.*/
/*Nelle stesse ipotesi dell’esercizio precedente, si scriva una funzione		Studente ** leggi_classe(FILE *fp)
che alloca dinamicamente un array di MAXCLASSE puntatori a Studente e usa ripetutamente
leggi_studente() per riempirlo con i dati degli studenti che hanno almeno un voto. Le
posizioni usate devono essere tutte contigue. Le posizioni non usate devono essere tutte
alla fine e contenere NULL. La funzione leggi_classe() restituisce l’array così riempito.*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "xmalloc.h"
#define MAXCLASSE 20
#define MAXNOME 50

typedef struct {
	char nome[MAXNOME+1];
	double media;
} Studente;

Studente * leggi_studente(FILE *fp);
Studente ** leggi_classe(FILE *fp);

Studente * leggi_studente(FILE *fp)
{
	Studente *nuovo;
	char nome[MAXNOME+1];
	int status, voto_attuale, nvoti=0, somma_voti=0;
	double media;
	status = fscanf(fp, "%s", nome);
	if(status != 1)		//.scanf restituisce un intero pari al numero di input che è stato possibile assegnare
	{
		return NULL;
	}
	while (1) {
		fscanf(fp, "%d", &voto_attuale);
		if(voto_attuale == -1)
		{
			break;
		}
		nvoti++;
		somma_voti = somma_voti + voto_attuale;
	}		
	nuovo = xmalloc(sizeof(Studente));
	if(somma_voti == 0)
	{
		media = -1.0;
	}
	else
	{
		media = somma_voti / nvoti;
	}
	strncpy(nuovo->nome, nome, MAXNOME);
	nuovo->media = media;
	return nuovo;
}

Studente ** leggi_classe(FILE *fp)
{
	Studente **classe;		//array di puntatori
	Studente *alunno;
	classe = xmalloc(MAXCLASSE * sizeof(Studente *));
	int i=0;
	while(i<MAXCLASSE){
		alunno = leggi_studente(fp);
		if(alunno != NULL)
		{
			if(alunno->media != -1)
			{
				classe[i] = alunno;
				i++;
			}
		}
		else
		{
			break;
		}
	}
	while(i<MAXCLASSE){
		classe[i] = NULL;
		i++;
	}
	return classe;
}