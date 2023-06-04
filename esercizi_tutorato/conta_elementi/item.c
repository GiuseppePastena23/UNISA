// ITEM.C

#include <stdio.h>
#include "item.h"

item new_item(int val) {
    return val;
}

int eq(item a, item b) {
    return a == b;
}

int maggiore(item a, item b) {
    return a > b;
}

item input_item() {
    int a;
    scanf("%d", &a);
    return a;
}

void output_item(item a) {
    printf("%d", a);
}
