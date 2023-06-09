#include <stdio.h>
#include <stdlib.h>
#include "PQueue.h"
#include "list.h"

item max(PQueue heap) {
    return getMax(heap);
}

item min(PQueue heap) {
    PQueue copia = newPQ();
    while (!emptyPQ(heap))
    {
        insertPQ(copia, getMax(heap));
        deleteMax(heap);
    }

    item minimo;
    item tmp;
    while ((tmp = getMax(copia)) != -1)
    {
        minimo = tmp;
        insertPQ(heap, minimo);
        deleteMax(copia);
    }
    free(copia);

    return minimo;
} 


void incremeneta_key(PQueue H, int K, int newK) {
    PQueue copia = newPQ();
    while (!emptyPQ(H))
    {
        int tmp = getMax(H);
        deleteMax(H);
        tmp = tmp == K ? newK : tmp;
        insertPQ(copia, tmp);
    }
    H = copia;
    free(copia);
} 


int *heapify(int *a, int size) {
    PQueue heap = newPQ();
    int *ordinato = (int *) malloc(size * sizeof(int));

    for (int i = 0; i < size; i++) {
        insertPQ(heap, a[i]);
    }

    for (int i = 0; i < size; i++)
    {
        ordinato[i] = getMax(heap);
        deleteMax(heap);
    }
    free(heap);
    return ordinato;
}








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
        insertPQ(dest, actual);
        insertList(tmp, sizeList(tmp), actual);
        deleteMax(src);
    }

    // restore src
    for (int i = 0; i < sizeList(tmp); i++) {
        insertPQ(src, getItem(tmp, i));
    }
    
    free(tmp);
}

PQueue merge(PQueue q1, PQueue q2) {
    PQueue q3 = newPQ();
    concatPQueue(q1, q3);
    concatPQueue(q2, q3);
    return q3;
}





void sequenza(char *stringa) {
    PQueue pq = newPQ();
    PQueue rimossi = newPQ();
    
    int i = 0;
    for (i = 0; stringa[i] != '\0'; i++) {
        if (stringa[i] == '*') {
            item tmp = getMax(pq);
            insertPQ(rimossi, tmp);
            deleteMax(pq);
        }
        else {
            insertPQ(pq, stringa[i]);
        }
    }

    while (!emptyPQ(rimossi))
    {
        printf("%c", getMax(rimossi));
        deleteMax(rimossi);
    }
}












/*
Nodi ad altezza k: Dato un albero binario di ricerca T i cui item sono interi e un intero k,
scrivere una funzione che restituisca tutti i nodi di T che hanno altezza k. 
L’output è una struttura dati a propria scelta.
*/


// contenitore già allocato
/*
list nodi_heightK(BST tree, int altezza, list contenitore) {
    if (emptyBST(tree)) {
        
    }
}
*/

int main(int argc, char const *argv[])
{
    sequenza("PRIO*R**I*T*Y***QUE***U*E");
    return 0;
}
