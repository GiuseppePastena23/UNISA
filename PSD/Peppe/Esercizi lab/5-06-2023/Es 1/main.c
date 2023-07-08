#include "PQueue.h"

/*
SPECIFICA SINTATTICA
merge(PQueue, PQueue) -> PQueue
SPECIFICA SEMANTICA 
merge(PQueue q1, PQueue q2) = PQueue q3
pre: q1 = <a0, a1, a2,..., bn>  q2 = <b0, b1, b2,..., bn>  
post:  q3 = <a0, b0, a1, b1, ..., an, bn>

PROGETTAZIONE
1. creo le code temporanee e la coda da restituire
2. un ciclo while fino a quando non viene svuotata la coda q1
    2.1 salvo il valore massimo nella variabile temporanea 
    2.2 inserisco la variabile temp nella coda temporanea QTemp1
    2.3 elimino il valore massimo in q1
3. un ciclo while fino a quando non viene svuotata la coda q2
    3.1 salvo il valore massimo nella variabile temporanea 
    3.2 inserisco la variabile temp nella coda temporanea QTemp2
    3.3 elimino il valore massimo in q2
4. un ciclo while fino a quando non viene svuotata la coda QTemp1
    4.1 salvo il valore massimo nella variabile temporanea 
    4.2 inserisco la variabile temp in q1 e in q3
    4.3 elimino il valore massimo in Qtemp1
5. un ciclo while fino a quando non viene svuotata la coda QTemp2
    5.1 salvo il valore massimo nella variabile temporanea 
    5.2 inserisco la variabile temp in q2 e in q3
    5.3 elimino il valore massimo in Qtemp2
6. libero la memoria allocata per le code temporanee
7. restituisco la lista q3
*/
PQueue merge(PQueue q1, PQueue q2);
{
    PQueue QTemp1 = newPQ();
    PQueue QTemp2 = newPQ();
    PQueue q3 = newPQ();
    int temp; 
    while(!emptyPQ(q1))
    {
        temp = getMAX(q1);
        insert(QTemp1, temp);
        deleteMax(q1);
    }
    
    while(!emptyPQ(q2))
    {
        temp = getMAX(q2);
        insert(QTemp2, temp);
        deleteMax(q2);
    }
    
    while(!emptyPQ(QTemp1))
    {
        temp = getMAX(QTemp1);
        insert(q1, temp);
        insert(q3, temp);
        deleteMax(QTemp1);
    }
    
    while(!emptyPQ(QTemp2))
    {
        temp = getMAX(QTemp2);
        insert(q2, temp);
        insert(q3, temp);
        deleteMax(QTemp2);
    }
    free(QTemp1);
    free(QTemp2);
    
    return q3;
}
