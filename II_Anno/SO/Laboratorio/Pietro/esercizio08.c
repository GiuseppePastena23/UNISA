#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>	//le macro per l'analisi sono qui

int main (void) {
	pid_t pid, status;
	pid = fork();
	if (pid == 0) {
		printf("figlio: sto terminando\n");
		//int x = 1 / 0; segnale 8
		exit(2);
	}
	else {
		pid = wait(&status);
		printf("Termina il figlio con pid %d\n", pid);
		if(WIFEXITED(status)) {	//restituisce vero se il processo figlio è terminato volontariamente
			printf("Terminazione volontaria con stato %d\n", WEXITSTATUS(status));	//macro che restituisce lo stato di terminazione
		}
		else if (WIFSIGNALED(status)){	//restituisce vero se il processo è terminato involontariamente
			printf("Terminazione involontaria per segnale %d\n", WTERMSIG(status));	//restituisce il numero dell'interruzione SW
		}
	}
}