#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

#define BUFFSIZE 512

int main()
{
	int n;
	char buf[BUFFSIZE]; 

	while((n = read (STDIN_FILENO, buf, BUFFSIZE)) > 0) 
	{
		if(write(STDOUT_FILENO, buf, n) != n)
		{
			printf("write error\n");
			exit(1);
		}
	}	
	if(n < 0)
	{
		printf("read error\n");
		exit(1);
	}
	exit(0);
}

