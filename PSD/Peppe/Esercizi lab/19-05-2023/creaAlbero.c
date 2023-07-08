#include "creaAlbero.h"
#include "Btree.h"
#include"stdio.h"

Btree creaAlbero(FILE *f)
{
    f = fopen("valori.txt", "r");   
    Btree T;
    T = inputBtree_file(f);
    
}

Btree inputBtree_file(FILE *f)
{
    Btree T1, T2;
    item el;
    fscanf(f, "%d", &el);
    while(!feof(f))
    {
        T1 = inputBtree_file(f);
        T2 = inputBtree_file(f);
    }
    return consBtree(el, T1, T2);
}