#include "item.h"

typedef struct c_stack *stack;  

stack newStack();

int emptyStack(stack s);

int push(stack s, item val);

int pop(stack s);

item top(stack s);