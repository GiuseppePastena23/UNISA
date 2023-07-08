#include "modules/stack.h"
#include "modules/list.h"
#include "stdlib.h"

void riversa(list dest, stack src) {
    while(!emptyStack(src)) {
        insertTail(dest, top(src));
        pop(src);
    }
}

stack stack_comuni(stack a, stack b) {
    stack c = NewStack();
    list tutto = newList();

    riversa(tutto, a);
    riversa(tutto, b);

    int size_tutto = sizeList(tutto);
    for (int i = 0; i < size_tutto - 1; i++)
    {
        item el1 = getItem(tutto, i);
        for (int j = i+1; j < size_tutto; j++) {
            item el2 = getItem(tutto, j);
            if (eq(el1, el2)) {
                push(el2, c);
            }
        }
    }
    
    free(tutto);
    return c;
}

int main(int argc, char const *argv[])
{
    stack a = newStack();
    // vìolo l'information hiding
    push(1, a);
    push(2, a);
    push(3, a);
    push(4, a);


    stack b = newStack();
    push(2, b);
    push(3, b);

    stack c = stack_comuni(a, b);
    while (!emptyStack(c))
    {
        output_item(top(c));
        pop(c);
    }
    

    return 0;
}
