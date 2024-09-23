typedef struct c_PQ * PQueue;

/*ANALISI E SPECIFICA DI newPQ
newPQ() -> PRIORITYQUEUE
newPQ() -> PQ
precondizioni: Nessuna
postcondizioni: PQ = lambda
*/
PQueue newPQ();

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