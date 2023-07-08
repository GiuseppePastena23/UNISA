/*
Considerate L una lista di item, con item di tipo intero. 
Scrivete una funzione tale che se richiamata su L restituisca un ITEM 
(attenzione, non l'intero bensì l'ITEM) che contiene al suo interno il valore intero minimo.
*/

#include <stdio.h>
#include <stdlib.h>
#include "item.h"
#include "list.h"

/*
SPECIFICA SINTATTICA:
SPECIFICA SEMANTICA:
PRECONDIZIONE:
    -
POSTCONDIZIONE:
min = smallest item in list

PROGETTAZIONE:
1.0 controllo se L sia nullo
    se così fosse ritorno un item nullo
2.0 inizializzo min all'item più alto
3.0 per ogni elemento della lista
    3.1 lo confronto con min
        3.2 se l'elemento è minore di min
            3.3 il nuovo minimo è l'i-esimo elemento
4.0 ritorno min
*/

item minimoLista(list L) {
    if (L == NULL) return NULLITEM;
    item min = MAXITEM;
    int size = sizeList(L);
    for (int i = 0; i < size; i++) {
        item el = getItem(L, i);
        if (minore(el, min)) {
            min = el; // se possibile, altrimenti clone() o copia() (?)
        }
    }
    return min;
}
