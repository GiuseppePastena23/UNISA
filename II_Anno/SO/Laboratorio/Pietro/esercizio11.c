//Programma che usa due diversi modi per la gestione di ctrl+c
//Non funziona correttamente: ctrl+c si 'attiva' per entrambi e non si può fare più nulla da terminale fino alla fine dell'esecuzione
#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int fib (int n) {
	if(n <= 1)
		return n;
	else
		return (fib(n - 1) + fib(n - 2));
}

int fatt (int n) {
	if(n <= 1)
		return 1;
	else
		return (n * fatt(n - 1));
}

void ctrl_c_handler_child1 (int sig) {
	//signal(SIGINT, SIG_IGN);
	printf("\n%s%d\n", "Ricevuto segnale di interruzione, segnale = ", sig);
	printf("[figlio1] pid del figlio1: %d\n", getpid());
	printf("[figlio1] proseguo con il mio lavoro\n");
	signal(SIGINT, ctrl_c_handler_child1);
}

void ctrl_c_handler_child2 (int sig) {
	//signal(SIGINT, SIG_IGN);
	char answer[512];
	printf("\n%s%d\n%s", "Ricevuto segnale di interruzione, segnale = ", sig, "Vuoi continuare (c) o uscire (q) ?");
	scanf("%s", answer);
	if(*answer == 'c') {
		signal (SIGINT, ctrl_c_handler_child2);
	}	
	else {
		printf("Processo terminato dall'utente\n");
		exit(1);
	}
}

int main(void) {
	pid_t figlio1, figlio2;
	figlio1 = fork();
	//Controllo sulla fork
	if(figlio1 < 0) {
		fprintf(stderr, "Errore");
		exit(-1);
	}
	//Nel figlio1
	else if (figlio1 == 0) {
		signal(SIGINT, ctrl_c_handler_child1);
		for(int i = 0; i < 40; i++) {
			printf("[figlio1] fib(%2d) = %d\n", i, fib(i));
			sleep(2);	//altrimenti stamperebbe troppo velocemente
		}
		exit(1);
	}
	//Nel processo padre
	else {
		figlio2 = fork();
		//Controllo sulla fork
		if(figlio2 < 0) {
			fprintf(stderr, "Errore");
			exit(-1);
		}
		//Nel figlio2
		else if (figlio2 == 0) {
			signal(SIGINT, ctrl_c_handler_child2);
			for(int i = 0; i < 40; i++) {
				printf("[figlio2] fatt(%2d) = %d\n", i, fatt(i));
				sleep(2);	//altrimenti stamperebbe troppo velocemente
			}
		}
		//Nel processo padre
		else {
			signal(SIGINT, SIG_IGN);
			waitpid(figlio1, NULL, 0);
			waitpid(figlio2, NULL, 0);
			printf("[padre] pid del figlio1: %d\n", figlio1);
			printf("[padre] pid del figlio2: %d\n", figlio2);
		}
	}
	return 0;
}