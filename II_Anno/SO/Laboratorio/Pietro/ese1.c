#include <stdio.h>
#include <stdlib.h>
#include <signal.h>

int fib (int n) {
	if(n <= 1)
		return n;
	else
		return (fib(n - 1) + fib(n - 2));
}

void ctrl_c_handler (int sig) {
	char answer[512];
	printf("\n\n%s%d\n\n%s", "Ricevuto segnale di interruzione, segnale = ", sig, "Vuoi continuare (c) o uscire (q) ?");
	scanf("%s", answer);
	if(*answer == 'c')
		signal (SIGINT, ctrl_c_handler);
	else {
		printf("Processo terminato dall'utente\n\n");
		exit(1);
	}
}

int main() {
	int i;
	printf("Il segnale SIGINT equivale a %d\n\n", SIGINT);
	signal(SIGINT, ctrl_c_handler);
	for(i = 0; i < 46; ++i)
		printf("fib(%2d) = %d\n", i, fib(i));
	return 0;
}