/*Scriviamo una funzione      Paziente * solo_magri(Paziente * pazienti, int n, int * nmagri)
che prende in input un array pazienti[] di n oggetti di tipo Paziente e restituisce un
nuovo array contenente soltanto i pazienti con un BMI che non supera 18.5 kg/m2.
Il risultato sarà allocato dinamicamente in dipendenza del numero di elementi che soddisfano
la condizione. Il parametro output nmagri rifletterà la dimensione dell’array risultato. Nel caso 
nessun elemento soddisfi la condizione, la funzione solo_magri() ritornerà NULL e imposterà nmagri a zero.*/
/*Con riferimento all’esercizio precedente, scrivere una funzione      int lista_normali(FILE *fout, Paziente pazienti[], int n)
che, ricevendo un vettore pazienti[] di n oggetti Paziente, per ogni paziente con BMI
compreso fra 18.5 e 24.9 kg/m2 scrive in un file di testo già aperto (e puntato da fout) una
riga con nome, statura e peso separati da spazi. La funzione lista_normali() restituisce
1 se tutto è andato bene, 0 se c’è stato qualche errore.*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "xmalloc.h"

typedef struct {
char nome[50]; 					// nome, cognome o pseudonimo
double peso; 					// in kg
double statura; 				// in m
} Paziente;

Paziente * solo_magri(Paziente * pazienti, int n, int * nmagri);
double BMI(Paziente *p);
void riempi_struct(Paziente *dest, Paziente *src);
int lista_normali(FILE *fout, Paziente pazienti[], int n);


Paziente * solo_magri(Paziente * pazienti, int n, int * nmagri)
{
	*nmagri = 0;
	for(int i=0; i<n; i++)
	{
		if(BMI(&pazienti[i])<18.5)
		{
			(*nmagri)++;
		}
	}
	if((*nmagri) == 0)
	{
		printf("Non sono presenti pazienti magri\n");
		return NULL;
	}
	Paziente *A = xmalloc((*nmagri) * sizeof(Paziente));
	for(int i=0, j=0; i<n; i++)
	{
		if(BMI(&pazienti[i])<18.5)
		{
			//A[j++] = pazienti[i];
			riempi_struct(&A[j++], &pazienti[i]);
		}
	}
	return A; 
}

double BMI(Paziente *p)
{
	double bmi = p->peso / ((p->statura) * (p->statura));
	return bmi;
}

void riempi_struct(Paziente *dest, Paziente *src)
{
	//strcpy(dest->nome, src->nome);
	char * newname = strdup(src->nome); 
	dest->peso = src->peso;
	dest->statura = src->statura;
}

int lista_normali(FILE *fout, Paziente pazienti[], int n)
{
	//file già aperto e controllato
	for(int i=0; i<n; i++)
	{
		if((BMI(&pazienti[i])>18.5) && (BMI(&pazienti[i])<24.9));
		{
			fprintf(fout, "%s ", pazienti->nome);
			fprintf(fout, "%f ", pazienti->peso);
			fprintf(fout, "%f\n", pazienti->statura);
		}
	}
	return 1;
}