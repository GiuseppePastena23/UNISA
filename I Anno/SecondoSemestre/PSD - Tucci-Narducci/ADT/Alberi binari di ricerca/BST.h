/* ALBERI BINARI DI RICERCA
L'albero vuoto è un albero binario di ricerca
Se l'albero non è vuoto allora ogni elemento del sottoalbero sx precede la radice;
ogni elemento del sottoalbero dx segue la radice;
i sottoalberi sx e dx sono alberi binari di ricerca.
N.B. non sono presenti elementi ripetuti */

/* In un albero di ricerca binaria perfettamente bilanciato tutti i nodi interni hanno entrambi i sottoalberi
e le foglie sono a livello massimo; ne deriva che un nodo può avere solo 2 o 0 figli
ed il numero di nodi equivale a 2^n -  1. L'altezza dell'albero è log2 n.
Un albero di ricerca binaria si dice Delta bilanciato se per ogni nodo la differenza
delle altezze dei suoi due sottoalberi è minore o uguale a Delta;
l'altezza dell'albero diventa quindi Delta + log2 n.

Per Delta = 1 si hanno alberi 1-bilanciati o Alberi AVL, dal nome degli ideatori.
Per prevenire il non bilanciamento vanno valutati gli sbilanciamenti di ogni nodo:
si assegna -1 se è più alto il sottoalbero sx, 0 se sono uguali e 1 se è più alto il dx. (Sbilanciamento = H dx - H sx)
Quando si inserisce una foglia si può generare uno sbilanciamento, dunque
ad ogni inserimento\rimozione c'è bisogno di eseguire delle operazioni
per ribilanciare l'albero con delle operazioni di rotazione(semplice o doppia), il cui costo è log2 di n. */
#include "item.h"

typedef struct node *BST;

/*ANALISI E SPECIFICA DI newBST
newBST(void) -> BST
newBST(void) -> T
precondizioni: Nessuna
postcondizioni: T è l'albero vuoto
*/
BST newBST(void);

/*ANALISI E SPECIFICA DI emptyBST
emptyBST(BST) -> int
emptyBST(T) -> 1/0
precondizioni: Nessuna
postcondizioni: La funzione restituisce 1 se l'albero è vuoto, 0 altrimenti
*/
int emptyBST(BST T);

/*ANALISI E SPECIFICA DI figlioSX
figlioSX(BST) -> BST
figlioSX(T) -> T'
precondizioni: T = <N, Tsx, Tdx> non e' l'albero vuoto
postcondizioni: T = Tsx
*/
BST figlioSX(BST T);

/*ANALISI E SPECIFICA DI figlioDX
figlioDX(BST) -> BST
figlioDX(T) -> T'
precondizioni: T = <N, Tsx, Tdx> non e' l'albero vuoto
postcondizioni: T = Tdx
*/
BST figlioDX(BST T);

/*ANALISI E SPECIFICA DI insert
insert(BST, item) -> BST
insert(T, elem) -> T'
precondizioni: Nessuna (è sempre possibile inserire) (N.B. usare sempre bst = insert(bst, elem))
postcondizioni: T' si ottiene inserendo l'item in T come foglia, altrimenti, se già presente, T resta invariato
*/
BST insert(BST T, item elem);

/*ANALISI E SPECIFICA DI contains
contains(BST, item) -> int
contains(T, elem) -> 1/0
precondizioni: Nessuna
postcondizioni: Se l'elemento è presente nell'albero restituisce 1, 0 altrimenti
*/
int contains(BST T, item elem);

/*ANALISI E SPECIFICA DI delete
delete(BST, item) -> BST
delete(T, elem) -> T'
precondizioni: Nessuna
postcondizioni: T' si ottiene rimuovendo l'elemento cercato da T, altrimenti, se l'elemento non è presente, T resta invariato.
*/
BST delete(BST T, item elem);
