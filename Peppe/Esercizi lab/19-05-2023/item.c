 // file item.c

#include <stdio.h>
#include "item.h"


int Equal(item x, item y) 
{
    return x == y;
}

void InputItem(item *x) 
{
    scanf("%d", x);
}

void OutputItem(item x)
{
    printf("%d", x);
}