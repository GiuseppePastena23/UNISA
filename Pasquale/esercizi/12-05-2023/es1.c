#include <stdio.h>
#include <string.h>

#include "modules/item.h"
#include "modules/list.h"
#include "modules/stack.h"

int sizeList_ricorsiva(list a) {
	if (emptyList(a)) {
		return 0;
	} else {
		return sizeList_ricorsiva(tailList(a)) + 1;
	}
}

int quadrato(int n) {
	if (n == 1) {
		return 1;
	} else {
		return quadrato(n - 1) + (2 * n - 1);
	}
}

item getBottom(stack a) {
	item previous = top(a);
	item el;
	pop(a);
	if (emptyStack(a)) {
		push(previous, a);
		return previous;
	} else {
		item el = getBottom(a);
		push(previous, a);
		return el;
	}
}

int euclide(int m, int n) {
	if (n < 0) n *= -1;
	int d = m - n;

	if (d == n) {
		return n;
	}
	if (n < m) {
		return euclide(d, n);
	} else {
		return euclide(n, d);
	}
}

int palindromaHelper(char string[], int start, int end) {
	if (start >= end) {
		return 1;
	}
	if (string[start] != string[end]) {
		return 0;
	}
	return palindromaHelper(string, start+1, end-1);
}

int palindroma(char string[]) {
	int size = strlen(string);
	return palindromaHelper(string, 0, size-1);
}

int main(int argc, char const *argv[]) {
	// test sizeList()
	/*
	list l = newList();
	for (int i = 0; i < 123; i++) {
		insertTail(l, i);
	}
	printf("Dimensione lista: %d\n", sizeList_ricorsiva(l));
	*/

	// test quadrato()
	// printf("x: %d\n", quadrato(6));

	// test getBottom()
	/*
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
	*/

	// euclide
	/*
	for (;;) {
		int a, b;
		scanf("%d %d", &a, &b);
		printf("M.C.D: %d\n", euclide(a, b));
	}
	*/

	// test palindroma()
	char stringa[] = "osso";
	printf("%s: %s\n", stringa, palindroma(stringa) ? "palindroma" : "non palindroma");
	
	return 0;
}
