#include <stdio.h>
#include <stdlib.h>
#include "Btree.h"
#include "BST.h"
#include "item.h"

/*
Btree buildTree(item array[], int start, int end) {
    if (start >= end) {
        return NULL;
    }

    int mid = (start + end) / 2;
    item root_value = array[]
    Btree left = figlioSX()
}
*/



/*
Dato un albero binario di ricerca T i cui valori sono interi e due valori interi A e B (tale che A<B), 
stampare in ordine crescente tutti i nodi di T che sono compresi nell’intervallo [A, B] (estremi inclusi).
*/
void stampa_intervallo(BST T, int a, int b) {
    if (emptyBtree(T)) return;
    item root = getItem(getRoot(T));

    if (root < a) {
        stampa_intervallo(figlioDX(T), a, b); // GO RIGHT
    }

    if (root > a) {
        stampa_intervallo(figlioSX(T), a, b);  // GO LEFT
    }
    if (root > a && root < b)
        output_item(root);
}






Btree creazione_da_file(char *filename) {
    FILE *fp = fopen(filename, "r");
    if (fp == NULL) exit(EXIT_FAILURE);

    int max_size = 100;
    item arr[max_size];
    int size_arr;
    for (size_arr = 0; size_arr < max_size; size_arr++) {
        fscanf(fp, "%d", arr[size_arr]);
    }
    fclose(fp);

    return buildTree(arr, 0, size_arr);
}


int main(int argc, char const *argv[])
{
    /* code */
    return 0;
}
