#if !defined (__XMALLOC_H)
#define __XMALLOC_H

#include <stdio.h>
#include <stdlib.h>

void * xmalloc (size_t nbytes)
{
	void * result;
	
	result = malloc(nbytes);
	
	//if malloc fails, we have to terminate the whole program
	
	if (result == NULL) 		//malloc failed
	{
		fprintf(stderr, "xmalloc(%ul) failed! BYE. \n", nbytes);
		exit(-1);				//terminate program
	}
	
	//else malloc() succeded 
	
	return result;
}

#endif