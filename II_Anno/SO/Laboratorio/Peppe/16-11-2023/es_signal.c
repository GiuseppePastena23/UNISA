#include <stdio.h>
#include <stdlib.h>
#include <signal.h>

int fib(int n)
{
	if(n <= 1) return(n);
	else return (fib(n-1)) + (fib(n-2));
}

void ctrl_c_handler(int sig)
{
	char answer[512];
	printf("%s%d\n%s", "Ricevuto signale di interruzione, segnale = ", sig, "Vuoi continuare (c) o uscire (q) ?");
	scanf("%s", answer);
	if(*answer == 'c') signal(SIGINT, ctrl_c_handler);
	else
	{
		printf("Processo terminato dall'utente");
		exit(1);	
	} 
}

int main()
{
	printf("Il segnale SIGINT equivale a %d\n", SIGINT);
	signal(SIGINT, ctrl_c_handler);
	for(int i = 0; i < 47; i++)
	{
		printf("fib(%2d) = %d\n", i, fib(i));
	}
}
