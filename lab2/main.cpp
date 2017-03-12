//#include "WierszTrojkataPascala.hpp"
#include <cstdlib>
#include <iostream>
#include <string>

using namespace std;

int main(int argc, char* argv[])
{
	try
	{
		int rozmiar=stoi(argv[1]);
		cout<<rozmiar;
	}
	catch(invalid_argument a)
	{
		cout<<"Przekroczono zakres"<<endl;
	}
	return 0;
}
