#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main()
{
    pid_t figlio1, figlio2;

    figlio1 = fork();
    if (figlio1 == 0) {
        printf("[Figlio1]: il mio pid: %d\n", getpid());
        for (int i = 1; i <= 50; i++) printf("%d ", i);
        printf("\n");
        exit(0);
    }
    else {
        figlio2 = fork();
        if (figlio2 == 0) {
            printf("[Figlio2]: pid padre: %d\n", getppid());
            for (int i = 101; i <= 150; i++) printf("%d ", i);
            printf("\n");
            exit(0);
        }
        else {
            // padre
            printf("[Padre]: figlio1 con pid(%d) morto\n", waitpid(figlio1, NULL, 0));
            printf("[Padre]: figlio2 con pid(%d) morto\n", waitpid(figlio2, NULL, 0));
        }
    }
    
    return 0;
}
