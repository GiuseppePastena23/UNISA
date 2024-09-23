#include <stdio.h>
#include <stdlib.h>
#include <item.h>
#include <BST.h>

struct node {
	item value;			//etichetta del nodo
	struct node *left; 	//puntatore al sottoalbero sinistro
	struct node *right; //puntatore al sottoalbero destro
};

//Funzioni di servizio
static item getItem(struct node *N);
static void setItem(struct node *N, item el);
static BST creaFoglia(item elem);
static struct node *minValue(struct node *node);

static item getItem(struct node *N) {
	if(N == NULL) {
		return NULLITEM;
	}
	return N->value;
}

static void setItem(struct node *N, item el) {
	if(N == NULL) {
		return;
	}
	N->value = el;	//la correttezza di = dipende dal tipo di item
}
static BST creaFoglia(item elem) {
	struct node *new;
	new = malloc(sizeof(struct node));
	if(new != NULL) {
		setItem(N, elem);
		new->left = NULL;
		new->right = NULL;
	}
	return new;
	
}

static struct node *minValue(struct node *node) {
	struct node *current = node;
	while(current->left != NULL) {
		current = current->left;
	}
	return current;
}


BST newBST() {
	return NULL;
}

int emptyBST(BST T) {
	return T == NULL;
}

BST figlioSX(BST T) {
	if(T != NULL) {
		return T->left;
	}
	else {
		return NULL;
	}
}

BST figlioDX(BST T) {
	if(T != NULL) {
		return T->right;
	}
	else {
		return NULL;
	}
}

//Istruzioni d'uso: bst = insert(bst, elem)
BST insert(BST T, item elem) {
	if(T == NULL) {	//bisogna creare un albero nuovo con un solo elemento
		return creaFoglia(elem);
	}
	else if(minore(elem, getItem(T))) {	//se elemento < radice
		T->left = insert(T->left, elem);	//inserimento nel sottoalbero sinistro
	}
	else if(minore(getItem(T), elem)) {	//se radice < elemento
		T->right = insert(T->right, elem);	//inserimento nel sottoalbero destro
	}
	return T;	//nel caso elemento e radice fossero uguali, l'albero resta invariato (deve)
}

int contains(BST T, item elem) {
	if(T == NULL) {
		return 0;
	}
	if(equal(val, getItem(T))) {
		return 1;
	}
	if(minore(val, getItem(T))) {
		return contains(figlioSX(T), val);
	}
	else {
		return contains(figlioDX(T), val);
	}
}

BST deleteNode(BST T, item elem) {
	if(T == NULL) {
		return T;	//restituisce NULL
	}
	if(minore(elem, T->value)) {
		T->left = delete(T->left, elem);	//la ricerca continua nel sottoalbero sinistro
	}
	else if(minore(T->value, elem)) {
		T->right = delete(T->right, elem);	//la ricerca continua nel sottoalbero destro
	}
	else {	//elemento coincidente con la radice
		if(T->left == NULL) {	//se il nodo ha un solo sottoalbero, questo prende il posto del nodo da eliminare
			struct node *temp = T->right;
			free(T);
			return temp;
		}
		else if(T->right = NULL) {
			struct node *temp = T->left;
			free(T);
			return temp;
		}
		struct node *temp = minValue(T->right);	//se ci sono entrambi i sottoalberi, cerco il minimo presente a destra
		T->value = temp->value;	//inserisco l'elemento trovato al posto del nodo da eliminare
		T->right = delete(T->right, temp->value);	//elimino il nodo che conteneva tale elemento
	}
	return T;
}
