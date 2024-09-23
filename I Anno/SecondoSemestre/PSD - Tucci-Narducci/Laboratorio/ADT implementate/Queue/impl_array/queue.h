#include "item.h"

typedef struct c_queue *queue;

//Crea una nuova coda
queue newQueue();

//Controlla se la coda sia vuota o meno
int emptyQueue(queue q);

//Rimuove e restituisce l'elemento in testa alla coda
item dequeue(queue q); 

//Inserisce un nuovo elemento in testa alla coda
int enqueue(queue q, item val);

//Restituisce il primo elemento in coda, senza rimuoverlo
item peek(queue q);
