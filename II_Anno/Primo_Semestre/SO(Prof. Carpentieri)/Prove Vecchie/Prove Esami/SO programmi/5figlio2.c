#include<signal.h>
#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/types.h>
//stampare prima il padre e poi il figlio
void catch(int);
int main (void){
pid_t pid =fork();
if(!pid){//figlio
	while(getppid()==pid);
printf("PIDfiglio=%d\n", getpid());
}else{//padre
printf("PIDpadre=%d\n", getpid());
}return(0);
}
