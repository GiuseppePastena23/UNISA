/*ALBERI BINARI DI RICERCA
L'albero vuoto è un albero binario di ricerca
Se l'albero non è vuoto allora ogni elemento del sottoalbero sx precede la radice;
ogni elemento del sottoalbero dx segue la radice;
i sottoalberi sx e dx sono alberi binari di ricerca.
N.B. non sono presenti elementi ripetuti*/

#include <stdio.h>
#include <stdlib.h>
#include "BST.h"
#include "item.h"

struct node {
	item value;
	struct node *left;
	struct node *right;
};

static item getItem(struct node *N);
static void setItem(struct node *N, item el);
static BST creaFoglia(item elem);
static struct node * minValue(struct node * node);

/*ANALISI E PROGETTAZIONE DI getItem
getItem(struct node *) -> item
getItem(N) -> N -> value
precondizioni: Nessuna
postcondizioni: L'elemento restituito è quello contenuto in N
1. Verificare che il nodo N non sia nullo
2. Restituire l'elemento contenuto nel nodo N
*/
static item getItem(struct node *N) {
	if(N == NULL)
		return NULLITEM;
	return N -> value;
}

/*ANALISI E PROGETTAZIONE DI setItem
setItem(struct node *, item) -> void
setItem(N, el) -> void
precondizioni: Nessuna
postcondizioni: L'elemento viene inserito nel nodo N
1. Verificare che il nodo N non sia nullo
2. Inserire l'elemento nel nodo N
*/
static void setItem(struct node *N, item el) {
	if(N == NULL)
		return;
	N -> value = el;
}

/*ANALISI E PROGETTAZIONE DI creaFoglia
creaFoglia(item) -> BST
creaFoglia(elem) -> T
precondizioni: Nessuna
postcondizioni: Il nodo allocato conterrà elem
1. Allocare un nuovo albero
2. Assegnare i valori corretti ai campi
3. Restituire il nuovo albero
*/
static BST creaFoglia(item elem) {
	struct node * N = malloc(sizeof(struct node));
	if(N == NULL)
		return NULL;
	setItem(N, elem);
	N -> left = NULL;
	N -> right = NULL;
	return N;
}

/*ANALISI E PROGETTAZIONE DI minValue
minValue(struct node *): struct node *
minValue(node) -> current
precondizioni: Nessuna
postcondizioni: La funzione restituisce l'elemento minore del sottoalbero di radice node
1. Creare un nodo temporaneo in cui salvare il valore del nodo passato
2. Scorrere fino all'ultimo nodo del sottoalbero
3. Restituire il nodo temporaneo
*/
static struct node * minValue(struct node * node) {
	struct node * current = node;
	while(current -> left != NULL)
		current = current -> left;
	return current;
}

/*PROGETTAZIONE DI newBST
1. Restituire il valore NULL, che corrisponde ad un albero vuoto 
*/
BST newBST(void) {
	return NULL;
}

/*PROGETTAZIONE DI emptyBST
1. Verificare che l'albero sia o meno vuoto
2. Restituire 1 in caso sia vuoto, 0 altrimenti
*/
int emptyBST(BST T) {
	return T == NULL;
}

/*PROGETTAZIONE DI figlioSX
1. Restituire il sottoalbero sinistro dell'albero ricevuto
*/
BST figlioSX(BST T) {
	if(T != NULL) return T -> left;
    else return NULL;
}

/*PROGETTAZIONE DI figlioDX
1. Restituire il sottoalbero destro dell'albero ricevuto
*/
BST figlioDX(BST T) {
	if(T != NULL) return T -> right;
    else return NULL;
}

/*PROGETTAZIONE DI insert
1. Se l'albero è vuoto, creane uno nuovo con un solo elemento (funzione separata)
2. Se l'albero non è vuoto,
2.1 se l'elemento è minore della radice, lo inserisce nel sottoalbero sx
2.2 se l'elemento è maggiore della radice, lo inserisce nel sottoalbero dx
2.3 se l'elemento è uguale alla radice, lascia l'albero invariato
*/
BST insert(BST T, item elem) {
	if(T == NULL)
		return creaFoglia(elem);
	else if(minore(elem, getItem(T)))
		T -> left = insert(T -> left, elem);
	else if(minore(getItem(T), elem))
		T -> right = insert(T -> right, elem);
	return T;
}

/*PROGETTAZIONE DI contains
1. Se l'albero è vuoto, restituisci 0
2. Se l'elemento cercato coincide con la radice, restituisci 1
3. Se l'elemento cercato è minore della radice allora continua la ricerca nel sottoalbero sx
3.1 altrimenti continua nel sottoalbero dx
*/
int contains(BST T, item val) {
	if(T == NULL)
		return 0;
	if(Equal(val, getItem(T)))
		return 1;
	if(minore(val, getItem(T)))
		return contains(figlioSX(T), val);
	else
		return contains(figlioDX(T), val);
}

/*PROGETTAZIONE DI delete
1. Se l'albero è vuoto, restituisci NULL
2. Se l'elemento cercato è minore della radice, continua nel sottoalbero sx
2.1 mentre se l'elemento è maggiore della radice, continua nel sottoalbero dx
2.2 altrimenti se l'elemento coincide con la radice
2.2.1 Se il nodo ha un solo sottoalbero la radice del sottoalbero prende il posto del nodo da eliminare
2.2.2 Se il nodo ha entrambi i sottoalberi
2.2.2.1 cerco l'elemento minimo appartenente al sottoalbero destro del nodo da eliminare (funzione separata)
2.2.2.2 inserisco l'elemento trovato al posto del nodo da eliminare
2.2.2.3 e poi elimino il nodo che conteneva tale elemento 
3. Restituisco l'albero risultante 
*/
BST delete(struct node * root, item key) {
	if(root == NULL)
		return root;
	if(minore(key, root -> value))
		root -> left = delete(root -> left, key);
	else if(minore(root -> value, key))
		root -> right = delete(root -> right, key);
	else {
		if(root -> left == NULL) {
			struct node * temp = root -> right;
			free(root);
			return temp;
		}
		else if(root -> right == NULL) {
			struct node * temp = root -> left;
			free(root);
			return temp;
		}
		struct node * temp = minValue(root -> right);
		root -> value = temp -> value;
		root -> right = delete(root -> right, temp -> value);
	}
	return root;
}