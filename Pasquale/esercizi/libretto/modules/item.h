// ITEM.H

#define NULLITEM NULL

typedef struct esame *item;

item new_item(char nome_esame[], int voto, char data[]);

int freeItem(item a);

// as boolean
int eq(item a, item b);

item input_item();

void output_item(item a);

// GETTERs & SETTERs
char *getNome(item a);

