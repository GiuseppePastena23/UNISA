//New item.h module

#define NULLITEM NULL	//si potrebbe anche optare per 0
typedef int item;

//usato per allocare memoria per un item (trattandosi di interi diventa semplice)
item new_item(int val);

//usato per confrontare due item: 1 se uguali, 0 se diversi
int equal(item a, item b);

//funzioni per l'ottenimento di un item in input
void input_item(item *el);
item input_item();

//funzione per stampare un item
void output_item(item a);

//funzioni usate per confrontare due item
int minore(item x, item y);
int maggiore(item a, item b);
