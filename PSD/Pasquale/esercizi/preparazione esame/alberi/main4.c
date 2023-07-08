#include <stdio.h>
#include <stdlib.h>

#include "BST.h"
#include "queue.h"
#include "item.h"


/*
SPECIFICA SINTATTICA:
NODI ALBERO (ALBERO BINARIO DI RICERCA, INTERO, INTERO) -> -
SPECIFICA SEMANTICA:
nodi_albero(BST T, int a, int b) -> void
PRECONDIZIONI:
a < b
POSTCONDIZIONI:
stampa delle etichette comprese tra a e b (estremi inclusi)
in ordine crescente

PROGETTAZIONE:
PASSO BASE: termino se l'albero è vuoto o nullo
PASSO RICORSIVO: 
1 stampo gli elementi compresi nel'intervallo dell'sottalb SX
2 stampo l'elemento della root se compreso nell'intervallo
3 stampo gli elementi compresi nel'intervallo dell'sottalb DX
*/
void nodi_albero(BST T, int a, int b) {
    if (T == NULL) return; 
    if (emptyBST(T)) return;

    nodi_albero(figlioSX(T), a, b);

    item etichetta = getRoot(T);
    if (etichetta >= a && etichetta <= b) {
        output_item(etichetta);
    } 

    nodi_albero(figlioDX(T), a, b);
}

// q != NULL
void nodi_h_k(BST t, int k, queue q) {
    if (emptyBST(t)) return;

    if (k == 0) {
        enqueue(getRoot(t), q);
    }

    nodi_h_k(figlioSX(t), k-1, q);
    nodi_h_k(figlioDX(t), k-1, q);
}

int conta_nodi_k(BST t, int k) {
    int contatore = 0;
    if (emptyBST(t) || t == NULL) return contatore;

    if (k == 0) {
        contatore = 1;
    }

    BST left = figlioSX(t);
    BST right = figlioDX(t);
    
    return contatore += conta_nodi_k(left, k-1) + conta_nodi_k(right, k-1);
}