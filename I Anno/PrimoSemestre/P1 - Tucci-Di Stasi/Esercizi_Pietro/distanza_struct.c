/*Le struct sono aggregazioni di dati, un p' come gli array, ma possono contenere anche tipi diversi
si usa typedef struct per definire la struttura (definendo a tutti gli effetti un nuovo tipo) e renderla nota a tutto il programma
nelle parentesi graffe vanno inseriti i diversi campi, cioè le variabili che la struttura contiene
chiuse le parentesi va inserito il nome della struttura*/
/*L'allocazione dinamica dinamica della memoria serve ad allocare memoria durante l'esecuzione del programma
ovviando al problema delle dimensioni fissate di array ed altre strutture dati
La memoria è divisa in stack, da cui il programma prende in maniera automatica una porzione di memoria ad ogni chiamata di funzione,
ed heap, che viene usato esclusivamente all'allocazione dinamica
Quando un oggetto alloc. din. ha svolto il suo compito e non serve più, va manualmente deallocato:
si usa free(), e tra parentesi va inserito il puntatore.*/
/*L10: Passaggio di record (strutture) come parametri
Questo progrogramma calcola la distanza tra due punti con il teorema di Pitagora*/

#include <stdio.h>
#include <stdlib.h>			//libreria di malloc, calloc e realloc - le funzioni per alloc. din. 
#include <math.h>			//da qui viene presa la funzione sqrt per estrarre la radice quadrata
#include "xmalloc.h"		//funzione non di libreria, da includere usando i doppi apici
//xmalloc alloca usando malloc e poi esegue anche un controllo per verificare che tutto sia andato bene, facendo risparmiare alcune righe di codice

int main();
struct punto *creaPunto(double xx, double yy);
double distanza(struct punto *p1, struct punto *p2);

typedef struct punto {
	double x, y;
} Punto;

int main()
{
	double dist;
	struct punto *origine, *centro;		//vengono dichiarati due puntatori a struttura - si può scrivere anche Punto *origine
	//N.B.: ad essere allocato è il puntatore in sé, ma non la struttura, questo avviene con la funzione creaPunto
	
	origine = creaPunto(0, 0);
	centro = creaPunto(3.1, 4.7);
	dist = distanza(origine, centro);
	printf("%lf", dist);
	return 0;
}

struct punto *creaPunto(double xx, double yy)
{
	struct punto *p = xmalloc(sizeof(Punto));		//il puntatore va allocato dinamicamente in modo da poter essere restiuito dalla funzione
	p->x = xx;		//si assegna al campo x della struct il valore xx tramite l'operatore freccia ->
	p->y = yy;		//si assegna al campo y della struct il valore yy tramite l'operatore freccia ->
	//l'operatore -> viene usato per comodità in quanto dai programmatori in quanto serve a compattare la scrittura (*p).x

	printf("%f\n",p->x);		//stampe di controllo per verificare che le cose siano andate a buon fine
	printf("%f\n",p->y);
	
	return p;
}

double distanza(struct punto *p1, struct punto *p2)
{
	double d, xdiff, ydiff;
	
	xdiff = p1->x - p2->x;		//differenza tra le ascisse, sempre usando -> per accedere ai campi della rispettiva struttura
	ydiff = p1->y - p2->y;
	d = sqrt(xdiff*xdiff + ydiff*ydiff);
	return d;
}