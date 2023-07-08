/*
1) Fogliek(Btree T, int k)
La funzione conta il numero di foglie (se presenti) al livello , restituendolo

2) void PriorityQueueIncrease (Pqueue q)
La funzione incrementa di 1 la priorità di tutti gli elementi ESCLUSO il primo. La coda q (a fine esecuzione) deve contenere il primo elemento + tutti gli altri elementi con priorità +1.

3) BOOL strutturalmenteSimili(Btree T1, Btree T2)
Restituisce true (1) o false (0) se gli alberi sono o meno strutturalmente simili
*/

#include <stdlib.h>

#include "Btree.h"
#include "PQueue.h"

int isFoglia(T) {
    return emptyBtree(figlioSX(T)) && emptyBtree(figlioDX(T));
}

int foglieK(Btree T, int k) {
    if (emptyBtree(T)) return 0;

    int contatore = (k == 0 && isFoglia(T)) ? 1 : 0;
    contatore += foglieK(figlioSX(T), k-1);
    contatore += foglieK(figlioDX(T), k-1);

    return contatore;
}


void priorityQueueIncrease(PQueue q) {
    PQueue tmp = newPQ();
    int flag_primo = 0;
    while (!emptyPQ(q))
    {
        if (!flag_primo) // se l'elemento è il primo
        {
            insert(tmp, getMax(q));
            flag_primo = 1;
        }
        else {
            insert(tmp, getMax(q)+1); // aumento la priorità (non il valore associato)
        }
        
        deleteMax(q);
    }
    
    while (!emptyPQ(tmp))
    {
        insert(q, getMax(tmp));
        deleteMax(tmp);
    }
    
    free(tmp);   
}



int strutturalmenteSimili(Btree T1, Btree T2) {
    if (emptyBtree(T1) && emptyBtree(T2)) return 1;
    return strutturalmenteSimili(figlioSX(T1), figlioSX(T2)) && strutturalmenteSimili(figlioDX(T1), figlioDX(T2));
}
