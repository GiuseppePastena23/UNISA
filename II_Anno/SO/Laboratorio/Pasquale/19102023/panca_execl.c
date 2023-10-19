#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(int argc, char const *argv[])
{
    printf("\n \n \n");
    printf("Sopra la panca\n");
    execl("/bin/echo", "echo", "la", "capra", "campa", NULL);

    printf("non verro' mai stampato perche' lo spazio di indirizzi e' cambiato totalmente\n");
    return 0;
}
