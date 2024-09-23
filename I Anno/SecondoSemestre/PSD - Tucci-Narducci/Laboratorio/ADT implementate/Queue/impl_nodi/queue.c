#include <stdio.h>
#include <stdlib.h>
#include "queue.h"
#include "item.h"

struct node {
	item value;
	struct node *next;
};

struct c_queue {	//nodo di intestazione
	struct node *head;
	struct node *tail;
	int numEl;		//numero di elementi presenti
};

queue newQueue() {
	struct c_queue *q;
	q = malloc(sizeof(struct c_queue));
	if(q == NULL) {
		return NULL;
	}
	else {
		q->head = NULL;
		q->tail = NULL;
		q->numEl = 0;
	}
	return q;
}

int emptyQueue(queue q) {
	if(q == NULL) {
		return -1;
	}
	else {
		return q->numEl == 0;
	}
}

int enqueue(queue q, item val) {
	if(q == NULL) {
		return -1;
	}
	struct node *new;
	new = malloc(sizeof(struct node));
	if(new == NULL) {
		return 0;
	}
	new->value = val;
	new->next = NULL;
	if(q->head == NULL) {	//coda vuota
		q->head = new;
	}
	else {
		q->tail->next = new;
	}
	q->tail = new;
	q->numEl = q->numEl + 1;
	return 1;
}

item dequeue(queue q) {
	if((q == NULL) || (q->numEl == 0)) {
		return NULLITEM;
	}
	item result = q->head->value;
	struct node *temp = q->head;
	q->head = q->head->next;
	free(temp);
	if(q->head == NULL) {	//nel caso ci fosse stato un solo elemento
		q->tail = NULL;
	}
	q->numEl = q->numEl - 1;
	return result;
}

item peek(queue q) {
	if((q == NULL) || (q->numEl == 0)) {
		return NULLITEM;
	}
	item result = q->head->value;
	return result;
}
