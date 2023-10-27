#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

int main(void) {
	pid_t figlio = fork();	//genera un nuovo processo
	if (figlio < 0) {
		fprintf(stderr, "Errore");
		exit(-1);
	}
	else if (figlio == 0) {		//siamo nel processo figlio
		execlp("/bin/ls", "ls", NULL);	//lista dei file nella directory in cui è salvato questo file
	}
	else {	//siamo nel processo padre
		wait(NULL);
		printf("Il figlio ha terminato\n");
		exit(0);
	}
}