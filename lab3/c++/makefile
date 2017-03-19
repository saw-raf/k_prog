# Makefile

all: main

main: main.o Klasy.o
	g++ -std=c++11 -o main main.o Klasy.o

main.o: main.cpp
	g++ -std=c++11 -c main.cpp

WierszTrojkataPascala.o: Klasy.hpp Klasy.cpp
	g++ -std=c++11 -c WierszTrojkataPascala.cpp

clean:
	rm -rf *.o
	rm main
