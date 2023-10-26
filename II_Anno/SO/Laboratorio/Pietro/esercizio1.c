#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>

int main(void) {
	printf("pid del processo = %d\n", getpid());
	printf("pid del padre del processo = %d\n", getppid());
	return 0;
}