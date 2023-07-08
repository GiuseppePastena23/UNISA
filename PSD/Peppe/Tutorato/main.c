#include "main.h"
#include "item.h"
#include "list.h"



int itemFound(list L, item K)
{
    for(int i = 0; i < sizeList(L); i++)
    {
        if(eq(getItem(L, i), K))
        {
            return 1;
        }
    }
    return 0;
}


int conta_elementi(list L, item K)
{
    if(emptyList(L))
    {
        return 0;
    }
    int listSize = sizeList(L);
    int numEl= 0;

    for(int i = 0; i < sizeList; i++)
    {
        if(getItem(L, i) > K)
        {
            numEl++;
        }
    }
    return numEl;
}

/*
SPECIFICA SINTATTICA
itemFound(list, item) -> int
SPECIFICA SEMANTICA
itemFound(list L, item K) -> int N

pre: -
post: N sara' 1 se K e' presente in L


PROGETTAZIONE
3. con un ciclo for controlla tutti gli elementi della lista
4. se l'elemento in posizione i e' uguale a K restituisci 1 altrimenti alla fine del ciclo restituisci 0
*/
int itemFound(list L, item K)
{
    for(int i = 0; i < sizeList(L); i++)
    {
        if(eq(getItem(L, i), K))
        {
            return 1;
        }
    }
    return 0;
}

/*
SPECIFICA SINTATTICA
conta_elementi_non_ripetuti(list, item) -> int
SPECIFICA SEMANTICA
conta_elementi_non ripetuti(list L, item K) -> int N

pre: -
post: N conterra' il numero di elementi in L strettamente maggiori di K


PROGETTAZIONE
1. controlla se la lista e' vuota se lo e' restituisce 0
2. crea una nuova lista counted
3. con un ciclo for controlla tutti gli elementi della lista
4. se l'elemento in posizione i e' maggiore di K e non e' presente nella lista counted aumenta il contatore
numEl e inserisci l'item nella lista counted
5. libera lo spazio allocato per la lista counted e restituisci numEl
*/
int conta_elementi_non_ripetuti(list L, item K)
{
    if(emptyList(L))
    {
        return 0;
    }
    int listSize = sizeList(L);
    int numEl= 0;
    list counted = newList();
    int j = 0;

    for(int i = 0; i < sizeList; i++)
    {
        item currentItem = getItem(L, i);
        if(currentItem > K && !itemFound(counted, currentItem))
        {
            insertList(counted, j++, currentItem);
            numEl++;
        }
    }
    free(counted);
    return numEl;
}

