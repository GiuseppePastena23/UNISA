#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <wait.h>
#include <sys/types.h>

int fatt(int n) {
    if (n == 0) return 1;
    else        return (n * fatt(n-1));
}

int fib(int n) {
    if (n == 1) return n;
    else        return fib(n-1) + fib(n-2);
}


void cntrl_c_handler(int sig) {
    pid_t F1 = fork();
    // FIGLIO DI F
    if (F1 == 0) {
        int scelta;
        printf("F deve terminare? (y/n) >");
        scanf("%c", &scelta);
        if (scelta == 'y') {
            // signal(SIGKILL, 9);
            kill(getppid(), SIGKILL);
            raise(SIGKILL);
        }
        else {
            wait(NULL);
            signal(SIGINT,cntrl_c_handler);
        }
    }

    //
}   


int main()
{
    pid_t F = fork();
    
    // FIGLIO
    if (F == 0) {
        signal(SIGINT, cntrl_c_handler);
        for (int i = 1; i <= 45; i++) {
            printf("%d\n", fib(i));
        }
    }
    else {
        waitpid(F, NULL, NULL);
    }
    

    return 0;
}
