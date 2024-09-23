#include "main.h"
#include "item.h"
#include "coda.h"

/*
PROGETTAZIONE
1. salvo il valore in testa in una variabile e lo elimino
2. controllo se il valore salvato e' uguale ad el oppure se la coda e' vuota
    2.1 se una delle due condizioni e' verificata esco dalla funzione
3. altrimenti richiamo la funzione 
*/
void cancFinoItem(queue Q, item el)
{
    item temp = DeleteQueue(Q);

    if(eq(temp,el) || EmptyQueue(Q))
    {
        return;
    }
    else
    {
        cancFinoItem(Q, el);
    }
}

// non risolto
queue fondiDaItem(queue Q1, queue Q2, item el)
{
    queue newQ = NewQueue();
    queue tempQ = NewQueue();
    item temp1 = DeleteQueue(Q1);
    item temp2 = DeleteQueue(Q2);
    

    while(!eq(temp1, el))
    {
        temp1 = DeleteQueue(Q1);
        if(EmptyQueue(Q1)) return NULLITEM;
    }

    while(!eq(temp2, el))
    {
        temp2 = DeleteQueue(Q2);
        if(EmptyQueue(Q2)) return NULLITEM;
    }
    
    while(!EmptyQueue(Q1) || !EmptyQueue(Q2))
    {
    }
}



