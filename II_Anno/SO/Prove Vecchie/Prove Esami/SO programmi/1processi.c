#include<sys/types.h>
#include<stdio.h>
#include<unistd.h>

/*Srivere un programma c che generui 2^n processi dove n è dato da
*/

int main(int argc,char **argv){
int i=0;
int n=atoi(argv[1]);
for(i=0;i<n;i++){
fork();}
printf("*PID: %d\n", getpid());

return(0);
}
