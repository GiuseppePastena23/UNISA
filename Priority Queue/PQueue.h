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

typedef struct c_PQ * PQueue;

/*ANALISI E SPECIFICA DI newPQ
newPQ() -> PRIORITYQUEUE
newPQ() -> PQ
precondizioni: Nessuna
postcondizioni: PQ = lambda
*/
PQueue newPQ(void);

/*ANALISI E SPECIFICA DI emptyPQ
emptyPQ(PRIORITYQUEUE) -> BOOLEAN
emptyPQ(PQ) -> v
precondizioni: Nessuna
postcondizioni: se PQ è vuota, allora v è vera, altrimenti v è falsa
*/
int emptyPQ(PQueue q);

/*ANALISI E SPECIFICA DI getMax
getMax(PRIORITYQUEUE) -> ITEM
getMax(PQ) -> elem
precondizioni: PQ non è vuota
postcondizioni: elem è la entry con massima priorità fra quelle contenute in PQ
*/
int getMax(PQueue q);

/*ANALISI E SPECIFICA DI deleteMax
deleteMax(PRIORITYQUEUE) -> PRIORITYQUEUE
deleteMax(PQ) -> PQ'
precondizioni: PQ non è vuota
postcondizioni: PQ' si ottiene da PQ rimuovendo la entry con priorità massima
*/
int deleteMax(PQueue q);

/*ANALISI E SPECIFICA DI insert
insert(PRIORITYQUEUE, ITEM) -> PRIORITYQUEUE
insert(PQ, elem) -> PQ'
precondizioni: Nessuna
postcondizioni: PQ' contiene elem e tutte le entry di PQ
*/
int insert(PQueue q, int key);