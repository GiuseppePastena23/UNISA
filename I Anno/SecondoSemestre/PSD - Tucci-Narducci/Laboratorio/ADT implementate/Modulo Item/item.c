#include <stdio.h>
#include "item.h"

item new_item(int val) {
	return val;
}

int equal(item a, item b) {
	return a == b;
}

void input_item(item *el) {
	scanf("%d", el);
}

item input_item() {
	int a;
	scanf("%d", &a);
	return a;
}

void output_item(item a) {
	printf("%d\n", a);
}

int minore(item x, item y) {
	if(x < y)
		return 1;
	else
		return 0;
}

int maggiore(item a, item b) {
    return a > b;
}