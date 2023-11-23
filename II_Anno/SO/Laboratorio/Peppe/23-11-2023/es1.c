#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <sys/wait.h>
#include <sys/types.h>

void ctrl_c_handler(int signo)
{
	pid_t f1;
	signal(SIGINT, SIG_IGN);
	f1 = fork();
	char answer[512];
	if(f1 == 0)
	{
		printf("\n%s%d\n%s", "Ricevuto segnale di interruzione , segnale = ", signo, "Vuoi continuare(c) o uscire(q)");
		scanf("%s", answer);
		if(*answer == 'c') exit(0);
		else 
		{
			printf("Processo terminato dall'utente\n");
			kill(getppid(), SIGKILL);
			raise(SIGKILL);
		}
	}
	else
	{
	  wait(NULL);
	  signal(SIGINT, ctrl_c_handler);
     }
}

int fib(int n)
{	
	if(n==0) return 0;
	if(n==1) return (n);
		
	else return (fib(n-1) + fib(n-2));
}

int main()
{
	pid_t figlio1 = fork();

	if(figlio1 == 0)
	{
	        printf("prova");
		signal(SIGINT, ctrl_c_handler);
		for(int i = 0; i <= 45; i++)
		{
		        
			printf("FIGLIO1: %d\n", fib(i));
		}
	        exit(1);
	}
	else 
	{
	    signal(SIGINT, SIG_IGN);
		wait(NULL);
		printf("Figlio1 con pid %d terminato\n", figlio1);	
	}
	return 0;
}
