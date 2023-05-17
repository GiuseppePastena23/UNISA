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
