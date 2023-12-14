#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main() {
	pid_t pid1, pid2, pid3, pid4;
	pid3 = getpid();
	pid1 = fork();
	if(pid1 == 0) {
		printf("Il pid del figlio e del padre e': %d, %d\n", getpid(), pid3);
	}
	else {
		pid2 = fork();
		if(pid2 == 0) {
			pid4 = getpid() + pid3;
			printf("La somma dei pid e': %d\n", pid4);
		}
		else {
			wait(NULL);
			wait(NULL);
			printf("I figli sono terminati, i loro pid sono: %d, %d\n", pid1, pid2);
		}
	}
}
