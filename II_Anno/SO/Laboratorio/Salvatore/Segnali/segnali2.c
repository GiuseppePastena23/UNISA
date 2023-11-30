#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <signal.h>

void sig_urs(int signo)
{
	if(signo==SIGUSR1) {printf("Ricevuto SIGUSR1\n\n");}
	else if(signo==SIGUSR2) {printf("Ricevuto SIGUSR2\n\n");}
}

int main()
{
	if(signal(SIGUSR1, sig_urs) == SIG_ERR)
	{
		printf("ERRORE DI SISTEMAL SIGUSR1\n");
		exit(1);
	}
	if(signal(SIGUSR2, sig_urs) == SIG_ERR)
	{
		printf("ERRORE DI SISTEMA: SIGUSR2\n");
		exit(1);
	}
	
	while(-1) {pause();}
}

