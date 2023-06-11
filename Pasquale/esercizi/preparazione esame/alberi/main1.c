#include <stdio.h>
// #include "BST.h"
#include "Btree.h"

/*
void nodiInIntervallo(BST T, int A, int B)
{
    if(emptyBST(T)) return;
    nodiInIntervallo(figlioSX(T), A, B);
    if(getItem(T) >= A && getItem(T) <= B)
    {
        printf("%d ", getItem(T));
    }
    nodiInIntervallo(figlioDX(T), A, B);
    
}

void stampa_intervallo(BST T, int a, int b) {
    if (emptyBST(T)) return;
    item root = getItem(T);

    if (root >= a) {
        stampa_intervallo(figlioSX(T), a, b);  // GO LEFT
    }

    if (root >= a && root <= b)   
    {
        printf("%d, ", root);
    }

    if (root <= a) {
        stampa_intervallo(figlioDX(T), a, b); // GO RIGHT
    }

}
*/
/*

BST inputDaArray(int * array, int size)
{   
    BST T = newBST();
    for(int i = 0; i < size; i++)
    {
        insert(T, array[i]);
    }
}

BST nodiAdAltezzaK(BST T, int K)
{
    BST new = newBST();
    if(K == 0)
    {
        printf("%d ", getItem(T));
    }
    else
    {
        nodiAdAltezzaK(figlioSX(T), K - 1);
        nodiAdAltezzaK(figlioDX(T), K - 1);
    }
}

*/


int contaFoglie(Btree T)
{
    if(emptyBtree(T)) return 0;

    if(!figlioDX(T) && !figlioSX(T))
    {
        return 1;
    }
    else
    {
        return contaFoglie(figlioDX(T)) +  contaFoglie(figlioSX(T));
    }
}

int main()
{
    printf("Hello\n");
    Btree new = inputBtree();
    printf("%d", contaFoglie(new));
    printf("\n");
    return 0;
} 

/*
                8
        3               10
          24                 30 
                            5   6
*/