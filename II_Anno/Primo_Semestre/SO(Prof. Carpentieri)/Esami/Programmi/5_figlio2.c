#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>

/*
stampare prima il pid del padre e poi quello del figlio
*/

void catch(int);

int main (void){
	pid_t pid = fork();
	if(!pid) {	//siamo nel figlio
		while(getppid() == pid);
		printf("PID_Figlio = %d\n", getpid());
	} else {	//siamo nel padre
		printf("PID_Padre = %d\n", getpid());
	}
	return 0;
}