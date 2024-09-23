/* Un albero quasi perfettamente bilanciato di altezza h è un albero perfettamente bilanciato fino a livello h-1
Un heap è un albero binario con le seguenti proprietà:
P. strutturale: quasi perfettamente bilanciato e le foglie a livello h sono aggiunte da sinistra verso destra; (addossate = non ci sono buchi)
P. di ordinamento: ogni nodo v ha la caratteristica che l’informazione ad esso associata
è la più grande tra tutte le informazioni presenti nel sottoalbero che ha v come radice.
L'ordinamento è effettuato tramite una chiave.

Le ADT Code a priorità sono composte da elementi chiamati entry, delle coppie (key, value),
dove key appartiene a K e value appartiene a V, due insiemi finiti non vuoti.
Su K è definita una relazione d'ordine totale <=.
Per convenzione, una entry E1 = (k1, v1) ha priorità su una entry E2 = (k2, v2) se k2 <= k1.
Le operazioni fondamentali sono inserimento (non importa l'ordine) e rimozione di una entry con priorità massima.

Un altro esempio di uso dello heap diverso dalle code a priorità è lo heap sort:
complessità n * log2 n (come merge sort) */

/*PRIORITYQUEUE è l'insieme delle code di priorità e, in particolare, lambda è la coda vuota
Verranno considerate solo le chiavi nel codice e, per semplicità, saranno degli interi*/

#include <stdio.h>
#include <stdlib.h>
#include "PQueue.h"
#define MAXPQ 50

struct c_PQ {
	int vet[MAXPQ];
	int numel;
};

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
	int temp, i = 1, n = q -> numel, pos;
	while(1) {
		if((2 * i) + 1 <= n)	//il nodo corrente ha 2 figli
			pos = (q -> vet[i * 2] > q -> vet[(i * 2) + 1]) ? i * 2 : (i * 2) + 1;
		else if(2 * i <= n) 	//il nodo corrente ha 1 figlio
			pos = 2 * i;
		else	//il nodo corrente non ha figli
			break;
		if(q -> vet[pos] > q -> vet[i]) {	//scambio le chiavi
			temp = q -> vet[i];
			q -> vet[i] = q -> vet[pos];
			q -> vet[pos] = temp;
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
	int temp, pos = q -> numel, i = pos/2;
	while (pos > 1) {
		if(q -> vet[pos] > q -> vet[i]) {
			temp = q -> vet[i];
			q -> vet[i] = q -> vet[pos];
			q -> vet[pos] = temp;
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
PQueue newPQ(void) {
	PQueue q = malloc(sizeof(struct c_PQ));
	if(q == NULL)
		return NULL;
	q -> numel = 0;
	return q;
}

/*PROGETTAZIONE DI emptyPQ
1. Verifico che la coda sia stata allocata
2. Se ci sono 0 elementi, restituisco 1, altrimenti restituisco 0
*/
int emptyPQ(PQueue q) {
	if(!q)
		return 1;
	return q -> numel == 0;
}

/*PROGETTAZIONE DI getMAX
1. Restituisco l'elemento di posto 1
*/
int getMAX(PQueue q) {
	return q -> vet[1];
}

/*PROGETTAZIONE DI deleteMAX
1. Verifico che la coda non sia vuota
2. Copio l'ultimo elemento nella posizione 1 e riduco il numero di elementi
3. Riordino lo heap (funzione separata)
*/
int deleteMax(PQueue q) {
	if((!q) || (q -> numel == 0))		//verifica che non sia vuota
		return 0;
	q -> vet[1] = q -> vet[q -> numel];		//porta l'ultimo elemento in posizione 1
	q -> numel --;
	scendi(q);	//rioridina lo heap
	return 1;
}

/*PROGETTAZIONE DI insert
1. Verifico che la coda non sia vuota
2. Inserisco l'elemento nell'ultima posizione e incremento il numero di elementi
3. Riordino lo heap(funzione separata)
*/
int insert(PQueue q, int key) {
	if((!q) || (q -> numel == MAXPQ))	//verifica che la coda non sia piena
		return 0;
	q -> numel ++;
	q -> vet[q -> numel] = key;		//inserisce in ultima posizione
	sali(q);	//riordina lo heap
	return 1;
}