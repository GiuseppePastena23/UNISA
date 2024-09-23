#include <item.h>

typedef struct node *BST;

//Crea un BST vuoto
BST newBST();

//Verifica che un BST sia vuoto
int emptyBST(BST T);

//Restituiscono, rispettivamente, il figlio sinistro e il destro del nodo
BST figlioSX(BST T);
BST figlioDX(BST T);

//Inserisce un elemento elem all'interno di T
BST insert(BST T, item elem);

//Verifica la presenza di un certo elemento elem all'interno di T
int contains(BST T, item elem);

//Cancella, se presente, l'elemento elem da T
BST deleteNode(BST T, item elem);