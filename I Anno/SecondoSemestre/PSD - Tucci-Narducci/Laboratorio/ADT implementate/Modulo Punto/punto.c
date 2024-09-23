#include "punto.h"
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

struct punto {
	double x;	//ascissa del punto
	double y;	//ordinata del punto
};

/*PROGETTAZIONE
1. Alloca dinamicamente la struttura
2. Assegna i parametri ai campi della struttura
3. Restituisce il puntatore alla struttura se tutto va bene, NULL altrimenti*/
Punto creaPunto(double x, double y) {
	Punto p = malloc(1 * sizeof(struct punto));
	if(p == NULL) {
		fprintf(stderr, "Errore durante l'allocazione del Punto\n");
		return NULL;
	}
	p -> x = x;
	p -> y = y;
	return p;
}

/*PROGETTAZIONE
1. Chiedi all'utente l'ascissa e l'ordinata
2. Chiama la funzione per la creazione di un nuovo Punto
3. Restituisci il Punto appena creato*/
Punto inputPunto() {
	double x, y;
	printf("Inserisci l'ascissa:\n");
	scanf("%lf", &x);
	printf("Inserisci l'ordinata:\n");
	scanf("%lf", &y);
	return creaPunto(x, y);
}

/*PROGETTAZIONE
1. Restituire il campo contenente l'ascissa del Punto p*/
double getAscissa(Punto p) {
	return p -> x;
}

/*PROGETTAZIONE
1. Restituire il campo contenente l'ordinata del Punto p*/
double getOrdinata(Punto p) {
	return p -> y;
}

/*PROGETTAZIONE
1. Stampare le coordinate del Punto p*/
void stampaPunto(Punto p) {
	printf("L'ascissa è: %lf\n", getAscissa(p));
	printf("L'ordinata è: %lf\n", getOrdinata(p));
}

/*PROGETTAZIONE
1. Trovare le differenze di ascissa e ordinata
2. Calcolare la radice della somma dei loro quadrati
3. Restituire il risultato*/
double distanza(Punto p1, Punto p2) {
	double xDiff, yDiff;
	xDiff = getAscissa(p1) - getAscissa(p2);
	yDiff = getOrdinata(p1) - getOrdinata(p2);
	return sqrt((xDiff * xDiff) + (yDiff * yDiff));
}