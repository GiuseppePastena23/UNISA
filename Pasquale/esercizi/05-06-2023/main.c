#include <stdio.h>
#include <stdlib.h>
#include "PQueue.h"
#include "list.h"
#include "list.c"
#include "BST.h"

/*
SPECIFICA SINTATTICA:
merge(coda con priorità, coda con priorità) -> coda con priorità

SPECIFICA SEMANTICA:
merge(PQueue q1, PQueue q2) -> PQueue q3

PRECONDIZIONI
q1 e q2 non nulla
q1 e q2 non devono avere elementi uguali
*/

// dest deve essere allocata
void concatPQueue(PQueue src, PQueue dest) {
    int actual;
    list tmp = newList();
    
    // riempio il nuovo
    while (!emptyPQ(src))
    {
        actual = getMax(src);
        insert(dest, actual);
        insertList(tmp, sizeList(tmp), actual);
        deleteMax(src);
    }

    // restore src
    for (int i = 0; i < sizeList(tmp); i++) {
        insert(src, getItem(tmp, i));
    }
    
    freeList(tmp);
}

PQueue merge(PQueue q1, PQueue q2) {
    PQueue q3 = newPQ();
    concatPQueue(q1, q3);
    concatPQueue(q2, q3);
    return q3;
}



/*
Nodi ad altezza k: Dato un albero binario di ricerca T i cui item sono interi e un intero k,
scrivere una funzione che restituisca tutti i nodi di T che hanno altezza k. 
L’output è una struttura dati a propria scelta.
*/


// contenitore già allocato
list nodi_heightK(BST tree, int altezza, list contenitore) {
    if (emptyBST(tree)) {
        
    }
}

int main(int argc, char const *argv[])
{
    /* code */
    return 0;
}
