/*
Considerate di avere due stack S1 e S2. Scrivere una funzione stack COMUNI (stack s1, stack s2) tale che RESTITUISCA UN NUOVO STACK
che contenga esclusivamente gli item comuni ai due stack (l'intersezione di S1 e S2).
Attenzione: Al termine della fuzione S1 e S2 devono risultare INVARIATI (INVARIATO != IMMUTATO).
Esempio s1 = A|B|C|D s2 = C|D|Z   ==> s3 = C|D
*/

#include <stdio.h>
#include <stdlib.h>

#include "list.h"
#include "stack.h"

/*
SPECIFICA SINTATTICA:
converti pila in lista (PILA) -> LISTA
SPECIFICA SEMANTICA:
stack_to_list(stack s) -> list
PRECONDIZIONI:
stack s non nullo
POSTCONDIZIONI:
s = <a0, a1, ..., an>    l = <a0, a1, ..., an>
s non verrà alterato

PROGETTAZIONE:
1.0 per ogni elemento dello stack
    1.1 lo inserisco nella lista
2.0 per ogni elemento della lista in senso inverso
    2.1 lo inserisco nello stack
3.0 ritorno la lista
*/
list stack_to_list(stack s) {
    list l = newList();
    int i = 0;

    // metto gli elementi in una lista
    for (; !emptyStack(s); i++) {
        insertList(l, i, top(s));
        pop(s);
    }

    // restore s in ordine pushando gli elementi in ordine inverso
    for (; i >= 0; i--) {
        push(getItem(l, i), s);
    }

    return l;
}

/*
SPECIFICA SINTATTICA:
comuni(PILA, PILA) -> PILA

SPECIFICA SEMANTICA:
stack_comuni(stack s1, stack s2) -> stack

PRECONDIZIONI:
s1 e s2 non nulli
nello stesso stack non ci possono essere elementi ripetuti
POSTCONDIZIONI:
s1 = <a0, a1, ..., an>     s2 = <b0, b1, ..., bn>
allora s3 = s1 INTERSEZIONE s2

PROGETTAZIONE:
1.0 copio gli stack in due liste l1 e l2 (RAFFINAMENTO NELLA FUNZIONE stack_to_list) e ottengo la loro dimensione
2.0 per ogni elemento in l1:
    2.1 lo comparo per ogni elemento in l2:
        2.2 se sono uguali lo inserisco in s3
3.0 libero le liste ausiliarie
4.0 ritorno s3
*/
stack stack_comuni(stack s1, stack s2) {
    stack s3 = newStack();
    list l1 = stack_to_list(s1);
    list l2 = stack_to_list(s2);
    int size1 = sizeList(l1);
    int size2 = sizeList(l2);

    // find common elements
    for (int i = 0; i < size1; i++) {
        item a = getItem(l1, i);
        for (int j = 0; j < size2; j++) {
            item b = getItem(l2, j);
            if (eq(a, b)) {
                push(a, s3);
            }
        }
    }

    free(l1);
    free(l2);
    return s3;
}

int main(int argc, char const *argv[])
{
    return 0;
}
