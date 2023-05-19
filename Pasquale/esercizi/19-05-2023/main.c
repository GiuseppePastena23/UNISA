#include <stdio.h>
#include <stdlib.h>
#include "item.h"
#include "Btree.h"

/*
Btree creazione_da_file(FILE *stream, int fermati) {
    item el;
    Btree root;
    if (fermati) {
        return NULL;
    }
    if (fscanf(stream, "%d", &el) == 0) {
        return NULL;
    }
    else {
        root = consBtree(el, creazione_da_file(stream, 1), 
                creazione_da_file(stream, 1));
    }
    return root;
}
*/

int conta_foglie(Btree tree) {
    if (emptyBtree(tree)) {
        return 1;
    }

    else {
        return conta_foglie(figlioSX(tree)) + conta_foglie(figlioDX(tree));
    }
}

int main(int argc, char const *argv[])
{
    /* code */
    return 0;
}
