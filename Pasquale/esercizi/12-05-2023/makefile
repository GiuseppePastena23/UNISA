esercizio.out: clean es1.o modules/stack.o modules/list.o modules/item.o
	gcc es1.o modules/stack.o modules/list.o modules/item.o -o esercizio.out -g

es1.o: modules/list.h modules/stack.h modules/item.h es1.c 
	gcc -c es1.c -g

modules/list.o: modules/list.c modules/list.h modules/item.h
	gcc -c modules/list.c -o modules/list.o -g

modules/stack.o: modules/stack.h modules/stack.c modules/list.h modules/item.h
	gcc -c modules/stack.c -o modules/stack.o -g

modules/item.o: modules/item.h modules/item.c
	gcc -c modules/item.c -o modules/item.o -g

clean:
	rm -f modules/*.out modules/*.o .*.out *.o