#include "modules/list.h"
#include "modules/stack.h"
#include "modules/item.h"
#include <stdio.h>

int sizeList_ricorsiva(list a) {
    if (emptyList(a)) {
        return 0;
    }
    else {
        return sizeList_ricorsiva(tailList(a)) + 1;
    }
}

int quadrato(int n) {
    if (n == 1) {
        return 1;
    }
    else {
        return quadrato(n-1) * (2*n-1);
    }
}

item getBottom(stack a) {
    item previous = top(a);
    item el;
    pop(a);
    if (emptyStack(a)) {
        push(previous, a);
        return previous;
    }
    else {
        item el = getBottom(a);
        push(previous, a);
        return el;
    }
}

int euclide(int m, int n) {
    int differenza = m - n;
    if (differenza < 0);
}

int palindroma(char string[]) {
    
}


int main(int argc, char const *argv[])
{
    stack s = newStack();
    for (int i = 1; i < 5; i++)
    {
        item asdf = new_item(i);
        push(asdf, s);
    }

    item el = getBottom(s);
    printf("BOTTOM: %d\n\n", el);


    printf("STACK:\n");
    while (!emptyStack(s))
    {
        printf("%d\n", top(s));
        pop(s);
    }
    
    return 0;
}

