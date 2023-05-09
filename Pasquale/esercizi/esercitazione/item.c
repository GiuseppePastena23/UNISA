#include "item.h"
#include <stdio.h>

int eq(item a, item b) {
    return a == b;
}

item input_item() {
    item a;
    scanf("%d", &a);
    return a;
}

void output_item(item a) {
    printf("%d", a);
}
