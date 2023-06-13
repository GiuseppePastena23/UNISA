// ITEM.C

#include <stdio.h>
#include "item.h"

item new_item(int val) {
    return val;
}

int eq(item a, item b) {
    return a == b;
}

int minore(item a, item b) {
    return a < b;
}

void input_item(item *el) {
    scanf("%d", el);
}

void output_item(item a) {
    printf("%d\n", a);
}
