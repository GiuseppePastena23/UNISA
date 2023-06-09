/*
Dato un BTree, scrivere una funzione int altezza_pari(Btree T) che restituisce il conteggio (il numero) 
di tutti i nodi che a partire dalla radice si trovano ad altezza pari nell'albero. 
(Nota: la radice va considerata ad altezza zero). Tips: potete usare un ADT di supporto
*/

#include <stdio.h>
#include <stdlib.h>

#include "Btree.h"

/*
SPECIFICA SINTATTICA:
altezza_pari_helper(BTREE, LIVELLO) -> INTERO
SPECIFICA SEMANTICA:
altezza_pari_helper(Btree T, int livello) -> int
PRECONDIZIONI:
T non nullo (già controllata dalla funzione caller)
POSTCONDIZIONI:
numero nodi a livello pari 

PROGETTAZIONE:
PASSO BASE: se l'albero è vuoto ritorna 0
PASSO RICORSIVO:
    se il nodo si trova a livello pari aumenta il contatore di uno
    conta i nodi a livello pari nei livelli successivi
*/
int altezza_pari_helper(Btree T, int livello) {
    int contatore = 0;
    if (emptyBtree(T)) return contatore;
    

    if (livello % 2 == 0) {
        contatore = 1;
    }

    contatore += altezza_pari_helper(figlioSX(T), livello+1);
    contatore += altezza_pari_helper(figlioDX(T), livello+1);
    return contatore;
}

/*
SPECIFICAZIONE SINTATTICA:
altezza_pari(BTREE) -> INTERO
SPECIFICAZIONE SEMANTICA:
altezza_pari(Btree T) -> int
PRECONDIZIONI:
    -
POSTCONDIZIONI:
numero nodi a livello pari 

PROGETTAZIONE:
1.0 controllo se T è nullo
    ritorno -1 per segnalare l'errore
2.0 ritorno altezza_pari_helper(Btree, int) passando l'albero e 0 come livello iniziale 
*/
int altezza_pari(Btree T) {
    if (T == NULL) return -1;
    return altezza_pari_helper(T, 0);
}

