#include <stdlib.h>
#include "PQueue.h"
#include "list.h"

list listKeys(PQueue pq) {
    PQueue tmp = newPQ();
    list lista = newList();

    for (int i = 0; !emptyPQ(pq); i++) {
        int el = getMax(pq);
        deleteMax(pq);
        insertList(lista, i, el);
        insert(tmp, el);
    }

    while (!emptyPQ(tmp))
    {
        insert(pq, getMax(tmp));
        deleteMax(tmp);
    }
    
    free(tmp);
    return lista;
}

void remGreatestKeys(PQueue pq, int k) {
    PQueue tmp = newPQ();

    while (!emptyPQ(pq))
    {
        int curr = getMax(pq);
        if (curr < k) {
            insert(tmp, curr);
        }
        deleteMax(pq);
    }

    while (!emptyPQ(tmp))
    {
        insert(pq, getMax(tmp));
        deleteMax(tmp);
    }
    
    free(tmp);  
}
