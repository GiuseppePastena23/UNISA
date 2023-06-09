// ITEM.C

#include <stdio.h>
#include "item.h"

item new_item(int val) {
    return val;
}

int eq(item a, item b) {
    return a == b;
}

void input_item(item *el) {
    scanf("%d", el);
}

void output_item(item a) {
    printf("%d\n", a);
}

int minore(item x, item y)
{
	if(x < y)
		return 1;
	else
		return 0;
}