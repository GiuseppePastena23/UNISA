#include "coda.h"
#include "item.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

queue coda_punti() {

    printf("Inserisci dei punti all'interno della lista (-999 -999 per terminare): \n");
    do
    {
        item elemento = inputItem();
        if (elemento == NULL)
    } while ();
    
}

// FILE.H
/*
SPECIFICA SINTATTICA:
sottocode(coda) -> coda, coda, coda, coda

SPECIFICA SEMANTICA:
sottocoda(coda) -> Q1, Q2, Q3, Q4

PRECONDIZIONI:
nessuna

POSTCONDIZIONI:
4 code contenenti n elementi con n >= 0
coda in input liberata


(il caso del punto (0, 0) è il primo quadrante)
*/
void sottocode(queue *coda, queue *Q1, queue *Q2, queue *Q3, queue *Q4);

// FILE.C
/*
PROGETTAZIONE:
1.0 finché la coda non viene svuotata:
    1.1 estraggo l'elemento e ottengo ascissa e ordinata
    1.2 se l'ascissa è >= 0:
        1.1.1 se anche l'ordinata è >= 0 allora inserisco l'elemento nel primo quadrante
        ...
2.0 dealloco la coda
*/
void sottocode(queue *coda, queue *Q1, queue *Q2, queue *Q3, queue *Q4) {
    item el;
    double ascissa, ordinata;

    while (!emptyQueue(*coda)) 
    {
        el = dequeue(*coda);
        ascissa = getAscissa(el);
        ordinata = getOrdinata(el);
        if (ascissa >= 0)
        {
            if (ordinata >= 0) {
                enqueue(el, *Q1);
            }
            else {
                enqueue(el, *Q4);
            }
        }

        else // ascissa < 0
        {
            if (ordinata >= 0) {
                enqueue(el, *Q2);
            }
            else {
                enqueue(el, *Q3);
            }
        }
    }
    
    free(coda);
}
