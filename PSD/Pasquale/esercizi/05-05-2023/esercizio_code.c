#include "modules/queue.h"
#include "modules/item.h"

#include "stdio.h"


void interlaccia(queue q1, queue q2) {
    item partenza = peek(q1);
    item elemento_q1;
    do
    {
        elemento_q1 = dequeue(q1);
        enqueue(elemento_q1, q1);
        item elemento_q2 = dequeue(q2);
        enqueue(elemento_q2, q1);
        enqueue(elemento_q2, q2);

        elemento_q1 = peek(q1);
    } while (!eq(partenza, elemento_q1));
}

int main(int argc, char const *argv[]) {
    queue q1 = newQueue();
    queue q2 = newQueue();

    enqueue('a', q1);
    enqueue('b', q1);
    enqueue('c', q1);
    enqueue('d', q1);

    enqueue(1, q2);
    enqueue(2, q2);
    enqueue(3, q2);
    enqueue(4, q2);

    interlaccia(q1, q2);

    while (!emptyQueue(q1))
    {
        printf("%d\n", dequeue(q1));
    }

    while (!emptyQueue(q2))
    {
        printf("%d\n", dequeue(q2));
    }
    
    return 0;
}
