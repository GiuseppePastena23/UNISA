#include <stdio.h>
#include <stdlib.h>

#include "item.h"
#include "list.h"

list interlaccia(list l1, list l2);

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
