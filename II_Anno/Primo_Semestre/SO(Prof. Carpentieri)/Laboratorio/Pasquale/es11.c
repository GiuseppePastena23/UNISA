#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <wait.h>
#include <signal.h>
#include <math.h>

int fib(int n) {
    if(n <= 1) return n;
    else       return fib(n-1) + fib(n-2);
}

int factorial(int n) {
    if (n == 0) {
        return 1;
    } else {
        return n * factorial(n - 1);
    }
}


void cntrl_c_handler_PID(int sig) {
    printf("[FIGLIO1]: %d\n", getpid());
    // signal(SIGINT, cntrl_c_handler_PID);
}   

void cntrl_c_handler_ASK(int sig) {
    char answer[512];
    printf("\n\n%s%d\n\n%s", "Ricevuto segnale di interruzione: , segnale = ", sig, "Vuoi continuare (c) o uscire (q)?");
    scanf("%s", answer);
    if (*answer == 'c') signal(SIGINT, cntrl_c_handler_ASK);
    else {
        printf("Processo terminato dall'utente\n\n");
        exit(1);
    }
}   

int main()
{   
    pid_t F1, F2;

    
    F1 = fork();
    if (F1 == 0) {
        signal(SIGINT, cntrl_c_handler_PID);
        for (int i = 1; i <= 30; i++) {
            printf("[FIGLIO1]: %d\n", fib(i));
        }
        exit(EXIT_SUCCESS);
    }

    else {
        F2 = fork();
        if (F2 == 0) {
            signal(SIGINT, cntrl_c_handler_ASK);
            for (int i = 0; i <= 20; i++) {
                printf("[FIGLIO2]: %d\n", fib(i));
            }
            exit(EXIT_SUCCESS);
        }

        signal(SIGINT, SIG_IGN);
        wait(NULL);
        wait(NULL);
        printf("\n");
        printf("[PADRE]: Pid del primo figlio: %d\n", F1);
        printf("[PADRE]: Pid del secondo figlio: %d\n", F2);
    }
    
    return 0;
}
