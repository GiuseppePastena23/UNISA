#include "list.h"

#include <stdio.h>
#include <stdlib.h>

#include "item.h"

static struct node *insertNode(struct node *l, int pos, item val);
static struct node *removeNode(struct node *l, int pos);

struct c_list {
    struct node *first;
    int size;
};

struct node {
    item value;
    struct node *next;
};

/* PROGETTAZIONE DI NEWLIST
1. Crea un nodo di intestazione
2. Riempie i campi del nodo
*/
list newList(void) {
    struct c_list *l;
    l = malloc(sizeof(struct c_list));
    if (l != NULL) {
        l->first = NULL;
        l->size = 0;
    }
    return l;
}

/*PROGETTAZIONE DI EMPTYLIST
Dizionario dei dati:
        lista da controllare: L
PROGETTAZIONE:
1. Controlla che la lista esista, considerandola vuota nel caso non lo fosse
2. Controlla che i campi siano vuoti
3. Restituire il valore corretto: 1 in caso la lista sia vuota, 0 altrimenti
*/
int emptyList(list L) {
    if (L == NULL)
        return 1;
    if ((L->first == NULL) || (L->size == 0))
        return 1;
    else
        return 0;
}

/*PROGETTAZIONE DI TAILLIST
Dizionario dei dati:
        lista di partenza: L
PROGETTAZIONE:
1. Creare un nuovo nodo di intestazione
2. Copiare nella nuova lista tutti i nodi a partire dal secondo della lista originale
3. Restituire la nuova lista
*/
list tailList(list L) {
    struct c_list *new = newList();
    if ((L->first == NULL) || (L->size == 0)) {
        new->first = NULL;
        new->size = 0;
    } else {
        int i = 0;
        struct node *curr = L->first->next;
        new->size = (L->size) - 1;
        while (curr != NULL) {
            insertList(new, i, curr->value);
            i++;
            curr = curr->next;
        }
    }
    return new;
}

/* PROGETTAZIONE DI CONSLIST
Dizionario dei dati:
        valore da inserire: val
        lista da modificare: L
PROGETTAZIONE:
1. Inserisce il valore nella prima posizione
2. Restituisce la lista modificata
*/
list consList(item val, list L) {
    insertList(L, 0, val);
    return L;
}
/* PROGETTAZIONE DI GETFIRST
Dizionario dei dati:
        lista da cui ottenere l'elemento: L
PROGETTAZIONE:
1. Controlla che la lista abbia almeno un elemento
2. Restituisce il valore se presente, altrimenti NULLITEM
*/
item getFirst(list L) {
    if (emptyList(L))
        return NULLITEM;
    else
        return L->first->value;
}

/*PROGETTAZIONE DI SIZELIST
Dizionario dei dati:
        lista di cui ottenere la taglia: L
PROGETTAZIONE:
1. Ottenere la taglia della lista e restituirla
*/
int sizeList(list L) {
    return L->size;
}

/*PROGETTAZIONE DI POSITEM
Dizionario dei dati:
        lista in cui cercare: L
        valore da cercare: val
PROGETTAZIONE:
1. Verifica che la lista esista
2. Scorre la lista fino alla fine, fermandosi se il valore viene trovato
3. Restituisce la posizione in cui si trova il valore, -1 altrimenti
*/
int posItem(list L, item val) {
    int i = 0, found = 0;
    if (emptyList(L))
        return -1;
    else {
        struct node *new = L->first;
        while ((i < L->size) && (new != NULL) && (!found)) {
            if (eq(new->value, val))
                found = 1;
            else {
                i++;
                new = new->next;
            }
        }
    }
    if (found == 1)
        return i;
    else
        return -1;
}

/*PROGETTAZIONE DI SEARCHITEM
Dizionario dei dati:
        lista in cui cercare l'elemento: L
        elemento da trovare: val
PROGETTAZIONE
1. Controlla che la lista esista e non sia nulla
2. Scorre la lista per intero, fermandosi se il valore viene trovato
3. Restituisce 1 nel caso il valore sia presente, 0 altrimenti
*/
int searchItem(list L, item val) {
    int i = 0, found = 0;
    if (emptyList(L))
        return 0;
    else {
        struct node *new = L->first;
        while ((i < L->size) && (new != NULL) && (!found)) {
            if (eq(new->value, val))
                found = 1;
            else {
                i++;
                new = new->next;
            }
        }
    }
    if (found == 1)
        return 1;
    else
        return 0;
}

/*PROGETTAZIONE DI REVERSELIST
Dizionario dei dati:
        lista da invertire: L
PROGETTAZIONE
1. Allocare un nuovo nodo di intestazione
2. Verificare che la lista di partenza esista e non sia vuota
3. Verificare che il nuovo nodo sia stato allocato
4. Scorrere la lista originale e ricopiare ogni nodo in testa alla nuova lista
5. Restituire la lista creata
*/
list reverseList(list L) {
    struct c_list *rev = newList();
    if ((emptyList(L)) || (!rev))
        return rev;
    else {
        struct node *curr = L->first;
        while (curr != NULL) {
            insertList(rev, 0, curr->value);
            curr = curr->next;
        }
    }
    return rev;
}

/*PROGETTAZIONE DI REMOVEITEM
Dizionario dei dati:
        lista da cui eliminare il valore: L
        valore da eliminare se presente: val
PROGETTAZIONE
1. Verificare che la lista esista e non sia vuota
2. Scorrere la lista fino alla fine, interrompendo nel caso il valore venga trovato
3. Restituire la lista risultante, sia che il valore venga rimosso o non venga trovato
*/
list removeItem(list L, item val) {
    int i = 0, found = 0;
    if (emptyList(L))
        return L;
    else {
        struct node *new = L->first;
        while ((i < L->size) && (new != NULL) && (!found)) {
            if (eq(new->value, val)) {
                removeNode(new, 0);
                found = 1;
            } else {
                i++;
                new = new->next;
            }
        }
    }
    return L;
}

/*PROGETTAZIONE DI GETITEM
Dizionario dei dati:
        lista da cui prendere il valore: L
        posizione da cui prendere il valore: pos
PROGETTAZIONE:
1. Verificare che lista e posizione siano validi
2. Scorrere la lista fino alla posizione cercata
3. Restituire il valore
*/
item getItem(list L, int pos) {
    if (emptyList(L))
        return NULLITEM;
    if ((pos < 0) || (pos > L->size))
        return NULLITEM;

    struct node *new = L->first;
    for (int i = 0; i < pos-1; i++) {
        new = new->next;
    }
    return new->value;
}

/*PROGETTAZIONE DI INSERTLIST
Dizionario dei dati:
        lista in cui inserire un elemento: L
        posizione in cui inserire il nuovo elemento: pos
        elemento da inserire: val
PROGETTAZIONE
1. Crea un nodo temporaneo (sarà una nuova funzione)
2. Aggiorna i campi del nodo di intestazione
3. Restituisce il valore corretto
*/
int insertList(list L, int pos, item val) {
    struct node *temp = insertNode(L->first, pos, val);
    if (temp == NULL)
        return 0;
    L->first = temp;
    L->size++;
    return 1;
}

/*SPECIFICA DI INSERTNODE
Scopo della funzione: Inserire un nodo in una lista
Dizionario dei dati:
        primo nodo della lista: l
        posizione in cui inserire il valore: pos
        valore da inserire: val
Precondizioni: Nessuna
Postcondizioni: La funzione restituisce la lista modificata se ha successo, NULL altrimenti
PROGETTAZIONE DI INSERTNODE
1. Alloca un nuovo nodo in cui salvare il valore
2. Scorre la lista fino a raggiungere la posizione precedene a quella cercata
3. Collega il nuovo nodo alla lista nel posto giusto
4. Restituisce il primo nodo della lista ora modificata, altrimenti NULL
*/
static struct node *insertNode(struct node *l, int pos, item val) {
    struct node *new, *prec = l;
    int i = 0;
    new = malloc(sizeof(struct node));
    if (!new)
        return NULL;
    new->value = val;
    if (pos == 0) {
        new->next = l;
        return new;
    }
    while ((i < (pos - 1)) && (prec != NULL)) {
        prec = prec->next;
        i++;
    }
    if (prec == NULL) {
        free(new);
        return NULL;
    }
    new->next = prec->next;
    prec->next = new;
    return l;
}

/*PROGETTAZIONE DI REMOVELIST
Dizionario dei dati:
        lista da cui rimuovere un elemento: L
        posizione dell'elemento: pos
PROGETTAZIONE
1. Controlla che il nodo di intestazione esista ed abbia campi validi
2. Controlla che il valore della posizione sia valido
3. Rimuovere il nodo (nuova funzione)
4. Aggiornare i valori del nodo di intestazione
*/
int removeList(list L, int pos) {
    if (emptyList(L))
        return 0;
    if ((pos < 0) || (pos > (L->size - 1)))
        return 0;
    L->first = removeNode(L->first, pos);
    L->size--;
    return 1;
}

/*SPECIFICA DI REMOVENODE
Scopo della funzione: Rimuovere un nodo da una lista
Dizionario dei dati:
        primo nodo della lista: l
        posizione del nodo da rimuovere: pos
Precondizioni: La lista esiste e non è vuota; la posizione è valida
Postcondizioni: Dalla lista risultante manca un nodo
PROGETTAZIONE DI REMOVENODE
1. Crea un nodo temporaneo
2. Scorre la lista fino alla posizione precedente a quella voluta
3. Scollega e libera il nodo di posizione pos
4. Restituisce il primo nodo della nuova lista
*/
static struct node *removeNode(struct node *l, int pos) {
    struct node *l1;
    if (pos == 0) {
        l1 = l;
        l = l->next;
        free(l1);
    } else {
        int i = 0;
        struct node *prec = l;
        while (i < (pos - 1)) {
            prec = prec->next;
            i++;
        }
        l1 = prec->next;
        prec->next = l1->next;
        free(l1);
    }
    return l;
}

/*PROGETTAZIONE DI INPUTLIST
Dizionario dei dati:
        lunghezza della lista: n
PROGETTAZIONE
1. Creo un nodo di intestazione
*/
list inputList(int n) {
    if (n < 0)
        return NULL;
    struct c_list *new = newList();
    if (new == NULL) {
        fprintf(stderr, "Errore durante l'allocazione\n");
        exit(-1);
    }
    if (n == 0)
        return new;
    else {
        item val;
        for (int i = 0; i < n; i++) {
            printf("Inserisci l'elemento di posizione %d", i);
            input_item(&val);
            insertList(new, i, val);
        }
    }
    return new;
}

/*PROGETTAZIONE DI OUTPUTLIST
Dizionario dei dati:
        lista da cui trarre i valori: L
PROGETTAZIONE:
1. Scorrere con un ciclo la lista, stampando un solo elemento per riga
*/
void outputListLercio(list L) {
    int i = 0;
    struct node *curr = L->first;
    item val;
    while (!emptyList(L)) {
        val = getFirst(L);
        printf("Elemento in posizione %d: ", i);
        output_item(val);
        i++;
        curr = curr->next;
    }
}

void outputList(list L) {
    item elemento;
    for (int i = 0; !emptyList(L); i++) {
        elemento = getFirst(L);

        printf("Elemento in posizione %d: ", i);
        output_item(elemento);
        printf("\n");

        L = tailList(L);
    }
}
