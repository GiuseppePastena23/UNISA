#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <ctype.h>

#define BUFFSIZE 512


int main(int args, char* argv[])
{
	int n;
	char buf[BUFFSIZE], *p;
	int f1 = open(argv[1], O_RDONLY, 4);
	int f2 = open(argv[2], O_WRONLY, 2);
	while((n = read(f1, buf, BUFFSIZE)) > 0)
	{	
		for(p = buf; p - buf < n; p++)
		{
			if(islower(*p)) *p = toupper(*p);
			else if(isupper(*p)) *p = tolower(*p);
		}
		write(f2, buf, n);
	}
	if (n < 0)
	{
		printf("read error\n");
		exit(1);
	}
	exit(0);
}
