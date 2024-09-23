#include <stdio.h>
#include "item.h"
#include "stack.h"

/*
PROGETTAZIONE
1. 
*/
void inserisciInteri(stack S)
{
    item val = 0;
    int i = 0;
    
    while(true)
    {
        printf("Inserisci valore %d(-1 per uscire): ", i+1);
        InputItem(val);
        if(!Equal(val , -1))
        {
            push(val, S);
            i++;
        }
        else
        {
            break;
        }
    }     
}

stack reverseStack(stack S)
{
    stack reverse = NewStack(), appoggio = NewStack();
    item temp; 
    
    while(!EmptyStack(S))
    {
        temp = top(S);
        push(temp, reverse);
        push(temp, appoggio);
        pop(S);
    }
    
    while(!EmptyStack(S3))
    {
        temp = top(appoggio)
        push(temp, S)
        pop(appoggio);
    }
    
    free(appoggio);
    
    return reverse;
}

void append(stack stack1, stack stack2)
{
    stack stack3 = NewStack(); 
    stack1 = reverseStack(stack1);
    stack2 = reverseStack(stack2);
    item val;
    
    while(!EmptyStack(stack2))
    {
        val = top(stack2);
        push = (val, stack3);
        pop(stack2);
    }
    
    free(stack2)
    
    while(!EmptyStack(stack1))
    {
        val = top(stack1);
        push = (val, stack3);
        pop(stack1);
    }
    
    while(!EmptyStack(stack3))
    {
        val = top(stack3);
        push = (val, stack1);
        pop(stack3);
    }
    
    free(stack3);
}

void merge(stack s1, stack s2)
{
    s1 = reverseStack(s1);
    item val;
    
    while(!EmptyStack(s1))
    {   
        val = top(s1);
        push(val, s2);
        pop(s1);
    }
    
    s2 = reverseStack(s2)
    while(!EmptyStack(s2))
    {
        val = top(s2);
        push(val, s1)
        pop(s2);
    }
}

stack estraiN(stack s, item n)
{
  stack appoggio = NewStack();
  item val;

  while(!EmptyStack(s))
  {
    val = top(s)
    if(!Equal(val, n))
    {
      push(val, appoggio);
    }
    pop(s);
  }

  appoggio = reverseStack(appoggio);

  while(!EmptyStack(appoggio))
  {
    val = top(appoggio);
    push(val, s);
    pop(appoggio);
  }

  free(appoggio);

  return s;
}



