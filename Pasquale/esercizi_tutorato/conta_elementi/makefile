programma.out: conta_elementi.o list.o item.o
	gcc conta_elementi.o list.o item.o -o programma.out -g

conta_elementi.o: item.h list.h conta_elementi.c
	gcc -c conta_elementi.c -g
	