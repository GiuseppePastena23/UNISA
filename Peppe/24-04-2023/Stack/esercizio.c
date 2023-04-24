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
    stack reverse = NewStack();
    
}


