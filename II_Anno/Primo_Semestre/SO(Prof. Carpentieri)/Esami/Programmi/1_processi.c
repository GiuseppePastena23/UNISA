#include <sys/types.h>
#include <stdio.h>
#include <unistd.h>

/*
Srivere un programma c che generi 2^n processi, con n dato dall'utente su riga di comando
*/

int main(int argc, char **argv) {
	int i = 0;
	int n = atoi(argv[1]);
	for(i = 0; i < n; i++){
		fork();
	}
	printf("*PID: %d\n", getpid());
	return 0;
}