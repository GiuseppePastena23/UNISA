#include <stdio.h>
#include <stdlib.h>
#include "Btree.h"
#include "queue.h"

int somma_albero(Btree T) {
    if (emptyBtree(T)) {
        return 0;
    }

    int root = 0, left = 0, right = 0;
    root = getItem(T);
    if (figlioSX(T) != NULL)
        left = somma_albero(figlioSX(T));
    if (figlioDX(T) != NULL)
        right = somma_albero(figlioDX(T));
    
    // somma del dio porco ammessa
    return root + left + right;
}

// precond T != NULL
int uguale_somma_sx_dx(Btree T) {
    if (emptyBtree(T)) {
        return 1;
    }

    int left = somma_albero(figlioSX(T));
    int right = somma_albero(figlioDX(T));
    return left == right;
}


// precon q != null
int vicini(queue q, int a, int b) {
    int contatore = 0;
    queue tmp = newQueue();
    item el;
    while (emptyQueue(q))
    {
        el = dequeue(q);
        enqueue(el, tmp);

        if (eq(el, a)) {
            item next = dequeue(q);
            enqueue(next, tmp);

            if (eq(next, b)) {
                contatore++;
            }
        }
    }
    
    while (emptyQueue(tmp))
    {
        enqueue(dequeue(tmp), q);
    }
    
    // libera tmp
    return contatore;
}
