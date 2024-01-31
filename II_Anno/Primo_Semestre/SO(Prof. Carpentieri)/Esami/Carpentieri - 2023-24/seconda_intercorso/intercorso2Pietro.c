//D'Antuono Pietro
#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>
#include <sys/types.h>	//inserito \ al posto di /
#include <sys/wait.h>	//inserito \ al posto di /

int fib (int n) {
	if(n <= 1)	//manca =
		return n;
	else
		return (fib(n - 1) + fib(n - 2));
}

int fatt (int n) {
	if(n <= 1)	//manca =
		return 1;
	else
		return (n * fatt(n - 1));
}

void ctrl_c_handler_child1 (int signo) {
	printf("[figlio1] ricevuto segnale di interruzione: %d\n", signo);
	printf("[figlio1] ecco il decimo numero di Fibonacci: %d\n", fib(9));
	printf("[figlio1] riprendo l'esecuzione\n");
}

void ctrl_c_handler_child2 (int signo) {
	char c[512];
	printf("[figlio2] ricevuto segnale di interruzione: %d\n", signo);
	printf("[figlio2] continuo (c) oppure termino (q) ?\n");
	scanf("%c", c);
	if(*c == 'c') {
		signal(SIGINT, ctrl_c_handler_child2);	//scritto SIG_INT anziché SIGINT
	}	
	else {
		printf("[figlio2] programma terminato dall'utente\n");
		exit(1);
	}
}

int main(void) {
	pid_t figlio1, figlio2;
	figlio1 = fork();
	if(figlio1 < 0) {
		printf("Errore\n");
		exit(-1);
	}
	else if (figlio1 == 0) {
		signal(SIGINT, ctrl_c_handler_child1);	//scritto SIG_INT anziché SIGINT
		for(int i = 0; i < 30; i++) {
			printf("[figlio1] fib(%d) = %d\n", i, fib(i));
		}
	}
	else {
		figlio2 = fork();
		if(figlio2 < 0) {
			printf("Errore\n");
			exit(-1);
		}
		else if (figlio2 == 0) {
			signal(SIGINT, ctrl_c_handler_child2);	//scritto SIG_INT anziché SIGINT
			for(int j = 0; j < 20; j++) {
				printf("[figlio2] fatt(%d) = %d\n", j, fatt(j));
			}
		}
		else {
			signal(SIGINT, SIG_IGN);	//scritto SIG_INT anziché SIGINT
			waitpid(figlio1, NULL, 0);
			waitpid(figlio2, NULL, 0);
			printf("Somma dei pid dei figli: %d\n", (figlio1+figlio2));
		}
	}
	return 0;
}