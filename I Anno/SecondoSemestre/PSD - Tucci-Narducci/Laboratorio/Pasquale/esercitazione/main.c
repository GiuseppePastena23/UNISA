#include <stdio.h>
#include <stdlib.h>

#include "item.h"
#include "list.h"

list interlaccia(list l1, list l2);
void rimuovi_minimo(list l);

int main(int argc, char const *argv[]) {

    int upper_bound = 10;
    list pari = newList();
    list dispari = newList();

    for (int i = 0, j = -1; i < upper_bound; i++) {
        j++;
        insertList(pari, i, j);
        j++;
        insertList(dispari, i, j);
    }

    // outputList(pari);
    // outputList(dispari);
    list l3 = interlaccia(pari, dispari);


    rimuovi_minimo(l3);
   
    outputList(l3);

    return 0;
}

list interlaccia(list l1, list l2) {
    int size = sizeList(l1);
    if (size != sizeList(l2)) return NULL;

    list l3 = newList();
    for (int i = 0, j = 0; i < size; i++) {
        insertList(l3, j, getItem(l1, i));
        j++;
        insertList(l3, j, getItem(l2, i));
        j++;
    }
    return l3;
}


item get_minimum(list l) {
    item min = getFirst(l);
    l = tailList(l);
    for (;!emptyList(l); l = tailList(l)) {
        item el = getFirst(l);
        if (el < min) {
            min = el;
        }
    }
    return min;
}

void rimuovi_minimo(list l) {
    int size = sizeList(l);
    item min = get_minimum(l);
    for (int i = 0; i < size; i++)
    {
        if (eq(getItem(l, i), min)) {
            removeList(l, i);
        }
    }
}
