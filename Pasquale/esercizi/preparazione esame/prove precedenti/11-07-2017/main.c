#include <stdlib.h>
#include "queue.h"

void estraiMaxN(queue q, int n) {
    queue tmp = newQueue();
    int max = -99999;
    for (int i = 0; !emptyQueue(q); i++) {
        item el = dequeue(q);
        enqueue(el, tmp);
        if (i < n && max < el) {
            max = el;
        }
    }

    for (int i = 0; !emptyQueue(tmp); i++) {
        item el = dequeue(tmp);
        if (!(i < n && eq(el, max))) {
            enqueue(el, q);
        }
    }

    free(tmp);    
}
