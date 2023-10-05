#include <stdio.h>
#include <unistd.h>

int main()
{
 	pid_t  value;
 	value = fork();
  
	if(value == 0)
	{
    	printf("Nel processo FIGLIO\n");
    	printf("il valore di ritorno di fork: %d\n", value);
	}
	else
	{
		printf("Nel processo PADRE\n");
    	printf("il valore di ritorno di fork: %d\n", value);
	}
}
