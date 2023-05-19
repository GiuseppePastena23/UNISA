#include <stdio.h>
#include <stdlib.h>
#include "item.h"
#include "Btree.h"

struct node
{
    item value; /* etichetta del nodo */
    struct node *left; /* puntatore sottoalbero sinistro */
    struct node *right; /* puntatore sottoalbero destro */
}

/* 
SPECIFICA SINTATTICA 
    item getItem(node) -> node 
SPECIFICA SEMANTICA 
    item getItem(node *N) = N'
    pre: -
    post: N' = valore di N
*/
item getItem(node *N);


/* 
SPECIFICA SINTATTICA 
    void setItem(node, item) -> node 
SPECIFICA SEMANTICA 
    void setItem(node *N, item el) = N
    pre: -
    post: valore di n = el
*/
void setItem(node *N, item el);

int max(int n1, int n2);

int max(int n1, int n2)
{
    return n1 > n2 ? n1 : n2;
}


item getItem(node *N)
{
    if(N == NULL)
    {
        return NULLITEM;
    }
    
    return N->value;
}

void setItem(node *N, item el)
{
    if (N==NULL) return;
    N->value = el; 
}

Btree newBtree(void)
{
    return NULL;
}

int emptyBtree(Btree T)
{
    return T == NULL;
}

node *getRoot(Btree T)
{
    return T;
}

Btree consBtree(item val, Btree sx, Btree dx)
{
    struct node *new;
    new = malloc(sizeof(struct node));
    if(new != NULL)
    {
        setItem(new, el);
        new->left = sx;
        new->right = dx;
    }
    return new;
}

Btree figlioSX(Btree T)
{
    if(T != NULL) return T->left;
    else return NULL;
}

Btree figlioDX(Btree T)
{
    if(T != NULL) return T->right;
    else return NULL;
}

void visitaPre(Btree T)
{
    if(emptyBtree(T)) return;
    visitaPre(getRoot(T));
    visitaPre(figlioSX(T));
    visitaPre(figlioDX(T));
    return;
}

void visitaInOrder(Btree T)
{
    if(emptyBtree(T)) return;
    visitaInOrder(figlioSX(T));
    OutputItem(getItem(getRoot(T)));
    visitaInOrder(figlioDX(T))
}

void visitaPost(Btree T);
{
    if(emptyBtree(T)) return;
    visitaPost(figlioSX(T));
    visitaPost(figlioDX(T));
    OutputItem(getItem(getRoot(T)));
}

Btree inputBtree(void)
{
    Btree T1, T2;
    int ris;
    item el;
    printf("\nL'albero è vuoto? (1/0): ");
    scanf("%d", &ris);
    if (ris) return newBtree();
    printf("\nInserisci la radice: ");
    input_item(&el);
    printf ("costruisco il sottoalbero SX\n");
    T1 = inputBtree();
    printf ("costruisco il sottoalbero DX\n");
    T2 = inputBtree();
    return consBtree(el, T1, T2);
}

// ESERCIZI


int altezza(Btree T)
{
    if(emptyBtree(T)) return 0;

    return 1 + max(altezza(figlioSX(T)), altezza(figlioDX(T)));
} 

int numeroNodi(Btree T)
{
    if(emptyBtree(T)) return 0;

    return 1 + numeroNodi(figlioDX(T)) + numeroNodi(figlioSX(T));
}
