#include "BST.h"
#include <stdio.h>

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

int main()
{
    BST new = newBST();

    new = insert(new, 51);
    new = insert(new, 5);
    new = insert(new, -1);
    new = insert(new, 23); 
    new = insert(new, 0); 
    new = insert(new, -3); 
    new = insert(new, 12); 
    new = insert(new, 46); 
    new = insert(new, 78); 
    new = insert(new, 64); 
    new = insert(new, 60); 
    new = insert(new, 70); 
    new = insert(new, 86); 
    new = insert(new, 83); 
    new = insert(new, 92); 

    BST new2 = nodiAdAltezzaK(new, 1);
    
    
}