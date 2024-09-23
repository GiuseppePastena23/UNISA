#include <stdio.h>
#include <stdlib.h>
#include "item.h" 
#include "list.h"

struct node {
	item value;
	struct node *next;
};

list newList(void)
{
	return NULL;
}

int emptyList(list l)
{
	l == NULL;
}

list consList(item val, list l)
{
	struct node *new;
	new = malloc(sizeof(struct punto));
	if(new != NULL) {
		new -> value = val;
		new -> next = l;
	}
	return new;
}

list tailList(list l)
{
	list temp;
	if(l != NULL)
		temp = l -> next;
	else
		temp = NULL;
	return temp;
}

item getFirst (list l)
{
    item e;
	if(l != NULL)
		e = l -> value;
	else
		e = NULLITEM;
	return e;
}

int sizeList (list l)
{
	int n = 0;
	while(!emptyList(l)) {
		n++;
		l = tailList(l);
	}
	return n;
}

int posItem (list l, item val)
{
	int pos = 0, found = 0;
	while((!emptyList(l)) && (!found)) {
		if(eq(getFirst(l), val)
			found = 1;
		else {
			pos++;
			l = tailList(l);
		}
	}
	if(!found)
		pos = -1;
	return pos;
}

item getItem (list l, int pos)
{
    item e;
	int i = 0;
	if(pos < 0)
		return NULLITEM;
	while((i < pos) && (!emptyList(l))) {
		i++;
		l = tailList(L);
	}
	if(!emptyList(l))
		e = getFirst(l);
	else
		e = NULLITEM;
	return e;
}

list reverseList (list l)
{
    list rev;
	item val;
	rev = newList();
	while(!emptyList(l)) {
		val = getFirst(l);
		rev = consList(val, rev);
		l = tailList(l);
	}
	return rev;
}

void outputList (list l)
{
	int i = 0;
	item val;
	while(!emptyList(l)) {
		val = getFirst(l);
		printf("Elemento di posizione %d: ", i);
		output_item(val);
		l = tailList(l);
		i++;
	}
}