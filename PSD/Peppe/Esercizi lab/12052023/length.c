#include "list.h"
#include "length.h"
#include <stdio.h>



int listLength(list L)
{
    if(EmptyList(L))
    {
        return 0;
    }
    else
    {
        return listLength(tailList(L)) + 1; 
    }
}

int quadratoN(int n)
{
    if(n == 1)
    {
        return n;
    }
    return((2*n-1)+quadratoN(n-1));
}
