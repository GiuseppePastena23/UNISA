#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <unistd.h>
#include <sys/types.h>
#include <fcntl.h>
#include <string.h>

#define BUFFSIZE 1024

/*
	Ogni nuovo processo apre 3 file standard
	input
	output
	errore
	
	tre file descriptor
	0(STDIN_FILENO)
	1(STDOUT_FILENO)
	2(STDOUT_FILENO)
*/

int main(void)
{	
	// int open(pathname, oflag, mode) -> file descriptor (più piccolo intero positivo non ancora usato come Fdescriptor) else -1
	
	/*char mybuf[BUFFSIZE], *p;
	int in_fd, out_fd, n;*/
	
	int n;
	char buf[BUFFSIZE];
	
	while((n = read(STDIN_FILENO, buf, BUFFSIZE)) > 0)
	{
		if (write(STDOUT_FILENO, buf, n) != n)
		{
			printf("write error\n");
			exit(1);
		}
		if(strcmp(buf, "Quit") == 0)
		{
			exit(0);
		}
		if( n < 0)
		{
			printf("read error\n");
			exit(1);
		}
	}

	exit(0);
}

