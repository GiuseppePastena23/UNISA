tester.out: clean tester.o libretto.o list.o item.o 
	gcc build/tester.o build/libretto.o build/list.o build/item.o -o tester.out -g

tester.o: modules/list.h modules/item.h libretto.h
	gcc -c tester.c -o build/tester.o -g
	
libretto.o: libretto.c libretto.h modules/item.h modules/list.h
	gcc -c libretto.c -o build/libretto.o -g
	
list.o: modules/item.h modules/list.c modules/list.h
	gcc -c modules/list.c -o build/list.o -g

item.o: modules/item.c modules/item.h
	gcc -c modules/item.c -o build/item.o -g

clean:
	rm -f *.out *o build/*.out build/*.o
