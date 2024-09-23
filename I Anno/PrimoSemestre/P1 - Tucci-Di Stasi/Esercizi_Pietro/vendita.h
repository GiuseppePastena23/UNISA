#if !defined(__VENDITA_H)
#define __VENDITA_H

#define DESCLEN 50

typedef struct vendita {
	char desc[DESCLEN+1];
	double unit_pr;
	double quant;
} Vendita;

#endif