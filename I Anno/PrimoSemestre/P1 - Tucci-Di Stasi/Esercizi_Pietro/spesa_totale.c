/*Realizzare una funzione			Acquisto *leggi_acquisti(FILE *fin, int *n_acquisti)
che riceve come parametro un file di testo fin già aperto per la lettura e restituisce un array
allocato dinamicamente contenente i dati di tipo Acquisto letti dal file. Il parametro output 
n_acquisti viene usato dalla funzione per comunicare il numero di oggetti letti, ossia la
dimensione dell’array creato. Per semplicità, assumiamo che le descrizioni non contengano mai spazi.
2. Realizzare una funzione			double spesa_totale(Acquisto scontrino[], int n)
che riceve come parametro un array scontrino[] di oggetti Accquisto con la sua taglia n,
e restituisce l’importo totale degli acquisti, ovvero la somma di tutti i subtotali ottenuti
moltiplicando i prezzi unitari per le rispettive quantità.
Facoltativo: definire una funzione subtotale(Acquisto *articolo) per risolvere il sottoproblema del subtotale 
relativo all’acquisto di un solo articolo; usarla in spesa_totale(). Notare che in questo caso, la struttura articolo è passata per riferimento.*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "xmalloc.h"

typedef struct acquisto
{
char descrizione[30];
double quantita;
double prezzo_unitario;
} Acquisto;

Acquisto *leggi_acquisti(FILE *fin, int *n_acquisti);
double subtotale(Acquisto *p);
double spesa_totale(Acquisto scontrino[], int n);

Acquisto *leggi_acquisti(FILE *fin, int *n_acquisti)
{
	Acquisto *dato_letto;
	int n;
	fscanf(fin, "%d", &n);	//n contiene il numero di oggetti
	dato_letto = xmalloc(n * sizeof(Acquisto));
	for(int i=0; i<n; i++)
	{
		fscanf(fin, "%s", dato_letto[i].descrizione);
		fscanf(fin, "%lf", &dato_letto[i].quantita);
		fscanf(fin, "%lf", &dato_letto[i].prezzo_unitario);
	}
	*n_acquisti = n;
	return dato_letto;
}

double subtotale(Acquisto *p)
{
	return p->quantita * p->prezzo_unitario;
}

double spesa_totale(Acquisto scontrino[], int n)
{
	double tot = 0.0;
	for(int i=0; i<n; i++)
	{
		tot = tot + subtotale(&scontrino[i]);
	}
	return tot;
}