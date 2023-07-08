// ITEM.H

#define NULLITEM NULL
#define MAXITEM 9999999
typedef int item;

// usato teoricamente per allocare memoria per un item
item new_item(int val);

// equals: return a == b;
int eq(item a, item b);

int minore(item a, item b);

void input_item(item *el);

void output_item(item a);
