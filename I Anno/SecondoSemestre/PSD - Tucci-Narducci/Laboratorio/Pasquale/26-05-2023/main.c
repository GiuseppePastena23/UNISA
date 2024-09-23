#include <stdio.h>
#include <stdlib.h>

#include "item.h"
#include "BST.h"
#include "Btree.h"


#define bool int
#define true 1
#define false 0

/*
bool isBST(Btree tree) {
    item root_value = getItem(tree);
    item left_figlio_value = getItem(figlioSX(tree));
    item right_figlio_value = getItem(figlioDX(tree));
    /*
    if (left_figlio_value == NULL && right_figlio_value == NULL) return true;
    if ((minore(left_figlio_value, root_value) || left_figlio_value == NULL) && (!minore(right_figlio_value, root_value) || right_figlio_value == NULL)) {
        return isBST(figlioSX(tree)) && figlioDX(tree);
    }
    

    // Caso base
    if (left_figlio_value == NULL && right_figlio_value == NULL) {
        return true;
    }

    // passo ricorsivo 
    return 0;
}
*/


void funzione(BST tree, int A, int B) {
    if (tree == NULL) return;

    int el = getItem(tree);
    
    
}



int main(int argc, char const *argv[])
{
    printf("%d\n", true && false);
    return 0;
}

