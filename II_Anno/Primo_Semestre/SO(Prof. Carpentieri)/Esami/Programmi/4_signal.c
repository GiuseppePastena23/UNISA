#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>

void catch(int signo);

int main(void) {
	pid_t pid;
	if((pid = fork()) == 0){	//siamo nel figlio
		signal(SIGALRM, catch);
		pause();
		printf("PID = %d\n", getpid());
		return 0;
	} else {	//siamo nel padre
		printf("PID del Padre = %d\n", getpid());
		kill(pid, SIGALRM);
		return 0;
	}
}

void catch(int signo) {
	printf("parte il figlio\n");
}