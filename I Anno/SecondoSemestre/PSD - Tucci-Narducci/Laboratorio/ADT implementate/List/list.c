#include <stdio.h>
#include <stdlib.h>
#include "list.h"
#include "item.h"

//Funzioni di servizio per inserimenti e rimozioni
static struct node* insertNode(struct node *l, int pos, item val);
static struct node* removeNode(struct node *l, int pos);

struct node {
	item value;
	struct node* next;
};

struct c_list {
	int size;
	struct node* first;
};

/*PROGETTAZIONE DI NEWLIST
1. Crea un nodo di intestazione
2. Riempie i campi del nodo
*/
list newList() {
	list new;
	new = malloc(sizeof(struct c_list));
	if(new != NULL){
		new->size = 0;
		new->first = NULL;
	}
	return new;
}

/*PROGETTAZIONE DI EMPTYLIST
1. Controlla che la lista esista, considerandola vuota nel caso non lo fosse
2. Controlla che i campi siano vuoti
3. Restituisce il valore corretto: 1 in caso la lista sia vuota, 0 altrimenti
*/
int emptyList(list l) {
	if((l == NULL) || (l->first == NULL) || (l->size == 0)) {
		return 1;
	}
	else {
		return 0;	
	}
}

/*PROGETTAZIONE DI TAILLIST
1. Crea una nuova lista result
2. Verifica che la lista di partenza non sia vuota
2.1 in caso non lo sia, collega result al secondo nodo di tale lista, deallocando il primo
2.1.1 e restituisce result
2.2 nel caso la lista iniziale sia vuota, o ci siano errori in allocazione per result dealloca result
2.2.1 e restituisce NULL
*/
list tailList(list l) {
	list result = newList();
	if((!emptyList(l)) && (result != NULL)) {
		result->first = (l->first)->next;
		result->size = l->size - 1;
		free(l->first);
		return result;
	}
	else {
		free(result);
		return NULL;
	}
}

/*PROGETTAZIONE DI CONSLIST:
1. Inserisce il valore nella prima posizione
2. Restituisce la lista modificata
*/
int consList(list l, item val) {
	return insertList(l, 0, val);
}

/*PROGETTAZIONE DI GETFIRST
1. Controlla che la lista abbia almeno un elemento
2. Restituisce il valore se presente, altrimenti NULLITEM
*/
item getFirst(list l) {
	if(emptyList(l)) {
		return NULLITEM;
	}
	else {
		return l->first->value;
	}
}

/*PROGETTAZIONE DI SIZELIST
1. Verificare che la lista non sia vuota, restituendo 0 in tal caso
2. Ottenere la taglia della lista e restituirla
*/
int sizeList(list l) {
	if(emptyList(l)){
		return 0;
	}
	else {
		return l->size;		
	}

}

/*PROGETTAZIONE DI SEARCHITEM
1. Controlla che la lista esista e non sia nulla
2. Scorre la lista per intero, fermandosi se il valore viene trovato
3. Restituisce 1 nel caso il valore sia presente, 0 altrimenti
*/
int searchItem(list l, item val) {
	int i = 0, found = 0;
	if(emptyList(l)){
		return 0;
	}
	else {
		int size = l->size;
		struct node *curr = l->first;
		while((i < size) && (curr != NULL) && (!found)) {
			if(equal(curr->value, val)) {
				found = 1;
			}
			else {
				i++;
				curr = curr->next;
			}
		}
	}
	return found;
}

/*PROGETTAZIONE DI POSITEM
1. Verifica che la lista esista
2. Scorre la lista fino alla fine, fermandosi se il valore viene trovato
3. Restituisce la posizione in cui si trova il valore, -1 altrimenti
*/
int posItem(list l, item val) {
	int pos = -1, found = 0;
	if(emptyList(l)) {
		return = -1;
	}
	else {
		int size = l->size;
		struct node *curr = l->first;
		while((pos < size) && (curr != NULL) && (!found)) {
			if(equal(curr->value, val)) {
				found = 1;
			}
			else {
				pos++;
				curr = curr->next;
			}
		}
	}
	if(found == 1) {
		return pos;
	}
	else {
		return -1;
	}
}

/*PROGETTAZIONE DI REVERSELIST
1. Allocare un nuovo nodo di intestazione
2. Verificare che la lista di partenza esista e non sia vuota e che il nuovo nodo sia stato allocato
2.1 in caso non avvenga, restituisce la nuova lista
3. Scorre la lista originale e ricopia ogni nodo in testa alla nuova lista
3.1 se, in qualsiasi momento, la copia fallisse
3.2 dealloca la nuova lista e restituisce NULL
4. Se tutto va bene, restituire la lista creata
*/
list reverseList(list l) {
	list rev = newList();	
	if((emptyList(l)) || (rev == NULL)) {
		return rev;
	}
	else {
		struct node* curr = l->first;
		while(curr != NULL){
			if(!insertList(rev, 0, curr->value)) {
				freeList(rev);
				return NULL;
			}
			curr = curr->next;
		}
	}
	return rev;
}

/*PROGETTAZIONE DI CLONELIST
1. Allocare un nuovo nodo di intestazione
2. Verificare che la lista di partenza esista e non sia vuota e che il nuovo nodo sia stato allocato
2.1 in caso non avvenga, restituisce la nuova lista
3. Scorre la lista originale e ricopia ogni nodo alla posizione corrente
3.1 se, in qualsiasi momento, la copia fallisse
3.2 dealloca la nuova lista e restituisce NULL
4. Se tutto va bene, restituire la lista creata
*/
list cloneList(list l) {
	//return reverseList(reverseList(l));
	list new = newList();
	if((emptyList(l)) || (new == NULL)) {
		return new;
	}
	else {
		struct node *curr = l->first;
		int i = 0, size = l->size;
		while((curr != NULL) && (i < size)) {
			if(!insertList(new, i, curr->value)) {
				freeList(new);
				return NULL;
			}
			curr = curr->next;
			i++;
		}
	}
}

/*PROGETTAZIONE DI GETITEM
1. Verificare che lista e posizione siano validi
2. Scorrere la lista fino alla posizione cercata
3. Restituire il valore
*/
item getItem(list l, int pos) {
	if((emptyList(l)) || (pos < 0) || (pos >= l->size)) {
		return NULLITEM;
	}
	else {
		struct node *curr = l->first;
		int i = 0;
		while(i < pos) {
			curr = curr->next;
			i++;
		}
		return curr->value;
	}
}

/*PROGETTAZIONE DI REMOVEITEM
1. Verificare che la lista esista e non sia vuota
2. Scorrere la lista fino alla fine, interrompendo nel caso il valore venga trovato
3. Restituire la lista risultante, sia che il valore venga rimosso o non venga trovato
*/
list removeItem(list l, item val) {
	if(emptyList(l)) {
		return l;
	}
	else {
		int pos = posItem(l, val);
		removeNode(l, pos);
		return l;
	}
}

/*PROGETTAZIONE DI INSERTLIST
1. Verifica che la posizione sia valida
2. Crea un nodo temporaneo (con una funzione di servizio)
3. Aggiorna la taglia della lista
4. Restituisce 1 se va tutto bene, 0 altrimenti
*/
int insertList(list l, int pos, item val) {
	if((pos < 0) || (pos > l->size)) {
		return 0;
	}
	struct node *temp = insertNode(l->first, pos, val);
	if(temp == NULL){
		return 0;
	}
	l->first = temp;
	l->size = l->size + 1;
	return 1;
}

/*PROGETTAZIONE DI INSERTNODE
1. Alloca un nuovo nodo in cui salvare il valore
2. Scorre la lista fino a raggiungere la posizione precedente a quella cercata
3. Collega il nuovo nodo alla lista nel posto giusto
4. Restituisce il primo nodo della lista ora modificata, altrimenti NULL
*/
static struct node *insertNode(struct node *l, int pos, item val) {
	struct node *new, *prev = l;
	int i = 0;
	new = malloc(sizeof(struct node));
	if(new == NULL) {
		return NULL;
	}
	new->value = val;
	if(pos == 0) {
		new->next = l;
		return new;
	}
	while(i < pos-1) {
		prev = prev->next;
		i++;
	}
	//Non serve verificare che prev sia NULL, dato che la verifica di pos viene fatta dalla chiamante
	new->next = prev->next;
	prev->next = new;
	return l;
}

/*PROGETTAZIONE DI REMOVELIST
1. Controlla che il nodo di intestazione esista ed abbia campi validi
2. Controlla che il valore della posizione sia valido
3. Rimuovere il nodo (usando una funzione di servizio)
4. Aggiornare i valori del nodo di intestazione
*/
int removeList(list l, int pos) {
	if((emptyList(l)) || (pos < 0) || (pos > (l->size) - 1)) {
		return 0;
	}
	else {
		l->first = removeNode(l->first, pos);
		l->size = l->size - 1;
		return 1;
	}
}

/*PROGETTAZIONE DI REMOVENODE
1. Crea un nodo temporaneo
2. Scorre la lista fino alla posizione precedente a quella voluta
3. Scollega e libera il nodo di posizione pos
4. Restituisce il primo nodo della nuova lista
*/
static struct node* removeNode(struct node *l, int pos) {
	struct node *l1;
	if(pos == 0) {
		l1 = l;
		l = l->next;
		free(l1);
	}
	else {
		int i = 0;
		struct node *prev = l;
		while(i < pos-1){
			prev = prev->next;
			i++;
		}
		l1 = prev->next;
		prev->next = l1->next;
		free(l1);
	}
	return l;
}

/*PROGETTAZIONE DI FREELIST
1. Controlla che la lista non sia vuota
1.1 in caso lo sia, termina
1.2 altrimenti scorre la lista fin quando ha ancora elementi
1.2.1 e dealloca il primo nodo della lista
1.2.2 poi dealloca l'ultimo nodo rimasto
1.2.3 ed infine dealloca il nodo di intestazione
*/
void freeList(list l) {
	if(!emptyList(l)){
		while(l->size > 0) {
			removeList(l, 0);
		}
		free(l->first);
		free(l);
	}
}

//needs testing
int insertTail(list l, item val) {
	int size = l->size;
	return insertList(l, size, val);
}

/*PROGETTAZIONE DI INPUTLIST
1. Verifica che n sia non negativo, restituendo NULL in tal caso
2. Alloca una nuova lista, terminando in caso di errore
3. Chiede all'utente di inserire tutti gli elementi richiesti
4. Restituisce la nuova lista
*/
list inputList(int n) {
	if(n < 0) {
		return NULL;
	}
	list new = newList();
	if(new == NULL) {
		fprintf(stderr, "Errore nell'allocazione della nuova lista\n");
		exit(-1);
	}
	else {
		if(n == 0) {
			return new;
		}
		else {
			item val;
			for(int i = 0; i < n; i++) {
				printf("Inserisci l'elemento di posizione %d: ", i);
				input_item(&val);
				insertList(new, i, val);
			}
		}
	}
	return new;
}

/*PROGETTAZIONE DI OUTPUTLIST
1. Scorre la lista per intero, stampando un solo elemento per riga
*/
void outputList(list l) {
	int i = 0;
	struct node *curr = l->first;
	item val;
	while(curr != NULL) {
		val = curr->value;
		printf("Elemento di posizione %d: ", i);
		output_item(val);
		i++;
		curr = curr ->next;
	}
}