#include "list.h"

// FILE.H
/*
SPECIFICA SINTATTICA:
switch_a_coppie(lista) -> lista

SPECIFICA SEMANTICA:
switch_a_coppie(a) -> b

PRECONDIZIONI:
dimensione lista deve essere PARI

POSTCONDIZIONI:
b conterrà gli elementi di a con le coppie scambiate
*/
list switch_a_coppie(list a);

// FILE.C
/*
PROGETTAZIONE:
1.0 ottengo la dimensione di list a
2.0 per ogni elemento della lista, se esiste il suo successivo:
    2.1 inserisco il secondo elemento della coppia di a nella prima posizione disponibile di b
3.0 ritorno b
*/
list switch_a_coppie(list a) {
    int a_size = sizeList(a);
    // if (a_size % 2 != 0) return NULL;
    list b = newList();
    int posizione = 0;
    for (int i = 0; i+1 < a_size; i++)
    {
        i++;
        item el = getItem(a, i);
        insertList(b, posizione, el);
        i--;
        posizione++;
        el = getItem(a, i);
        insertList(b, posizione, el);
        posizione++;
        i++;
    }
    return b;
}

// -------------------------------------------------------------------

//bool
int rimuovi_centrale(list a) {
    int size = 0;
    list l1 = a;

    while (!emptyList(l1)) {
        l1 = tailList(l1);
        size++;
    }    

    return removeList(a, size/2); // ritorna vero se è stato effetivamente eliminato
}
