#include <stdio.h>
#include <stdlib.h>
#include "Btree.h"

int figli_unici(Btree T) {
    int contatore = 0;
    if (emptyBtree(T)) return 0;

    Btree left = figlioSX(T);
    Btree right = figlioDX(T);
    if (emptyBtree(left) || emptyBtree(right)) {
        contatore++;
    }

    contatore += figli_unici(left);
    contatore += figli_unici(right);

    return contatore;
}





int main(int argc, char const *argv[])
{
    return 0;
}

