//il programma prende in input n, crea n figli e stampa il loro pid.
#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/types.h>
int main(int argc, char *argv[])
{
 int n=atoi(argv[1]);
 int i;
//il padre fa la fork per n-1 volte
 for(i=0;i<n-1;i++)
	{
	//il figlio fa la printf e viene stampato
	 if(fork()==0)
		{ 
		printf("PID=%d\n", getpid());
	 	return(0);
		}
	}
//stampa il PID del padre
 printf("PID=%d\n", getpid());
return 0;
}
