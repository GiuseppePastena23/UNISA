#include <stdio.h>
#include <stdlib.h>
#include "PQueue.h"
#define MAXPQ 50

struct c_PQ {
	int vet[MAXPQ];
	int numEl;
};

//Funzioni di servizio
static void scendi(PQueue q);
static void sali(PQueue q);

/*ANALISI E PROGETTAZIONE DI scendi
scendi(PQueue) -> void
scendi(q) -> void
precondizioni: Nessuna
postcondizioni: Dopo l'esecuzione q sarà ancora una coda con priorità
1. Finché il nodo corrente non avrà figli oppure avrò terminato gli scambi tra chiavi
1.1 Controllo quanti figli abbia il nodo corrente
1.2 Scambio le chiavi
*/
static void scendi(PQueue q) {
	int temp, i = 1, n = q->numEl, pos;
	while(1) {
		if((2 * i) + 1 <= n)	//il nodo corrente ha 2 figli
			pos = (q->vet[i * 2] > q->vet[(i * 2) + 1]) ? i * 2 : (i * 2) + 1;
		else if(2 * i <= n) 	//il nodo corrente ha 1 figlio
			pos = 2 * i;
		else	//il nodo corrente non ha figli
			break;
		if(q->vet[pos] > q->vet[i]) {	//scambio le chiavi
			temp = q->vet[i];
			q->vet[i] = q->vet[pos];
			q->vet[pos] = temp;
			i = pos;
		}
		else	//scambi terminati
			break;
	}
}

/*ANALISI E PROGETTAZIONE DI sali
sali(PQueue) -> void
sali(q) -> void
precondizioni: Nessuna
postcondizioni: Dopo l'esecuzione q sarà ancora una coda con priorità
1. Fin quando pos sarà maggiore di 1
1.1 Verifico che la chiave di posto pos sia maggiore di quella di posto i
1.2 Se è vero, scambio le due chiavi e proseguo
1.3 Altrimenti termino
*/
static void sali(PQueue q) {
	int temp, pos = q->numEl, i = pos/2;
	while (pos > 1) {
		if(q->vet[pos] > q->vet[i]) {
			temp = q->vet[i];
			q->vet[i] = q->vet[pos];
			q->vet[pos] = temp;
			pos = i;
			i = pos/2;
		}
		else
			break;
	}
}

/*PROGETTAZIONE di newPQ
1. Alloco la nuova coda con priorità
2. Nel caso sia riuscita, imposto il numero di elementi a 0 e restituisco la coda
2.1 altrimenti restituisco NULL
*/
PQueue newPQ() {
	PQueue q;
	q = malloc(sizeof(struct c_PQ));
	if(q == NULL) {
		return NULL;
	}
	q -> numEl = 0;
	return q;
}

/*PROGETTAZIONE DI emptyPQ
1. Verifico che la coda sia stata allocata
2. Se ci sono 0 elementi, restituisco 1, altrimenti restituisco 0
*/
int emptyPQ(PQueue q) {
	if(q == NULL)
		return 1;
	return q->numEl == 0;
}

/*PROGETTAZIONE DI getMAX
1. Restituisco l'elemento di posto 1
*/
int getMAX(PQueue q) {
	return q->vet[1];
}

/*PROGETTAZIONE DI deleteMAX
1. Verifico che la coda non sia vuota
2. Copio l'ultimo elemento nella posizione 1 e riduco il numero di elementi
3. Riordino lo heap (funzione separata)
*/
int deleteMax(PQueue q) {
	if((q == NULL) || (q->numEl == 0))		//verifica che non sia vuota
		return 0;
	q->vet[1] = q->vet[q->numEl];		//porta l'ultimo elemento in posizione 1
	q->numEl = q->numEl - 1;
	scendi(q);	//rioridina lo heap
	return 1;
}

/*PROGETTAZIONE DI insert
1. Verifico che la coda non sia vuota
2. Inserisco l'elemento nell'ultima posizione e incremento il numero di elementi
3. Riordino lo heap(funzione separata)
*/
int insert(PQueue q, int key) {
	if((q == NULL) || (q->numEl == MAXPQ))	//verifica che la coda non sia piena
		return 0;
	q->vet[q->numEl] = key;		//inserisce in ultima posizione
	q->numEl = q->numEl + 1;
	sali(q);	//riordina lo heap
	return 1;
}