// waitpid: system call che ci permette di  specificare il figlio che vogliamo aspettare, la wait aspetta il primo figlio che
// termina, la waitpid il figlio viene specificato

#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>


int main(void){
  pid_t figlio1 = fork();
  int pid_figlio1 = 0;
  int pid_figlio2 = 0;
  
  
  if(figlio1 == 0){
    pid_figlio1 = getpid();
    printf("[figlio1] PID del primo figlio: %d\n", pid_figlio1);
    printf("[figlio1] PID del processo padre: %d\n", getppid());
  }
  else{
    pid_t figlio2 = fork();
    if(figlio2 == 0){
      pid_figlio2 = getpid();
      printf("[figlio2] somma pid figlio2 e padre: %d\n", pid_figlio2 + getppid());
    }
    else{
      waitpid(figlio1, NULL, 0);
      waitpid(figlio2, NULL, 0);
      printf("[padre] figlio con pid %d terminato\n", figlio1);
      printf("[padre] figlio con pid %d terminato\n", figlio2);
    }
  }
  
 
}




