CC = gcc
CFLAGS = -Wall -Wextra -std=c99 -g

SRCS = Btree.c item.c main.c
OBJS = $(SRCS:.c=.o)

EXEC = programma.out

.PHONY: all clean

all: $(EXEC)

$(EXEC): $(OBJS)
	$(CC) $(CFLAGS) $^ -o $@

%.o: %.c
	$(CC) $(CFLAGS) -c $< -o $@

clean:
	rm -f $(EXEC) $(OBJS)