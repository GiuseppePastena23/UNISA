/*
CODA 
sequenza di elementi di un determinato tipo, in cui gli elementi si aggiungono
da un lato(coda) e si tolgono dall'altro(testa)
E' una struttura dati lineare a dimensione variabile a cui si puo accedere solo 
alla testa
*/

// IMPLEMENTAZIONE CON  LISTA 

#include "item.h"

typedef struct c_queue *queue;

// prototipi

// Crea una nuova coda
queue newQueue(void);

// Controlla se la coda e' vuota o meno
int emptyQueue(queue q);

// Rimuovi e restituisci l'elemento in testa alla coda
item dequeue(queue q); 

// Inserisci un nuovo elemento in testa alla coda
int enqueue(item val, queue q);

// restituisce il primo elemento in coda
item peek(queue q);
