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
	
	if(value > 0)
	{
		pid_t value2 = fork();
		
		if(value2 == 0)
		{
			printf("Nel secondo processo FIGLIO\n");
			printf("Il valore di ritorno di fork: %d\n", value2);
		}
		else
		{
			printf("Nel processo PADRE\n");
			printf("Il valore di ritorno della seconda fork: %d\n", value2);
		}
	}
}
