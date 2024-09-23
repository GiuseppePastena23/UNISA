
#include "BST.h"



/*
Aggiungere nella specifica e nella realizzazione di BST un operatore booleano che dati un BST t e un intero k non negativo,
restituisca vero se t è k-bilanciato, falso altrimenti.
Un albero binario si dice k-bilanciato se per ogni nodo accade che la differenza (in valore assoluto)
tra le altezze dei suoi due sottoalberi è minore o uguale a k.
*/

// precond k>=0
int altezzaAlbero(BTree b){
    if (emptyBtree(b))
        return 0;
    
    int l = altezzaAlbero(figlioSX(b));
    int r = altezzaAlbero(figlioDX(b));
        if (l > r)
            return l + 1;
        else
            return r + 1;
}

int k_bilanciato(BST t, int k){
    if(emptyBST(t)) return 1;
    int h_tSX = altezzaAlbero(figlioSX(t));
    int h_tDX = altezzaAlbero(figlioDX(t));

    if(abs(h_tSX - h_tDX) <= k &&  k_bilanciato(figlioSX(t), k) && k_bilanciato(figlioDX(t), k)){
        return 1;

    return 0;
}   