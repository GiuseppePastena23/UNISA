#include <stdio.h>
#include <stdlib.h>
#include "item.h"
#include "Btree.h"

struct node {
	item value;			//etichetta del nodo
	struct node *left;	//puntatore al sottoalbero sinistro
	struct node *right;	//puntatore al sottoalbero destro
};

static int max(int n1, int n2);	//funzione di comodo per la funzione altezza

Btree newBtree() {
	return NULL;
}

int emptyBtree(Btree T) {
	return T == NULL;
}

Btree figlioSX(Btree T) {
	if(T!= NULL) {
		return T->left;
	}
	else {
		return NULL;
	}
}

Btree figlioDX(Btree T) {
	if(T != NULL) {
		return T->right;
	}
	else {
		return NULL;
	}
}

Btree consBtree(item val, Btree sx, Btree dx) {
	struct node *new;
	new = malloc(sizeof(struct node));
	if(new != NULL) {
		setItem(new, val);
		new->left = sx;
		new->right = dx;
	}
	return new;
}

struct node *getRoot(Btree T) {
	return T;
}

static int max(int n1, int n2) {
	return n1 > n2 ? n1 : n2;
}

item getItem(struct node *N) {
	if(N == NULL) {
		return NULLITEM;
	}
	return N->value;
}

void setItem(struct node *N, item el) {
	if(N == NULL) {
		return;
	}
	N->value = el;	//la correttezza dipende dal tipo di item
	return;
}

Btree inputBtree() {
	int isEmpty;
	printf("\nL'albero è vuoto? (1: sì \ 0: no): ");
	scanf("%d", &isEmpty);
	if(isEmpty) {
		return newBtree();
	}
	else {
		Btree T1, T2;
		item el;
		printf("\nInserisci la radice: ");
		input_item(&el);
		printf("Costruisco il sottoalbero sinistro\n");
		T1 = inputBtree();
		printf("Costruisco il sottoalbero destro\n");
		T2 = inputBtree();
		return consBtree(el, T1, T2);
	}
}

void visitaPre(Btree T) {
	if(emptyBtree(T)) {
		return;
	}
	output_item(getItem(getRoot(T)));
	visitaPre(figlioSX(T));
	visitaPre(figlioDX(T));
	return;
}

void visitaPost(Btree T) {
	if(emptyBtree(T)) {
		return;
	}
	visitaPost(figlioSX(T));
	visitaPost(figlioDX(T));
	output_item(getItem(getRoot(T)));
	return;
}

void visitaInOrder(Btree T) {
	if(emptyBtree(T)) {
		return;
	}
	visitaInOrder(figlioSX(T));
	output_item(getItem(getRoot(T)));
	visitaInOrder(figlioDX(T));
	return;
}

int altezza(Btree T) {
	if(emptyBtree(T)) {
		return 0;
	}
	return (1 + max(altezza(figlioSX(T)), altezza(figlioDX(T))));
}

int numeroNodi(Btree T) {
	if(emptyBtree(T)) {
		return 0;
	}
	return (1 + numeroNodi(figlioDX(T)) + numeroNodi(figlioSX(T)));
}
