/*La prima funzione legge un file binario e salva tutto in un array di struct che restituirà*/
/*La seconda funzione crea un nuovo array contenente esclusivamente le vendite appartenenti ad un certo venditore*/
//ogni tipo di errore va riportato sullo stderr
//un vero pro scriverebbe una funzione apposita per la stampa degli errori

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
//xmalloc andrebbe modificata per restituire NULL anziché terminare il programma 

typedef struct vendita {
	char desc[50];
	double prezzo;
	double quant;
	char venditore[15];
} Vendita;

void error_manager(int n);
Vendita * load_vendite (FILE *fp, int *n);
void copia_vendita(Vendita *dest, Vendita *src);
Vendita * elenco_venditore (FILE *fin, char *id_venditore, int *nv);

void error_manager(int n)
{
	if(n == -1)
	{
		fprintf(stderr, "Errore durante l'allocazione");
	}
	if(n == -2)
	{
		fprintf(stderr, "Errore nel formato del file");
	}
	if(n == -3)
	{
		fprintf(stderr, "Non sono presenti vendite relative al venditore indicato");
	}
	if(n == -4)
	{
		fprintf(stderr, "Errore dovuto ad un diverso numero di elementi presenti");
	}
}

Vendita * load_vendite (FILE *fp, int *n)
{
	int lenght;
	if (fread(&lenght, sizeof(int), 1, fp) != 1)	//assumendo che il file sia già stato aperto e non necessiti di controlli
	{
		error_manager(-2);
		*n = 0;
		return NULL;
	}
	if(feof(fp))
	{
		error_manager(-4);
		*n = 0;
		return NULL;
	}
	Vendita *vendite = calloc(lenght, sizeof(Vendita));
	if(vendite == NULL)
	{
		error_manager(-1);
		*n = 0;
		return NULL;
	}
	for(int i=0; i<lenght; i++)
	{
		if(fread(&vendite[i].desc, sizeof(vendite[i].desc), 1, fp) != 1)
		{
			error_manager(-2);
			*n = 0;
			free(vendite);
			return NULL;
		}
		if(fread(&vendite[i].prezzo, sizeof(double), 1, fp) != 1)
		{
			error_manager(-2);
			*n = 0;
			free(vendite);
			return NULL;
		}
		if(fread(&vendite[i].quant, sizeof(double), 1, fp) != 1)
		{
			error_manager(-2);
			*n = 0;
			free(vendite);
			return NULL;
		}
		if(fread(&vendite[i].venditore, sizeof(vendite[i].venditore), 1, fp) != 1)
		{
			error_manager(-2);
			*n = 0;
			free(vendite);
			return NULL;
		}
	}
	*n = lenght;
	return vendite;		//assumendo che il file non debba essere chiuso
}

void copia_vendita(Vendita *dest, Vendita *src)
{
	strcpy(dest->desc, src->desc);
	dest->prezzo = src->prezzo;
	dest->quant = dest->quant;
	strcpy(dest->venditore, src->venditore);
}

Vendita * elenco_venditore (FILE *fin, char *id_venditore, int *nv)
{
	int size;
	Vendita *tutte_vendite = load_vendite(fin, &size);	//assumendo che il file sia stato già aperto e non necessiti di controllo
	int counter = 0;
	for(int i=0; i<size; i++)
	{
		if(strcmp(tutte_vendite[i].venditore, id_venditore) == 0)	//se le stringhe sono uguali
		{
			counter++;
		}
	}
	if(counter == 0)
	{
		error_manager(-3);
		*nv = 0;
		free(tutte_vendite);
		return NULL;
	}
	Vendita *sole_vendite = calloc(counter, sizeof(Vendita));
	if(sole_vendite == NULL)
	{
		error_manager(-1);
		*nv = 0;
		free(tutte_vendite);
		return NULL;
	}
	for(int i=0, j=0; i<size; i++)
	{
		if(strcmp(tutte_vendite[i].venditore, id_venditore) == 0)
		{
			copia_vendita(&sole_vendite[j], &tutte_vendite[i]);
			j++;
		}
	}
	*nv = counter;
	free(tutte_vendite);
	return sole_vendite;		//assumendo che il file non vada richiuso
}