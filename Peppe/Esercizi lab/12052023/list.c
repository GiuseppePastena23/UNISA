#include<stdlib.h>
#include"item.h"
#include"list.h"

struct node{
	item value;
	struct node* next;
};

typedef struct c_list{
	int size;
	struct node* first;
}*list;

static struct node* insertNode(struct node* l, int pos, item val);
static struct node* removeNode(struct node* l, int pos);

list newList(){
	list new;
	
	new = malloc(sizeof(struct c_list));
	if(new != NULL){
		new->size = 0;
		new->first = NULL;
	}
	
	return new;
}

int emptyList(list l){
	if(!l|| l->first == NULL || l->size == 0){
		return 1;
	}
	
	return 0;
}

list tailList(list l){
	list result;
	
	result = malloc(sizeof(struct c_list));
	if(l!=NULL && result != NULL && l->size > 0){
		result->first = (l->first)->next;
		result->size = l->size - 1;
		return result;
	}
	
	return NULL;
}

int insertList(list l, int pos, item val){
	struct node *tmp;
	if(!l || pos<0 || pos>l->size){
		return 0;
	}//else
	
	tmp = insertNode(l->first, pos, val);
	if(!tmp){
		return 0;
	}//else
	
	l->first = tmp;
	l->size++;
	
	return 1;
}

static struct node* insertNode(struct node* l, int pos, item val){
	struct node *new, *prec;
	int i;
	
	new = malloc(sizeof(struct node));
	if(!new){
		return NULL;
	}
	new->value = val;
	
	if(pos == 0){
		new->next = l;
	}
	
	i = 0;
	prec = l;
	while(i<pos-1){
		prec = prec->next;
		i++;
	}
	
	new->next = prec->next;
	prec->next = new;
	
	return l;
}

int consList(item val, list l){
	return insertList(l, 0, val);
}

item getFirst(list l){
	if(!l || l->size == 0 || l->first == NULL){
		return NULLITEM;
	}
	return getItem(l, 0);
}

int sizeList(list l){
	if(!l){
		return 0;
	}
	return l->size;
}

int removeList(list l, int pos){
	if(!l || pos<0 || pos>l->size -1){
		return 0;
	}
	l->first = removeNode(l->first, pos);
	l->size--;
	return 1;
}

static struct node* removeNode(struct node* l, int pos){
	struct node *prec, *l1;
	int i;
	
	if(pos == 0){
		l1 = l;
		l = l->next;
		free(l1);
	}
	else{
		prec = l;
		i = 0;
		while(i<pos-1){
			prec = prec->next;
			i++;
		}
		l1 = prec->next;
		prec->next = l1->next;
		free(l1);
	}
	
	return l;
}

item getItem(list l, int pos){
	struct node *curr;
	int i;
	
	if(!l || l->size == 0 || l->first == NULL || pos<0 || pos>=l->size){
		return NULLITEM;
	}
	
	curr = l->first;
	i=0;
	while(i<pos){
		curr = curr->next;
		i++;
	}
	
	return curr->value;
}

void freeList(list l){
	if(l != NULL){
		while(l->size > 0){
			removeList(l, 0);
		}
		free(l->first);
		free(l);
	}
}

list reverseList(list l){
	list rev;
	struct node* curr;
	
	rev = newList();
	if(!l || !rev || l->size == 0 || l->first == NULL){
		return rev;
	}
	
	curr = l->first;
	while(curr != NULL){
		if(!consList(curr->value, rev)){
				freeList(rev);
				return NULL;
		}
		curr = curr->next;
	}
	
	return rev;
}

list cloneList(list l){
	return reverseList(reverseList(l));
}

int searchItem(list l, item val){
	struct node* curr;
	int found;
	
	if(!l || l->size == 0 || l->first == NULL){
		found = 0;
	}
	else{
		curr = l->first;
		found = 1;
		while(curr!=NULL && curr->value != val){
			curr = curr->next;
		}
		if(!curr){	//non trovato
			found = 0;
		}
	}
	
	return found;
}

int posItem(list l, item val){
	struct node* curr;
	int pos;
	
	if(!l || l->size == 0 || l->first == NULL){
		pos = -1;
	}
	else{
		curr = l->first;
		pos = 0;
		while(curr!=NULL && curr->value != val){
			curr = curr->next;
			pos++;
		}
		if(!curr){	//non trovato
			pos = -1;
		}
	}
	
	return pos;
}

list removeItem(list l, item val){
	int pos;
	
	pos = posItem(l, val);
	removeList(l, pos);
	
	return l;
}
