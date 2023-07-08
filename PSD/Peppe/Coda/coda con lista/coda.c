#include <stdio.h>
#include <stdlib.h>
#include "coda.h"
#include "item.h"


struct node
{   item val;
    struct node *next;
};

struct c_queue
{   struct node *head, *tail; 
    int numEl; // numero di elementi nella coda
};

queue NewQueue(void)
{   struct c_queue *q = malloc(sizeof(struct c_queue));
    if(q == NULL)
        return NULL;
    
    q->numEl = 0;
    q->head = NULL;
    q->tail = NULL;
}

int EmptyQueue(queue q)
{
    if(q == NULL)
        return -1;

    return q->numEl == 0;
}

int InsertQueue(item val, queue q)
{   if(q == NULL) 
        return -1;
    
    struct node *new;
    new = malloc(sizeof(struct node));
    if(new == NULL)
        return 0;
    
    new->val = val;
    new->next = NULL;

    if(q->head==NULL) // se la testa della coda e' vuota 
        q->head = new;
    else 
        q->tail->next = new; // se la testa della coda non e' vuota
    
    q->tail = new; // la coda della queue punta al nuovo nodo
    (q->numEl)++;
    return 1;
}

item DeleteQueue(queue q)
{   if (q == NULL)
        return NULLITEM;
    if (q->numEl == 0)
        return NULLITEM;          // coda vuota
    item result = q->head->val; // item da restituire
    struct node *temp = q->head;  // nodo da rimuovere

    q->head = q->head->next; // q->head avanza
    free(temp);              // liberiamo memoria nodo da rimuovere
    if (q->head == NULL)     // se la coda conteneva un solo elemento
        q->tail = NULL;

    (q->numEl)--;
    return result;
}
