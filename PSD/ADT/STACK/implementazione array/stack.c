// VERSIONE STACK CON ARRAY
#include "stack.h"

#include <stdio.h>
#include <stdlib.h>

#include "item.h"

#define STARTSIZE 50  // dimensione iniziale dello stack
#define ADDSIZE 20    // dimensione da aggiungere se pieno

struct c_stack {
    item *vet;  // array di elementi
    int size;   // dimensione corrente dell'array
    item top;   // posizione successiva all'elemento in cima e quindi il numero di elementi nello stack
};

stack newStack(void) {
    stack s = malloc(sizeof(struct c_stack));
    if (s == NULL) {
        return NULL;
    }
    s->vet = malloc(STARTSIZE * sizeof(item));
    if (s->vet == NULL) {
        return NULL;
    }
    s->size = STARTSIZE;
    s->top = 0;
    return s;
}

int emptyStack(stack s) {
    return s->top == 0;
}

int push(item val, stack s) {
    if (s->top == s->size)  // necessario il resizing
    {
        item *tmp = realloc(s->vet, (s->size + ADDSIZE) * sizeof(item));
        if (tmp == NULL) {
            return 0;
        }
        s->vet = tmp;
        s->size += ADDSIZE;
    }
    s->vet[s->top] = val;
    (s->top)++;
    return 1;
}

int pop(stack s) {
    if (s->top == 0) {
        return 0;
    }
    (s->top)--;
    return 1;
}

item top(stack s) {
    item e;
    if (s->top > 0) {
        e = s->vet[s->top - 1];
    } else {
        e = NULLITEM;
    }
    return e;
}
