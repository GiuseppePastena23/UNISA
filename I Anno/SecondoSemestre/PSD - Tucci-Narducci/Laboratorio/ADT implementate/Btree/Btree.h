#include <item.h>

typedef struct node *Btree;

//Iniziali:
//Crea un albero vuoto
Btree newBtree();

//Controlla se l'albero sia vuoto
int emptyBtree(Btree T);

//Restituiscono, rispettivamente, il figlio sinistro e il destro del nodo
Btree figlioSX(Btree T);
Btree figlioDX(Btree T);

//Crea un nodo radice che ha come etichetta un item val
Btree consBtree(item val, Btree sx, Btree dx);

//Restituisce la radice dell'albero
struct node *getRoot (Btree T);

//Funzioni utili:
item getItem(struct node *N);
void setItem(struct node *N, item el);

//Input dall'utente:
Btree inputBtree();

//Output secondo una delle possibili visite:
//Analizza prima la radice dell'albero, poi visita il sottoalbero sinistro ed infine il destro
void visitaPre(Btree T);
//Visita prima il sottoalbero sinistro, poi il destro ed infine analizza la radice dell'albero
void visitaPost(Btree T);
//Visita prima il sottoalbero sinistro, poi analizza la radice dell'albero ed infine visita il sottoalbero destro
void visitaInOrder(Btree T);

//Esercizi base:
int altezza(Btree T);
int numeroNodi(Btree T);