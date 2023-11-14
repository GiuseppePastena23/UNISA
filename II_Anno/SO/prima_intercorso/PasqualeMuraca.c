#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main() {
    pid_t F1, F2;
    F1 = fork();
    // effettuare i controlli sulla riuscita della fork

    // FIGLIO 1
    if (F1 == 0) {
        printf("[FIGLIO1]: il mio pid e': %d\n", getpid());
        for (int i = 1; i <= 5000; i++) {
            printf("%d\n", i);
        }
        exit(EXIT_SUCCESS);
    }

    // PADRE
    else {
        F2 = fork();
        // effettuare i controlli sulla riuscita della fork
        
        // FIGLIO 2
        if (F2 == 0) {
            for (int i = 1; i <= 5000; i++) {
                printf("[FIGLIO2]: il pid di mio padre e' %d\n", getppid());
            }
            execlp("/bin/ls", "ls", NULL);
        }

        // PADRE
        waitpid(F1, NULL, NULL);
        printf("[PADRE]: F1 è terminato (pid: %d)\n", F1);
        waitpid(F2, NULL, NULL);
        printf("[PADRE]: F2 è terminato (pid: %d)\n", F2);
    }
    
    return 0;
}
