// ITEM.C

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "item.h"

struct esame {
    char nome_esame[50];
    int voto;
    char data[8];
};

item new_item(char nome_esame[], int voto, char data[]) {
    item nuovo = malloc(sizeof(struct esame));
    if (nuovo == NULL) return NULL;

    strcpy(nuovo->nome_esame, nome_esame);
    nuovo->voto = voto;
    strcpy(nuovo->data, data);
    return nuovo;
}

//as boolean
int freeItem(item a) {
    free(a);
}

// as boolean
int eq(item a, item b) {
    if (a == NULL || b == NULL) return 0;
    
    int check_nomi = strcmp(a->nome_esame, b->nome_esame);
    int check_date = strcmp(a->data, b->data);
    int check_voti = a->voto == b->voto;

    return check_nomi && check_date && check_voti;
}

item input_item() {
    char nome[50];
    int voto;
    char data[8];

    printf("Inserisci il nome dell'esame: ");
    fgets(nome, 50, stdin);

    printf("Inserisci il voto: ");
    scanf("%d", &voto);

    printf("Inserisci la data dell'esame (GGMMAAAA): ");
    fgets(data, 8, stdin);
    
    return new_item(nome, voto, data);
}

void output_item(item a) {
    printf("Nome esame: %s\n", a->nome_esame);
    printf("Voto: %d\n", a->voto);
    printf("Data: %s\n", a->data);
}

char *getNome(item a) {
    return a->nome_esame;
}