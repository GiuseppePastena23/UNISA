#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

#define BUFFSIZE 1024

int main(void) {
	int n;
	char buf[BUFFSIZE];
	while ((n = read (STDIN_FILENO, buf, BUFFSIZE)) > 0) {
		if(write (STDOUT_FILENO, buf, n) != n) {
			printf("Write error\n");
			exit(-1);
		}
	}
	if(n < 0) {
		printf("Read error\n");
		exit(-2);
	}
	exit(0);
}