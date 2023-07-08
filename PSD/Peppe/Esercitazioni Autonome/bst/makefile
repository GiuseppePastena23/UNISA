CC = gcc
CFLAGS = -Wall -Wextra -std=c99

SRCS = BST.c item.c main.c
OBJS = $(SRCS:.c=.o)

EXEC = program.exe

.PHONY: all clean

all: $(EXEC)

$(EXEC): $(OBJS)
	$(CC) $(CFLAGS) $^ -o $@

%.o: %.c
	$(CC) $(CFLAGS) -c $< -o $@

clean:
	del $(EXEC) $(OBJS)
