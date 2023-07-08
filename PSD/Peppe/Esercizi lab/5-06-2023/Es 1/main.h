#include "PQueue.h"

/*
SPECIFICA SINTATTICA
merge(PQueue, PQueue) -> PQueue
SPECIFICA SEMANTICA 
merge(PQueue q1, PQueue q2) = PQueue q3
pre: q1 = <a0, a1, a2,..., bn>  q2 = <b0, b1, b2,..., bn>  
post:  q3 = <a0, b0, a1, b1, ..., an, bn>
*/
PQueue merge(PQueue q1, PQueue q2);
