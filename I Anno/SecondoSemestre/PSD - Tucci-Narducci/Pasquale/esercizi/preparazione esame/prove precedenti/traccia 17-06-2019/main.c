#include <stdlib.h>
#include "queue.h"
#include "item.h"


int presenteQ(queue Q, item el) {
    queue tmp = newQueue();
    int trovato = 0;
    while (!emptyQueue(Q))
    {
        item actual = dequeue(Q);
        enqueue(actual, tmp);

        if (eq(el, actual)) {
            trovato = 1;
        }
    }
    while (!emptyQueue(tmp))
    {
        enqueue(dequeue(tmp), Q);
    }
    return trovato;
}


item *queue_to_array(queue q, int *size) {
    queue tmp = newQueue();
    item *array;
    int dimensione;
    for (dimensione = 0; !emptyQueue(q); dimensione++) {
        enqueue(dequeue(q), tmp);
    }

    *size = dimensione;
    array = (item *) malloc(dimensione * sizeof(item));
    
    for (int i = 0; i < dimensione; i++) {
        array[i] = dequeue(tmp);
        enqueue(array[i], q);
    }

    free(tmp);
    return array;
}

int is_exclusive(item el, int array[], int size) {
    for (int i = 0; i < size; i++) {
        if (eq(el, array[i])) {
            return 0;
        }
    }
    return 1;
}

queue xorQ(queue q1, queue q2) {
    queue q3 = newQueue();
    int size1, size2;
    int *arr1, *arr2;
    arr1 = queue_to_array(q1, &size1);
    arr2 = queue_to_array(q2, &size2);

    for (int i = 0; i < size1; i++) {
        item current = arr1[i];
        if (is_exclusive(current, arr2, size2)) {
            enqueue(current, q3);
        }
    }

    free(arr1);
    free(arr2);
    return q3;
}



