#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

int main (void) {
	pid_t figlio, status;
	figlio = fork();
	if (figlio == 0) {	//processo figlio
		printf("Figlio\n");
		exit(0);
	}
	else {
		figlio = wait(&status);
		printf("Terminato processo figlio n.%d\n", figlio);
		if((char)status == 0) {
			printf("Terminazione volontaria con stato %d\n", status >> 8);
		}
		else {
			printf("Terminazione involontaria con segnale %d\n", (char)status);
		}
	}
}