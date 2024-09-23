#include <stdio.h>
#include <stdlib.h>
#include "Btree.h"
#include "stack.h"

void printBtree(Btree albero, int livello)
{
    item val;
    if (emptyBtree(albero))
        return;

    for (int i = 0; i < livello; i++)
    {
        printf("|   ");
    }

    if (livello > 0)
    {
        printf("|-- ");
    }

    val = getItem(getRoot(albero));
    output_item(val);
    printf("\n");
    printBtree(figlioSX(albero), livello + 1);
    printBtree(figlioDX(albero), livello + 1);
}

void stampaAlbero(Btree albero)
{
    printBtree(albero, 0);
}

// int conta_nodi_fino_a_k(Btree T, int k) 
int cnfak(Btree T, int k){
    if (emptyBtree(T)) return 0;

    int contatore = 0;
    if (k >= 0) {
        contatore++;
    }

    contatore += cnfak(figlioSX(T), k-1);
    contatore += cnfak(figlioDX(T), k-1);
    return contatore;
}

// rimuovi minimo da uno stack (tutte le occorrenze) 
void rimuovi_minimo(stack s) {
    stack tmp_reverse = newStack();
    item min = top(s); 

    while (!emptyStack(s))
    {
        item el = top(s);
        if (el < min) {             // minore(el ,min)
            min = el;
        }
        
        push(el, tmp_reverse);
        pop(s);
    }

    while (!emptyStack(tmp_reverse))
    {
        item el = top(tmp_reverse);
        if (!eq(el, min)) {
            push(el, s);
        }
    }   

    free(tmp_reverse);
}


int main()
{
    
    return 0;
}
