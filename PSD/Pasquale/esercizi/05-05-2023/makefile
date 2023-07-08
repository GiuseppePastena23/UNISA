programma.out: clean build/esercizio_code.o build/queue.o build/list.o build/item.o
	gcc build/esercizio_code.o build/queue.o build/item.o -o programma.out -g

build/esercizio_liste.o: esercizio_liste.c modules/list.h modules/item.h
	gcc -c esercizio_liste.c -o build/esercizio_liste.o -g

build/esercizio_stack.o: esercizio_stack.c modules/stack.h modules/list.h modules/item.h
	gcc -c esercizio_stack.c -o build/esercizio_stack.o -g

build/esercizio_code.o: esercizio_code.c modules/queue.h modules/list.h modules/item.h
	gcc -c esercizio_code.c -o build/esercizio_code.o -g

build/queue.o: modules/queue.c modules/queue.h modules/list.h modules/item.h
	gcc -c modules/queue.c -o build/queue.o -g

build/stack.o: modules/stack.c modules/stack.h modules/item.h
	gcc -c modules/stack.c -o build/stack.o -g

build/list.o: modules/list.c modules/list.h modules/item.h
	gcc -c modules/list.c -o build/list.o -g

build/item.o: modules/item.c modules/item.h
	gcc -c modules/item.c -o build/item.o -g

clean:
	rm -f build/*.o build/*.out *.out *.o
