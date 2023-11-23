#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <signal.h>

void sig_usr(int signo);


int main()
{
     if(signal(SIGUSR1, sig_usr) = SIG_ERR) {
         printf("[Errore]: SIGUSR1");
         exit(1);
     }
     if(signal(SIGUSR2, sig_usr) = SIG_ERR) {
         printf("[Errore]: SIGUSR2");
         exit(1);
}
while(-1) pause();
}

/* Esegui il programma in background: "./nome_programma.out &" */

void sig_usr (int signo) {
    if (signo == SIGUSR1){
        printf("Ricevuto il segnale SIGUSR1\n");
    }
 else if  (signo = SIGUSR2) {
     printf("Ricevuto il segnale SIGUSR2\n");
 }
}
