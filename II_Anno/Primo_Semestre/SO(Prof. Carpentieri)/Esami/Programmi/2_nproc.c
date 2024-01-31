#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>

/*
Il programma prende in input n, crea n figli e stampa il loro pid.
*/

int main(int argc, char *argv[]) {
	int n = atoi(argv[1]);
	int i;
	//n-1 fork eseguite dal padre
	for(i = 0; i < (n - 1); i++) {
		//stampa del  PID del figlio
		if(fork() == 0) { 
			printf("PID = %d\n", getpid());
			return 0;
		}
	}
	//stampa del PID del padre
	printf("PID = %d\n", getpid());
	return 0;
}