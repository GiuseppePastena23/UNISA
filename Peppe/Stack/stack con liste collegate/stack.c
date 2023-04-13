// VERSIONE STACK CON ARRAY
#include <stdio.h>
#include <stdlib.h>
#include "item.h"
#include "stack.h"

#define STARTSIZE 50 // dimensione iniziale dello stack
#define ADDSIZE 20 // dimensione da aggiungere se pieno

struct node
{   item value;
    struct node *next;
};

struct c_stack
{   
    struct node *top;
    int numel; // numero di elementi
};

stack NewStack(void)
{   stack s = malloc(sizeof(struct c_stack));
    if(s == NULL)
    {   return NULL;
    }
    s->numel = 0;
    s->top = NULL;
    return s;
}

int EmptyStack(stack s)
{   return s->numel == 0;
}

int push(item val, stack s)
{   struct node *new;
    new = malloc(sizeof(struct node));

    if(new == NULL)
    {   return 0;
    }
    
    new->value = val;
    new->next = s->top;
    s->top = new;
    (s->numel)++;

    return 1;
}

int pop(stack s)
{   if (s->numel == 0)
    {   return 0;
    }
    struct node *temp = s->top;
    s->top = s->top->next;
    free(temp);
    (s->numel)--;
    return 1;
}

item top(stack s)
{   item e;
    if(s->numel > 0)
    {   e = s->top->value;
    }
    else
    {   e = NULLITEM;
    }
    return e;
}

