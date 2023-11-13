#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>	//s mancante
#include <sys/wait.h>

int main(void) {
	pid_t figlio1, figlio2;		//; mancante
	figlio1 = fork();
	if(figlio1 < 0) {
		fprintf(stderr, "Errore");
		exit(-1);
	}
	else if (figlio1 == 0) {
		printf("[figlio1] pid del figlio1: %d\n", getpid());
		for(int i = 1; i <= 5000; i++)
			printf("%d\n", i);
	}
	else {
		figlio2 = fork();
		if(figlio2 < 0) {
			fprintf(stderr, "Errore");
			exit(-1);
		}
		else if (figlio2 == 0) {
			for(int i = 0; i < 5000; i++)
				printf("[figlio2] pid del padre: %d\n", getppid());
			execlp("ls", "ls", NULL);
		}
		else {
			waitpid(figlio1, NULL, 0);
			waitpid(figlio2, NULL, 0);
			printf("[padre] pid del figlio1: %d\n", figlio1);
			printf("[padre] pid del figlio2: %d\n", figlio2);
		}
	}
	return 0;
}