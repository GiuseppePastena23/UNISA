#include <stdlib.h>
#include "Btree.h"
#include "queue.h"
#include "stack.h"
#include "list.h"

/*
SPECIFICA SINTATTICA:
fratelli (albero binario) -> intero
SPECIFICA SEMANTICA:
fratelli(Btree T) -> int
PRECONDIZIONI:
    nessuna
POSTCONDIZIONI:
    ritorna il numero di fratelli in un Btree
    il Btree non viene modificato

PROGETTAZIONE
1. 
*/

int fratelli(Btree T) {
    if (!emptyBtree(T)) {
        return 0;
    }    
    
    
}



int speculare(queue q1, queue q2) {
    stack appoggio = newStack();
    int size_q1;
    for (size_q1 = 0; !emptyQueue(q1); size_q1++) {
        push(dequeue(q1), appoggio);
    }
    
    for (int i = 0; !emptyQueue(q2); i++)
    {
        if (appoggio)
    }
    





    // restore q1
}


item max_duplicati(list L) {
    list elementi = newList();
    list occorrenze = newList(); // di interi

    int sizeL = sizeList(L);
    for (int i = 0; i < sizeL; i++) {
        item actual = getItem(L, i);
        int posizione;
        if ((posizione = posItem(elementi, i)) == -1) {
            insertList(elementi, sizeList(elementi), actual);
            insertList(occorrenze, sizeList(elementi), 0);
        }
        else {
            getItem(occorrenze, posizione)
        }
        
    }
    
}



