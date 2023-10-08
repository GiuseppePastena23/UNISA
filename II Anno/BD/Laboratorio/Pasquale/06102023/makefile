build/manager.out: build/main.o build/song.o build/artist.o build/utilities.o
	gcc build/main.o build/song.o build/artist.o build/utilities.o -o build/manager.out -g

build/main.o: src/main.c build/artist.o build/song.o
	gcc -c src/main.c -o build/main.o -g

build/song.o: src/song.c src/song.h build/utilities.o
	gcc -c src/song.c -o build/song.o -g

build/artist.o: src/artist.c src/artist.h build/utilities.o
	gcc -c src/artist.c -o build/artist.o -g

build/utilities.o: src/utilities.c src/utilities.h
	gcc -c src/utilities.c -o build/utilities.o -g

clean:
	rm -rf build/*.out build/*.o
	rm -f artist_db.txt songs_db.txt
	rm -f artist_db.tmp songs_db.tmp
	touch artist_db.txt songs_db.txt

show:
	sh show.sh

run: build/manager.out
	./build/manager.out
