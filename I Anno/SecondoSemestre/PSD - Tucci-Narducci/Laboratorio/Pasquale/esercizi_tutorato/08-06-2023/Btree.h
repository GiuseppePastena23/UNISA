// file Btree.h
#include "item.h"

typedef struct node *Btree;


// prototipi
Btree newBtree(void);
int emptyBtree(Btree T);
Btree figlioSX(Btree T);
Btree figlioDX(Btree T);
Btree consBtree(item val, Btree sx, Btree dx);
struct node *getRoot (Btree T);



// visita
void inorder(Btree T);


// input
Btree inputBtree();

Btree arrayToBtree(item values[], int start, int end);
void printBtree(Btree T, int depth);
