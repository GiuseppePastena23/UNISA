#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>
/*
pid_t getpid (void); // process ID del processo chiamante
pid_t getppid (void); // process ID del padre del processo chiamante
*/

int main(void) {
	printf("Il pid del processo: %d\n", getpid());
	printf("Il pid del padre del processo: %d\n", getppid());
	printf("\n fine\n");
}
