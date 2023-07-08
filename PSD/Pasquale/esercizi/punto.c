#include "punto.h"

#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct punto_tag {
    double x;
    double y;
};

punto new_punto(double x, double y) {
    punto p;

    p = malloc(1 * sizeof(struct punto_tag));
    if (p == NULL) {
        fprintf(stderr, "Errore nella allocazione");
        return NULL;
    }

    p->x = x;
    p->y = y;

    return p;
}

punto input_punto() {
    int x, y;
    printf("Inserisci ascissa");
    scanf("%lf", &x);
    printf("Inserisci ordinata");
    scanf("%lf", &y);
    if (x == -999 && y == -999) return NULL;
    return creapunto(x, y);
}

double getAscissa(punto p) {
    /*Precondizioni: il paramentro p non è nullo;
      Postcondizioni: La funzione restituisce un double contenente l'ascissa
    */
    return p->x;
}

double getOrdinato(punto p) {
    /*Precondizioni: il paramentro p non è nullo;
      Postcondizioni: La funzione restituisce un double contenente l'ordinata
    */
    return p->y;
}

void stampapunto(punto p) {
    /*
      Precondizioni: il paramentro p non è nullo;
      Postcondizioni: La funzione stampa tutti i campi del punto in input;
    */
    printf("Ascissa: %f  Ordinata: %f\n", p->x, p->y);
}

double distanza(punto p1, punto p2) {
    /* Precondizioni: i due punti p1 e p2 non sono nulli;
       Postcondizioni: la funzione ritorna un double contenente la distanza euclidea tra due punti;

    */
    return sqrt(pow((p1->y - p2->y), 2) + pow((p1->x - p2->x), 2));
}
