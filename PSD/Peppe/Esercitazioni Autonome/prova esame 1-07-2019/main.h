#include "coda.h"
#include "item.h"

/*
SPECIFICA SINTATTICA
cancFinoItem(queue, item) -> int

SPECIFICA SEMANTICA
cancFinoItem(queue Q, item el) = N
pre: -
post: tutti gli elementi nella coda che precedono el vengono eliminati
se non esiste el vengono eliminati tutti gli elementi
*/
int cancFinoItem(queue Q, item el);