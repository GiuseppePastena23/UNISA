#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <wait.h>

int fib(int n)
{
	if(n<=1) {return(n);}
	else {return(fib(n-1)+fib(n-2));}
}


void cntrl_c_handler(int sig)
{
	int F1 = fork();
	if(F1 != 0)
	{
		signal(SIGINT, cntrl_c_handler);
		printf("test\n");
		waitpid(F1, NULL, 0);
		printf("test2\n");
		return;
	}
	if(F1 == 0)
	{
		char risposta[512];
		printf("Vuoi continuare o terminare F? (k per terminare)\n");
		scanf("%s", risposta);
		if(*risposta == 'k')
		{
			kill(getppid(), SIGKILL);
			raise(SIGKILL);
		}
		else
		{
			exit(1);
		}
	}
}

int main()
{
	int F = fork();
	int status;
	if(F != 0)
	{
		signal(SIGINT, SIG_IGN); //IMPORTANTE 
		waitpid(F, &status, 0);
	}
	if(F == 0)
	{
		signal(SIGINT, cntrl_c_handler);
		for(int i = 1; i <= 45; i++)
		{
			printf("fib %d = %d\n", i, fib(i));
		}
	}
	if(F != 0)
	{
		printf("Figlio #%d terminato, status = %d\n", F, status);
		return 0;
	}
	
}
