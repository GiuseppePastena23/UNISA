#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

int main(void) {
	pid_t figlio, status;
	figlio = fork();
	if (figlio == 0) {
		printf("Figlio\n");
		exit(0);
	}
	else {
		figlio = wait(&status);
		if(WIFEXITED(status)) {	//restituisce vero se il processo figlio è terminato volontariamente
			printf("Terminazione volontaria di %d con stato %d\n", figlio, WEXITSTATUS(status));	//macro che restituisce lo stato di terminazione
		}
		else if(WIFSIGNALED(status)) {	//restituisce vero se il processoo è terminato involontariamente
			printf("Terminazione involontaria per segnale %d\n", WTERMSIG(status)); //restituisce il numero dell'interruzione SW
		}
	}
}