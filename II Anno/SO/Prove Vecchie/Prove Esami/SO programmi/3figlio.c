#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/types.h>
#include<sys/wait.h>
int main(int argc, char *argv[]){
int i;
	//il figlio fa la printf e viene stampato
	if(fork()==0)
		{ 
		printf("PID=%d\n", getpid());
	 	return(0);
		}
	
wait();
//stampa il PID del padre
 printf("PID=%d\n", getpid());
return 0;
}
