#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    char usr_command[100];
    while(1){
        printf("%% ");
        scanf("%s", &usr_command);
        pid_t value = fork();
        if(value == 0)
        {
            if(execlp(usr_command, NULL) == -1)
            {
                printf("Error in execl\n");
            }

        }
        else
        {
            wait();
        }
    }
}
