#include "Btree.h"

/*
SPECIFICA SINTATTICA
fratelli(Btree) -> int
SPECIFICA SEMANTICA
fratelli(Btree T) = N
pre: -
post: N contiene il numero di fratelli all'interno dell'albero

PROGETTAZIONE
1. controllo se il nodo T e' vuoto, se lo e' restituisco 0
2. controllo se il figlioDX e il figlioSX del nodo corrente non sono NULL
    2.1 restituisco 2 e richiamo la funzione per i figli del nodo T
3. se uno dei due nodi figlio e' vuoto o se sono entrambi vuoti 
    3.1 restituisco 0 e richiamo la funzione con i figli del nodo T
*/
int fratelli(Btree T)
{
    if(!getRoot(T))
    {
        return 0;
    }
    
    if(figlioDx(T) && figlioSX(T))
    {
        return 2 + fratelli(figlioDx(T)) + fratelli(figlioSX(T));
    }
    else
    {
        return 0 + fratelli(figlioDx(T)) + fratelli(figlioSX(T));
    }
}

