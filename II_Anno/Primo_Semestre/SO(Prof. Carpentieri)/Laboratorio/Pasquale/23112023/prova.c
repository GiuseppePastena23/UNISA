/*
Scrivi un programma C che crei un processo figlio. Il processo figlio dovrebbe eseguire un ciclo infinito stampando un messaggio ogni secondo: "Processo figlio in esecuzione (con contatore del numero di esecuzioni)". Nel frattempo, il processo padre dovrebbe essere in attesa e, se riceve un segnale di interruzione (SIGINT), dovrebbe terminare il processo figlio. In caso di interruzione il padre chiederà all'utente se continuare l'esecuzione con un nuovo processo figlio oppure terminare. In caso di terminazione restituirà il pid del figlio, di se stesso e degli stati di terminazione. Altrimenti stamperà il pid del precedente figlio e continuerà l'esecuzione
*/

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>
#include <sys/wait.h>
#include <sys/types.h>

pid_t f1;

void ctrl_c_handler(int signo) {
    signal(SIGINT, SIG_IGN);
    char car;
    printf("Inizio handler\n");
    printf("Continuare con un nuovo processo? (y/n) ");
    scanf("%c", &car);
    if (car == 'n') {
        kill(f1, SIGKILL);
        raise(SIGKILL);
    }
    else {
        printf("pid figlio %d morto con %d\n", f1, WEXITSTATUS(stat));
        printf("pid padre: %d\n", getpid());
        kill(f1, SIGCONT);
        signal(SIGINT, ctrl_c_handler);
    }
}

void busy_waiting(int signo) {
    while (1);
}

int main() {

    while (1)
    {
        f1 = fork();
        // FIGLIO1
        if (f1 == 0) {
            signal(SIGINT, busy_waiting);
            for(int i = 1; 1; i++) {
                printf("%d# Processo figlio in esecuzione\n", i);
                sleep(1);
            }
        }

        // PADRE
        else {
            signal(SIGINT, ctrl_c_handler);
            int stat;
            waitpid(f1, &stat, NULL);
            
        }

    }
    return 0;
}