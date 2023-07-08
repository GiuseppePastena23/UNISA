// LIST.H

#include "item.h"

typedef struct c_list *list;

list newList(void);
int emptyList(list L); // as booelan
list tailList(list L);
list consList(item val, list L); // insertHead
item getFirst(list L);
item getItem(list L, int pos);
int sizeList(list L);
int posItem(list L, item val);
int searchItem(list L, item val);
list reverseList(list L); // ne crea una nuova
int insertList(list L, int pos, item val);
int removeList(list L, int pos);

list inputList (int n); // n è il numero degli elementi da inserire
void outputList (list L);


// ----------------------------
// funzioni che possono essere utili
int insertHead(list L, item val); // as boolean
int insertTail(list L, item val); // as boolean
// #define add(L, val) insertTail(L, val) // sinonimo di insertTail
