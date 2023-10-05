#include <stdio.h>
#include <unistd.h>

int fattoriale(int n)
{
	if(n == 0)
	{
		return 1;
	}
	else
	{
		return n * fattoriale(n - 1);
	}
}

int fibonacci(int n)
{
	if(n <= 1)
	{
		return n;
	}
	else
	{
		return fibonacci(n-1) + fibonacci(n-2);
	}
}

int main()
{
	pid_t value;
	value = fork();
	
	if(value == -1)
	{
		fprintf(stderr, "Errore nella system call fork!");
	}
	else if(value == 0)
	{
		printf("FIBONACCI PROCESSO FIGLIO:\n");
		for(int i = 1; i <= 10; i++)
		{
			printf("%d\n", fibonacci(i));
		}
	}
	else
	{
		printf("FATTORIALI PROCESSO PADRE:\n");
		for(int i = 1; i <= 10; i++)
		{
			printf("%d\n", fattoriale(i));
		}
	}
}


