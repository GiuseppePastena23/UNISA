#include <stdio.h>
#include <unistd.h>

int main()
{
	pid_t  value;
	value = fork();	
  
	if(value == 0)
	{
		printf("Errore nella system call fork\n");
	}
	else
	{
		printf("\n");
		printf("\n main value == %d\n", value);
		printf("\n");
	}
}
