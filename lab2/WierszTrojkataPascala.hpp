#include <string>
#include <iostream>

using namespace std;

class WierszTrojkataPascala
{
public:
	WierszTrojkatPascala(int n);
	int wspolczynnik(int m) throw (string);
private:
	int rozmiar;
	int wiersz[];
};
