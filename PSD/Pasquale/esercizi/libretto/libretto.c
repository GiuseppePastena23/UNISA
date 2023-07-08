#include "libretto.h"
#include "modules/list.h"

#include <stdlib.h>
#include <string.h>


struct libretto_tag
{
    char cognome[50];
    char nome[50];
    int matricola;
    list esami;
};

libretto newLibretto(int matricola, char cognome[], char nome[]) {
    libretto nuovo = (struct libretto_tag *) malloc(sizeof(struct libretto_tag));
    if (nuovo == NULL) return NULL;
    nuovo->matricola = matricola;
    strcpy(nuovo->cognome, cognome);
    strcpy(nuovo->nome, nome);
    nuovo->esami = newList();
    return nuovo;
}

libretto addEsame(libretto lib, item esame) {
    int i_coda = sizeList(lib->esami);
    insertList(lib->esami, i_coda, esame); 
}

list dammiEsami(libretto lib) {
    return lib->esami;
}

item cercaEsame(libretto lib, char nome_cercato[]) {
    int trovato = 0;
    int dimensione = sizeList(lib->esami);
    list lista = lib->esami;
    item esame;
    for (int i = 0; i < dimensione && !trovato; i++) {
        esame = getItem(lista, i);
        char *nome_esame = getNome(esame);
        if (strcmp(nome_esame, nome_cercato) == 0) {
            trovato = 1;
            break;
        }
    }

    return trovato ? esame : NULLITEM;
}
