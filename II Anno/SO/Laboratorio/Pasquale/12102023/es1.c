#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main()
{
    pid_t figlio1, figlio2;
    figlio1 = fork();

    // figlio1
    if (figlio1 == 0) {
        printf("[figlio1] - mio pid: %d\n", getpid());
        printf("[figlio1] - pid mio padre: %d\n", getppid());
    }
    else {
        figlio2 = fork();
        
        // figlio 2
        if (figlio2 == 0) {
            printf("[figlio2] - somma pid mio e padre: %d\n", getpid() + getppid());
        }

        // padre
        else {
            waitpid(figlio1, NULL, 0);
            waitpid(figlio2, NULL, 0);
            printf("[Padre]: figlio1: %d, figlio2: %d\n", figlio1, figlio2);
        }
    }


    return 0;
}

