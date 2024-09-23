#include <stdio.h>
#include <stdlib.h>
#include "queue.h"
#include "item.h"


void cancFinoItem(queue q, item el) {
    while (!emptyQueue(q))
    {
        if (eq(el, dequeue(q))) {
            return;
        }
    }
}


/*
POSTCONDIZIONI:
q1 e q2 saranno modificate
*/


int *queueToArray(queue q, int *size) {
    queue copia = newQueue();
    int *array;
    int dimensione = *size;
    for (dimensione = 0; !emptyQueue(q); dimensione++) {
        enqueue(dequeue(q), copia);
    }

    array = (int *) malloc(sizeof(int) * dimensione);
    for (int i = 0; i < dimensione; i++)
    {
        array[i] = dequeue(copia);
        enqueue(array[i], q);
    }
    
    free(copia);
    *size = dimensione;
    return array;
}


queue fondiDaItem(queue Q1, queue Q2, item el) {
    queue newQ = newQueue();

    item val;
    while (!eq((val = dequeue(Q1)), el));
    val = NULLITEM;
    while (!eq((val = dequeue(Q2)), el));
    
    int size1, size2;
    int *array1 = queueToArray(Q1, &size1); 
    int *array2 = queueToArray(Q2, &size2); 

    for (int i = 0; i < size1; i++) {
        for (int j = 0; j < size2; j++) {
            if (eq(array1[i], array2[j])) {
                enqueue(array1[i], newQ);
            }
        }
    }
    
    free(array1);
    free(array2);
    return newQ;
}

int main(int argc, char const *argv[])
{
    /* code */
    return 0;
}

