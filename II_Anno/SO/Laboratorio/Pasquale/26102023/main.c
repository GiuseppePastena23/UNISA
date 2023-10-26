#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

#define CURSOR '$'
#define MAX_LEN 20
#define MAX_ARGS 5

/*
cmd arg1 arg2 
["cmd", "arg1", "arg2"]

[c][m][d][][][][][][][][][][][][]
[a][r][g][1][][][][][][][][][][][]
[a][r][g][2][][][][][][][][][][][]
[][][][][][][][][][][][][][][]
[][][][][][][][][][][][][][][]
[][][][][][][][][][][][][][][]
*/

char **read_command() {
    char *buff = (char *) malloc(MAX_LEN * sizeof(char));
    
    // creazione matrice
    char **string_array;
    string_array = malloc(MAX_ARGS+1 * sizeof(char));
    for (int i = 0; i < MAX_ARGS+1; i++) {
        string_array[i] = malloc(MAX_LEN * sizeof(char));
    }

    
}

int main() {
    int figlio;


    while(true) {
        printf(CURSOR);

        figlio = fork();
        


    }



}
