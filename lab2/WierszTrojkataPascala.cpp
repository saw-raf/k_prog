#include "WierszTrojkataPascala.hpp"

WierszTrojkataPascala::WierszTrojkataPascala(int n)
{
	rozmiar=n+1;
	wiersz=new int[rozmiar];
	wiersz[0]=1;
	for(int i=1;i<rozmiar;i++)
		wiersz[i]=wiersz[i-1]*(n-(i-1))/i;
}

int WierszTrojkataPascala::wspolczynnik(int m) throw (string)
{
	if(m>=rozmiar || m<0)
		throw (string)"Zly rozmiar tablicy";
	return wiersz[m];
}
