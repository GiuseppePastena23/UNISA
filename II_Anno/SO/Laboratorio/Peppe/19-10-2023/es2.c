#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <stdlib.h>

#define MAXLEN 512

int main() {
    char buf[MAXLEN];
    char arg[MAXLEN];
    int pid, status;
    
    printf("$ "); 
    while (scanf("%s %s", &buf, &arg) > 1) {
    
        //buf[strlen(buf) - 1] = 0; /*sostituisce newline con NULL, solo per fgets!*/
        if ((pid = fork ()) < 0) {
            printf("ERRORE DI SISTEMA: fork\n");
            exit(1);
        }
        
        // processo figlio
        else if (pid == 0) { 
            if (execlp(buf, buf, arg, (char *) 0) == -1) {
            	// errore in exec
                printf("ERRORE : non posso eseguire %s %s\n", buf, arg);
                exit(1);
            }
            // nessun errore in exec
            exit(0);
        }
        // processo padre
        if ((pid = waitpid(pid, &status, 0)) < 0) /* padre */ {
        	
            printf("ERRORE DI SISTEMA: waitpid\n");
            exit(1);
        }
        printf("$ ");
        
    }
    exit(0);
}
