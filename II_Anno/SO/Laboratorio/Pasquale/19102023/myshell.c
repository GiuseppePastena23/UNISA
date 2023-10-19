/*

*/

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <string.h>

#define MAX_LENGTH 100 


char *prompt() {
    char *str = (char *) malloc(sizeof(char) * MAX_LENGTH);
    printf("%%");
    scanf("%s", str);
    printf("\n");
    return str;
}


int main(int argc, char const *argv[])
{
    char *command;
    while (1)
    {
        command = prompt();

        int figlio = fork();
        // PROCESSO FIGLIO
        if (figlio == 0) {
            if (execlp(command, NULL) == -1) {
                printf("Errore\n");
            }
        }
        else {
            wait(NULL);
        }

        free(command);
    }
    return 0;
}
