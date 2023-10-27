#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <stdlib.h>

#define MAXLEN 512




int main() {
    char buf[MAXLEN];
    int pid, status;
    char arg1[10];
    char arg2[10];
    char arg3[10];
    char arg4[10];
    char arg5[10];
    char arg6[10];

    printf("$ "); 
    while (scanf("%s %s %s %s %s", buf, arg1, arg2, arg3, arg4, arg5, arg6) != 0) {

        
        if ((pid = fork ()) < 0) {
            printf("ERRORE DI SISTEMA: fork\n");
            exit(1);
        }
        
        // processo figlio
        else if (pid == 0) {
            if (execlp(buf, buf, arg1, arg2, arg3, arg4, arg5, arg6, NULL) == -1) {
            	// errore in exec
                printf("ERRORE : non posso eseguire %s\n", buf);
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
