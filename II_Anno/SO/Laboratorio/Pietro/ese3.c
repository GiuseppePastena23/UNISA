#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>

int main() {
	printf("\n \n \n");
	printf("Sopra la panca\n");
	//execl("/bin/echo", "echo", "la", "capra", "campa", NULL);
	execlp("echo", "echo", "la", "capra", "campa", NULL); 	//cerca la prima directory in cui esiste il comando echo
	printf("Prova\n");
}