#include <stdio.h>
#include <stdlib.h>

#include "Btree.h"
#include "item.h"

struct node
{
    item value;
    struct node *left;
    struct node *right;
};

item getItem(struct node *N);
void setItem(struct node *N, item el);

item getItem(struct node *N)
{
    if (N == NULL)
        return NULLITEM;
    return N->value;
}

void setItem(struct node *N, item el)
{
    if (N == NULL)
        return;
    N->value = el; // correttezza di "=" dipende dal tipo item
}

Btree newBtree(void)
{
    return NULL;
}

int emptyBtree(Btree T)
{
    return T == NULL;
}

struct node *getRoot(Btree T)
{
    return T;
}

Btree consBtree(item val, Btree sx, Btree dx)
{
    struct node *nuovo;
    nuovo = malloc(sizeof(struct node));
    if (nuovo != NULL)
    {
        setItem(nuovo, val);
        nuovo->left = sx;
        nuovo->right = dx;
    }
    return nuovo;
}

Btree figlioSX(Btree T)
{
    if (T != NULL)
        return T->left;
    else
        return NULL;
}

Btree figlioDX(Btree T)
{
    if (T != NULL)
        return T->right;
    else
        return NULL;
}

void inorder(Btree T)
{
    if (emptyBtree(T))
        return;
    inorder(figlioSX(T));
    output_item(getItem(getRoot(T)));
    inorder(figlioDX(T));
}

Btree inputBtree()
{
    int is_empty;
    printf("L'albero e' vuoto? (1/0)\n>");
    scanf("%d", &is_empty);

    if (is_empty)
    {
        return newBtree();
    }

    item el;
    Btree T1, T2;
    printf("Inserisci la radice: ");
    input_item(&el);

    printf("Costruisco il sottoalbero SX\n");
    T1 = inputBtree();
    printf("Costruisco il sottoalbero DX\n");
    T2 = inputBtree();

    return consBtree(el, T1, T2);
}

// FUNZIONI UTILI
/*
Dato un array, crea l'albero
Btree arrayToBtree(item values[], int start, int end) {
    if (start > end) {
        return NULL;
    }
    
    int mid = (start + end) / 2;
    item el = values[mid];
    Btree t1 = arrayToBtree(values, start, mid-1);
    Btree t2 = arrayToBtree(values, mid+1, end);
    return consBtree(el, t1, t2);
}
*/
