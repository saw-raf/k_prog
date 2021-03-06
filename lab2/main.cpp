#include "WierszTrojkataPascala.hpp"
#include <cstdlib>
#include <iostream>
#include <string>

using namespace std;

int main(int argc, char* argv[])
{
	try
	{
		int rozmiar=stoi(argv[1]);
		if(rozmiar<0)
			throw invalid_argument("");
		if(argc<3)
			throw logic_error("");
		WierszTrojkataPascala* wiersz=new WierszTrojkataPascala(rozmiar);
		for(int i=2;i<argc;i++)
		{
			try
			{
				int wspolczynnik=stoi(argv[i]);
				cout<<argv[i]<<": "<< wiersz->wspolczynnik(wspolczynnik)<<endl;
			}
			catch(const invalid_argument& a)
			{
				cout<<argv[i]<<": nie jest liczba"<<endl;
			}
			catch(string w)
			{
				cout<<w<<endl;
			}
			
		}
	}
	catch(const invalid_argument& a)
	{
		cout<<"Miales podac liczbe naturalna"<<endl;
	}
	catch(logic_error e)
	{
		cout<<"Podaj nr wiersza oraz nr wspolczynnika"<<endl;
	}
	return 0;
}
