#include <stdio.h>
#include <stdlib.h>
#include "Btree.h"
#include "stack.h"

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



item *stack_to_array(stack s, int *size) {
    int *array;
    int dimensione = 0;
    stack tmp = newStack();
    while (!emptyStack(s))
    {
        push(top(s), tmp);
        pop(s);
        dimensione++;
    }

    array = (item *) malloc(dimensione * sizeof(item));
    *size = dimensione;

    for (int i = 0; i < dimensione; i++) {
        item el = top(tmp);
        pop(tmp);
        array[i] = el;
        push(el, s); 
    }

    free(tmp);
    return array;
}

void merge(stack s1, stack s2) {
    int size1 = 0, size2 = 0;
    item *arr1 = stack_to_array(s1, &size1);
    item *arr2 = stack_to_array(s2, &size2);

    int meta = size1 / 2;
    while (!emptyStack(s1)) pop(s1);

    int j = size2;
    for (int i = size1 - 1; i >= 0; i--) {
        if (i == meta) {
            push(arr2[j], s1);
            j--;
            i++;
        }
        else {
            push(arr1[i], s1);
        }
    }
    
    free(arr1);
    free(arr2);
}


int main(int argc, char const *argv[])
{
    /* code */
    return 0;
}
