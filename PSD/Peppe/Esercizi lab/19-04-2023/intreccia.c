/* 
PROGETTAZIONE 
1. Date due liste list A, list B
   Controllo che abbiano la stessa lunghezza altrimenti termino restituendo una lista vuota
2. Creo una nuova lista list C, inizialmente vuota 
3. inizializza j a 0 per i da 0 a m-1
   inserisci in list C in posizione j l'elemento i-esimo di list A e incrementa j
   inserisci in list C in posizione j l'elemento i-esimo d list B e incrementa j
4. restituisci list C 
*/

#include "list.h"
#include "item.h"
#include <stdio.h>

list intreccia(list A, list B)
{
    int m, i = 0;    
    item val;

    list C = newList();

    if((m = sizeList(A)) != sizeList(B))
        return C;

    for(i = m; i >= 0; i--)
    {
        val = getItem(B, i);
        insertList(C, 0, val);
        val = getItem(A, i);
        insertList(C, 0, val);
    }  
    return C;       
}

