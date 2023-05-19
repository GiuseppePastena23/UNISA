/* ALBERI 
- Costituiti da nodi che hanno un unico arco entrante tranne il nodo RADICE 
- Ogni nodo puo avere zero o piu archi uscenti
- i nodi senza archi uscenti sono detti FOGLIE
- il numero di figli di un nodo e' detto GRADO di un nodo
- il CAMMINO e' la sequenza di nodi che porta dalla radice dell'albero ad un nodo
- il LIVELLO di un nodo e' la lunghezza del cammino dalla radice al nodo (DEFINIZIONE RICORSIVA) livello della radice = 0, livello di un nodo = 1 + livello del padre
- l'ALTEZZA di un albero e' la lunghezza del piu lungo cammino dell'albero
- in un albero di ordine K ogni nodo ha al massimo K figli
- un SOTTOALBERO e' composto dai discendenti di un nodo u 
- un ALBERO BINARIO e' un albero in cui i nodi possono avere al massimo due figli che distinguono in figlioSx e figlioDx  
- un albero binario e' costruito in maniera bottom-up
*/
#include "item.h"
 
typedef struct node *Btree;

// prototipi

/*
Scopo: Crea un albero vuoto

SPECIFICA SINTATTICA 
    newBtree(void) -> Btree
SPECIFICA SEMANTICA
    Btree newBtree(void) = T
    pre: -
    post: T = ^
*/
Btree newBtree(void);
    
/*
Scopo: Controlla se l'albero e' vuoto
 
SPECIFICA SINTATTICA 
    emptyTree(Btree) -> int
SPECIFICA SEMANTICA
    int emptyBtree(Btree T) = v
    pre: -
    post: se T e' vuoto, allora v = vero, altrimenti v = falso
*/                      
int emptyBtree(Btree T);

/*
Scopo: Restituisce il figlio sinistro del nodo 

SPECIFICA SINTATTICA 
    figlioSX(Btree) -> Btree
SPECIFICA SEMANTICA
    Btree figlioSX(Btree T) = T'
    pre: T = <N, Tsx, Tdx> non e' l'albero vuoto
    post: T' = Tsx
*/
Btree figlioSX(Btree T);

/*
Scopo: Restituisce il figlio destro del nodo 

SPECIFICA SINTATTICA 
    figlioDX(Btree) -> Btree
SPECIFICA SEMANTICA
    Btree figlioDX(Btree T) = T'
    pre: T = <N, Tsx, Tdx> non e' l'albero vuoto
    post: T' = Tdx
*/
Btree figlioDx(Btree T);

/*
Scopo: crea un nodo radice che ha come etichetta un valore 

SPECIFICA SINTATTICA 
    consBtree(item, Btree, Btree) -> Btree
SPECIFICA SEMANTICA
    Btree consBtree(item val, T1, T2) = T'
    pre: elem != NULLITEM
    post: T' = <N, T1, T2> N e' un nodo con etichetta N
*/
Btree consBtree(item val, Btree sx, Btree dx);

/*
Scopo: Restituisce la radice dell'albero

SPECIFICA SINTATTICA 
    getRoot(Btree) -> node
SPECIFICA SEMANTICA
    Btree getRoot(Btree T) = N'
    post: T' = Ts
*/
node *getRoot(Btree T);   

Btree inputBtree(void);

// ALGORITMI DI VISITA

/* PRE-ORDINE: analizza la radice dell'albero e poi i due sottoalberi prima il sx e poi il destro
   POST-ORDINE: richiede la visita dei sottoalberi(prima sx e poi dx) e in seguito l'analisi della radice
   SIMMETRICA: richiede la visita del sottoalbero sx poi analisi della radice e poi la visita del sottoalbero destro
*/

void visitaPre(Btree T);
void visitaPost(Btree T);
void visitaInOrder(Btree T);

// ESERCIZI 

int altezza(Btree T);

int numeroNodi(Btree T);
