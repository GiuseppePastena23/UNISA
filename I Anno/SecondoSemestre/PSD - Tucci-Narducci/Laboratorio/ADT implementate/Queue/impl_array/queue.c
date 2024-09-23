#include <stdio.h>
#include <stdlib.h>
#include "queue.h"
#include "item.h"

#define MAXQUEUE 100	//dimensione massima di default

struct c_queue {
	item *vet;
	int size;
	int head;
	int tail;
};

queue newQueue() {
	struct c_queue *q;
	q = malloc(sizeof(struct c_queue));
	if(q == NULL) {
		return NULL;
	}
	q->vet = malloc(MAXQUEUE * sizeof(item));
	if(q->vet == NULL) {
		free(q);
		return NULL;
	}
	q->size = 0;
	q->head = 0;
	q->tail = 0;
	return q;
}

int emptyQueue(queue q) {
	if(q == NULL) {
		return -1;
	}
	return (q->size == 0);
}

int enqueue(queue q, item val) {
	if(q == NULL) {
		return -1;
	}
	if(q->size == (MAXQUEUE - 1)) {	//coda piena
		return 0;
	}
	q->vet[q->tail] = val;
	q->tail = (q->tail + 1) % MAXQUEUE;	//gestione circolare
	q->size = q->size + 1;
	return 1;
}

item dequeue(queue q) {
	if((q == NULL) || (q->size == 0)) {
		return NULLITEM;
	}
	item result = q->vet[q->head];
	q->head = (q->head + 1) % MAXQUEUE;	//gestione circolare
	return result;
}

item peek(queue q) {
	if((q == NULL) || (q->size == 0)) {
		return NULLITEM;
	}
	item result = q->vet[q->head];
	return result;
}
