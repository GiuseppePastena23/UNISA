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