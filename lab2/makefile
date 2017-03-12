# Makefile

all: main

main: main.o WierszTrojkataPascala.o
	g++ -std=c++11 -o main main.o WierszTrojkataPascala.o

main.o: main.cpp
	g++ -std=c++11 -c main.cpp

WierszTrojkataPascala.o: WierszTrojkataPascala.hpp WierszTrojkataPascala.cpp
	g++ -std=c++11 -c WierszTrojkataPascala.cpp

clean:
	rm -rf *.o
	rm main.out
