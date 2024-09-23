#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "punto.h"
#include <math.h>

struct punto{
  double x;
  double y;
}punto;

typedef struct punto* Punto;

Punto creaPunto(double x, double y){
  /* Precondizioni: nessuno
     Postcondizioni: La funzione restituisce una struttura inizializzata
     Progettazione:
      1. Alloca dinamicamente la struttura
      2. Assegna i parametri ai campi della struttura
      3. Restituisce il puntatore
  */

  Punto p;

  p = malloc(1 * sizeof(struct punto));
  if(p == NULL){
    fprintf(stderr, "Errore nella allocazione");
    return NULL;
  }

  p->x = x;
  p->y = y;

  return p;
}

Punto inputPunto() {
  int x, y;
  printf("Inserisci ascissa");
  scanf("%lf", &x);
  printf("Inserisci ordinata");
  scanf("%lf", &y);
  if (x == -999 && y == -999) return NULL;
  return creaPunto(x, y);
}

double getAscissa(Punto p){
  /*Precondizioni: il paramentro p non è nullo;
    Postcondizioni: La funzione restituisce un double contenente l'ascissa
  */
  return p->x;
}

double getOrdinato(Punto p){
  /*Precondizioni: il paramentro p non è nullo;
    Postcondizioni: La funzione restituisce un double contenente l'ordinata
  */
  return p->y;
}

void stampaPunto(Punto p){
  /*
    Precondizioni: il paramentro p non è nullo;
    Postcondizioni: La funzione stampa tutti i campi del Punto in input;
  */
  printf("Ascissa: %f  Ordinata: %f\n", p->x, p->y);

}

double distanza(Punto p1, Punto p2){
  /* Precondizioni: i due punti p1 e p2 non sono nulli;
     Postcondizioni: la funzione ritorna un double contenente la distanza euclidea tra due punti;

  */
  return sqrt(pow((p1->y-p2->y),2) +  pow((p1->x-p2->x), 2));
}