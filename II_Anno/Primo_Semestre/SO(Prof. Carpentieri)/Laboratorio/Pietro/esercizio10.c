#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <signal.h>

void ctrl_c_handler (int signo) {
	pid_t f1;
	signal(SIGINT, SIG_IGN);
	char answer[512];
	f1 = fork();
	if(f1 == 0) {
		printf("\n%s%d\n%s", "Ricevuto segnale di interruzione , segnale = ", signo, "Vuoi continuare(c) o uscire(q)\n");
		scanf("%s", answer);
		if(*answer == 'c')
			exit(0);
		else {
			printf("Processo terminato dall'utente\n");
			kill(getppid(), SIGKILL);
			raise(SIGKILL);
		}
	}
	else {
		wait(NULL);
		signal(SIGINT, ctrl_c_handler);
	}
}

int fib (int n) {
	if(n <= 1)
		return n;
	else
		return (fib(n - 1) + fib(n - 2));
}

int main(void) {
	pid_t figlio1;
	figlio1 = fork();
	if(figlio1 < 0) {
		fprintf(stderr, "Errore\n");
		exit(-1);
	}
	else if(figlio1 == 0) {
		signal(SIGINT, ctrl_c_handler);
		for(int i = 0; i < 45; i++) {
			printf("[figlio1] fib(%d) = %d\n", i, fib(i));			
		}
		exit(1);
	}
	else {
		signal(SIGINT, SIG_IGN);
		waitpid(figlio1, NULL, 0);
		printf("[padre] figlio1 terminato con pid %d\n", figlio1);
	}
	return 0;
}