#include "item.h"

typedef struct c_list *list;
struct node;

static struct node * insertNode(struct node *l, int pos, item val);
static struct node * removeNode(struct node *l, int pos);

list newList (void);
int emptyList (list L);
list tailList (list L);
list consList (item val, list L);
item getFirst (list L);
int sizeList (list L);
int posItem (list L, item val);
int searchItem (list L, item val);
list reverseList (list L);
list removeItem (list L, item val);
item getItem (list L, int pos);
int insertList (list L, int pos, item val);
int removeList (list L, int pos);

static struct node * insertNode(struct node *l, int pos, item val);
static struct node * removeNode(struct node *l, int pos);

list inputList (int n);
void outputList (list L);
