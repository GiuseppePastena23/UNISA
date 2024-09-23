#include"item.h"

typedef struct c_list *list;

//crea una lista vuota
list newList();

//Verifica che la lista l sia vuota o meno
//precondizione: nessuna
//postcondizione: restituisce 1 se vuota, 0 altrimenti
int emptyList(list l);

//Rimuove il primo elemento della lista
list tailList(list l);

//Aggiunge un elemento alla prima posizione della lista
//precondizione: nessuna
//postcondizione: l' è la lista composta da el + la lista l; restituisce 0 se fallisce, 1 altrimenti
int consList(list l, item val);

//Restituisce il primo elemento della lista
//precondizione: lista correttamente allocata e che presenta almeno un'elemento
//postcondizione: val è il primo elemento di l
item getFirst(list l);

//Restituisce la dimensione di una lista
//precondizione: nessuna
//postcondizione: size è la lunghezza della lista
int sizeList(list l);

//Controlla se un item è presente in una lista
//precondizione: true
//postcondizione: restituisce 1 se viene trovato l'elemento, 0 altrimenti
int searchItem(list l, item val);

//Trova la posizione della prima ricorrenza di un particolare item
//precondizione: nessuna
//postcondizione: se val è presente nella ista pos è la sua posizione, altrimenti pos è -1
int posItem(list l, item val);

//Inverte l'ordine degli elementi della lista
//precondizione: nessuna
//postcondizione: l = <a1, a2, a3, ..., an> e l' = <an, ...., a3, a2, a1>
list reverseList(list l);

//Genera un duplicato della lista l
//precondizione: nessuna
//postcondizione: l' è una copia di l
list cloneList(list l);

//Trova l'item di posizione pos
//precondizione: 0 <= pos < taglia di l e l non vuota
//postcondizione: val è l'item in posizione pos della lista
item getItem(list l, int pos);

//Rimuove il primo elemento di valore val dalla lista
//precondizione: l non vuota
//postcondizione: l' è l senza val
list removeItem(list l, item val);

//Inserisce un elemento in posizione pos all'interno della lista
//precondizione: nessuna
//postcondizione: la lista ottenuta è uguale a quella iniziale, con l'aggiunta di un nuovo elemento e lo shift di quelli che eventualmente lo seguono
int insertList(list l, int pos, item val);

//Rimuove l'elemento in posizione pos dalla lista
//precondizione: l esiste; 0<=pos<dimensione di l
//postcondizione: l' è la lista l senza l'elemento in posizione pos; success è 1 se la rimozione ha successo, altrimenti 0
int removeList(list l, int pos);

//Dealloca la lista
//precondizioni: nessuna
//postcondizioni: nessuna
void freeList(list l);

//Inserisce in coda alla lista, restituendo 1 se va bene e 0 altrimenti
//needs testing
int insertTail(list l, item val);

//Funzioni per input/output
list inputList (int n);
void outputList (list L);