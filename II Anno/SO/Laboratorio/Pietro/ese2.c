#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main () {
	pid_t figlio1, figlio2;
	figlio1 = fork ();
	if (figlio1 == 0) {
		printf("[figlio1] PID del primo figlio: %d\n", getpid());
		for (int i = 1; i <= 50; i++)
			printf("%d\n", i);
	}
	
	else {
		figlio2 = fork ();
		if (figlio2 == 0) {
			printf("[figlio2] PID del padre: %d\n", getppid());
			for (int i = 101; i <= 150; i++)
				   printf("%d\n", i);
		}
		
		else {
			waitpid(figlio1, NULL, 0);
			waitpid(figlio2, NULL, 0);
			printf("[Padre] figlio1: %d, figlio2 %d\n", figlio1, figlio2);
		}
		
	}
}