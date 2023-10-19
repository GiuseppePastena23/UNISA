#include <stdio.h>
#include <string.h>
#include <unistd.h>

#define MAXLEN 512

int main() {
    char buf[MAXLEN];
    int pid, status;
    printf("%%"); /*prompt*/
    while (fgets(buf, 512, stdin) != NULL) {
        buf[strlen(buf) - 1] = 0; /*sostituisce newline con NULL */
        if ((pid = fork ()) < 0) {
            printf("ERRORE DI SISTEMA: fork\n");
            exit(1);
        }
        else if (pid == 0) { /* processo figlio*/
            if (execlp(buf, buf, (char *) 0) == -1) {
                printf("ERRORE : non posso eseguire %s\n", buf);
                exit(1);
            }
            exit(0);
        }
        if ((pid = waitpid(pid, &status, 0)) < 0) /* padre */ {
            printf("ERRORE DI SISTEMA: waitpid\n");
            exit(1);
        }
        printf("%%");
    }
    exit(0);
}
