#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <signal.h>

int factorial(int n){
    if (n == 0){
        return 1;
    }
    else {
        return n * factorial(n-1);
    }
}

int fib(int n){
    if (n == 0 || n == 1){
        return 1;
    }
    else {
        return fib(n-1) + fib(n-2);
    }
}

void ask_for_kill(){
    printf("Do you want to kill the process? (y/n)\n");
    char answer;
    scanf("%c", &answer);
    if (answer == 'y'){
        kill(getpid(), SIGKILL);
    }
}

int main(int argc, char *argv[])
{
    pid_t p1 = fork();

    if ((int) p1 != 0 ){
        pid_t p2 = fork();
    }

    else {
        for(int i = 0, i < 30, i++){
            printf("fib(%d) = %d\n", i, fib(i));
            signal(SIGINT, printf("%d\n", getpid() )); 
        }
    }

    if (p2 == 0 && p1 != 0) {
        for(int j = 0, j < 20, j++){
            printf("fact(%d) = %d\n", i, factorial(i));
            signal(SIGINT, ask_for_kill()); 
        }

    }
    signal(SIGINT, SIG_IGN);   
    wait(NULL);
    wait(NULL);
    printf("Done\n");
    printf("Parent process %d\n", getpid());
    printf("Child process %d\n", p1);
    return 0;      
}
