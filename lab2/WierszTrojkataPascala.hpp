#include <string>
#include <iostream>

using namespace std;

class WierszTrojkataPascala
{
public:
	WierszTrojkataPascala(int n);
	~WierszTrojkataPascala();
	int wspolczynnik(int m) throw (string);
private:
	int rozmiar;
	int* wiersz;
};
