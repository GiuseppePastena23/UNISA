#include <stdio.h>
#include <stdlib.h>
#include "stack.h"
#include "item.h"

struct node {
	item value;
	struct node *next;
};

struct c_stack {
	struct node *top;
	int numEl;
};

stack newStack() {
	stack s;
	s = malloc(sizeof(struct c_stack));
	if(s == NULL) {
		return NULL;
	}
	s->numEl = 0;
	s->top = NULL;
	return s;
}

int emptyStack(stack s) {
	return s->numEl == 0;
}

int push(stack s, item val) {
	struct node *new;
	new = malloc(sizeof(struct node));
	if(new == NULL) {
		return 0;
	}
	new->value = val;
	new->next = s->top;
	s->top = new;
	s->numEl = s->numEl + 1;
	return 1;
}

int pop(stack s) {
	if(s->numEl == 0) {
		return 0;
	}
	struct node *temp = s->top;
	s->top = s->top->next;
	free(temp);
	s->numEl = s->numEl - 1;
	return 1;
}

item top(stack s) {
	item e;
	if(s->numEl > 0) {
		e = s->top->value;
	} else {
		e = NULLITEM;
	}
	return e;
}