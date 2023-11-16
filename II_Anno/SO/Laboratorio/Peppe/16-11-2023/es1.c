// programma che crea due figli e aspetta la terminazione di entrambi
// i due figli sono in ecuzione concorrente
// il primo figlio scrive i primi 30 numeri di fibonacci e poi termina 
// in presenza di un ctrl-c dovra scrivere il proprio pid e continuare l'esecuzione
// il secondo figlio scrive i primi 20 fattoriali ed in presenza di un ctrl-c chiede
// all'utente se continuare l'esecuzione o meno
// dopo la terminazione dei due figli il padre stampa sullo schermo un messaggio
// indicando il pid dei due figli ed il fatto che sono terminati
#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>


int fib(int n)
{
	if(n <= 1) return(n);
	else return (fib(n-1)) + (fib(n-2));
}

int fatt(int n)
{
	if(n <= 1)
	{
		return 1;
	}
	else{ 
		return (n * fatt(n-1));
	}
}

void ctrl_c_handler_child1(int sig)
{
	printf("\npid del figlio1: %d\n", getpid());
}

void ctrl_c_handler_child2(int sig)
{
	char answer[512];
	printf("\n%s%d\n%s", "Ricevuto signale di interruzione, segnale = ", sig, "Vuoi continuare (c) o uscire (q) ?");
	scanf("%s", answer);
	if(*answer == 'c') signal(SIGINT, ctrl_c_handler_child2);
	else
	{
		printf("Processo terminato dall'utente");
		exit(1);	
	} 
}

int main(void)
{
	pid_t f1, f2;
	f1 = fork();

	if(f1 < 0)
	{
		fprintf(stderr, "Errore\n");
		exit(-1);
	}
	else if(f1 == 0)
	{
		// figlio 1
		signal(SIGINT, ctrl_c_handler_child1);
		for(int i = 0; i <= 43; i++)
		{
			printf("[FIGLIO 1] fib{%d}: %d\n", i, fib(i));
		}
		exit(1);
	}
	else
	{
		f2 = fork();
			if(f2 < 0)
		{
			fprintf(stderr, "Errore\n");
			exit(-1);
		}
		else if(f2 == 0)
		{
			// figlio 2
			signal(SIGINT, ctrl_c_handler_child2);
			for(int i = 0; i <= 100; i++)
			{
				printf("[FIGLIO 2] fatt{%d}: %d\n", i, fatt(i));
			}
			exit(1);
		}
		signal(SIGINT, SIG_IGN);
		waitpid(f1, NULL, 0);
		waitpid(f2, NULL, 0);
		printf("[PADRE] pid del figlio1: %d\n[PADRE] pid del figlio2: %d\n", f1, f2);
	}
}
