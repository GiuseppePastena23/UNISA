/*
STACK

- Uno stack e' una sequenza di elementi di un determinato tipo, in cui e' possibile aggiungere o togliere elementi
uno alla volta da un un unico lato(il top dello stack).
- Si puo accedere direttamente solo al primo elemento dello stack
- Non si puo' accedere ad un elemento diverso dall'ultimo inserito se non dopo aver eliminato tutti gli elementi che lo precedono
*/
#include "item.h"


typedef struct c_stack *stack;  

// PROTOTIPI


stack NewStack(void);


int EmptyStack(stack s);

int push(item val, stack s);

int pop(stack s);

item top(stack s);