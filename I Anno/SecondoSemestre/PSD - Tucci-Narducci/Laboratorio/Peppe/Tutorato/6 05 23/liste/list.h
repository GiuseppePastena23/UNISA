#include"item.h"
//una lista è un insieme vuoto oppure costituito dall'unione di un singoletto con una lista
typedef struct c_list *list;
//crea una lista vuota
list newList();
//controlla se la lista è vuota
//dati in ingresso: l, lista
//dati in uscita: empty, intero
//precondizione: true
//postcondizione: empty è 1 se la lista è vuota, 0 altrimenti
int emptyList(list l);
//
list tailList(list l);
//aggiunge un elemento alla lista
//dati in ingresso: el, intero; l, lista
//dati in uscita: l', lista; success, intero
//precondizione: true
//postcondizione: l' è la lista composta da el + la lista l; success è 0 se fallisce, 1 altrimenti
int consList(item el, list l);
//ritorna il primo elemento della lista
//dati in ingresso: l, lista
//dati in uscita: val, item
//precondizione: l non vuota
//postcondizione: val è il primo elemento di l
item getFirst(list l);
//trova la dimensione di una lista
//dati in ingresso: l, lista
//dati in uscita size, intero
//precondizione: true
//postcondizione: size è la lunghezza della lista
int sizeList(list l);
//controlla se un item è presente in una lista
//dati in ingresso: l, lista; val, item
//dati in uscita: found, intero
//precondizione: true
//postcondizione: found è 1 se val è in l, 0 altrimenti
int searchItem(list l, item val);
//trova la posizione della prima ricorrenza di un particolare item
//dati in ingresso: l, lista; val item
//dati in uscita: pos, intero
//precondizione: true
//postcondizione: se val è presente nella ista pos è la sua posizione, altrimenti pos è -1
int posItem(list l, item val);
//inverte la lista
//dati in ingresso: l, lista
//dati in uscita l', lista
//precondizione: true
//postcondizione: l = <a1, a2, a3, ..., an> e l' = <an, ...., a3, a2, a1>
list reverseList(list l);
//trova l'iitem in una particolare posizione
//dati in ingresso: l, lista; pos, intero
//dati in uscita: val, item
//precondizione: 0<=pos<taglia di l; l non vuota
//postcondizione: val è l'item in posizione pos della lista
item getItem(list l, int pos);
//dati in ingresso: l, lista
//dati in uscita: l' lista
//precondizione: true
//postcondizione: l' è una copia di l
list cloneList(list l);
//rimuove il primo elemento di valore val dalla lista
//dati in ingresso: l, lista; val, item
//dati in uscita: l', lista
//precondizione: l non vuota
//postcondizione: l' è l senza val
list removeItem(list l, item val);
//rimuove l'elemento in posizione pos dalla lista
//dati in ingresso: l, lista; pos, intero; val, item
//dati in uscita: l', lista; success, intero;
//precondizione: 0<=pos<=dimensione di l
//postcondizione: l' e la lista ottenuta da l inserendo val in posizione pos; success è 1 se l'inserimento ha successo, altrimenti 0
int insertList(list l, int pos, item val);
//dati in ingresso: l, lista; pos, intero
//dati in uscita: l', lista; success, intero
//precondizione: l esiste; 0<=pos<dimensione di l
//postcondizione: l' è la lista l senza l'elemento in posizione pos; success è 1 se la rimozione ha successo, altrimenti 0
int removeList(list l, int pos);
//
void freeList(list l);
