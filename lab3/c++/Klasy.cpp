#include "Klasy.hpp"
#include <cmath>
#include <cstdio>

Figura::Figura()
{
}

Figura::~Figura()
{
}

Czworokat::Czworokat()
{
}

Czworokat::~Czworokat()
{
}

string Czworokat::pokazParametry()
{
    char buf[100];
    sprintf(buf,"c: %lf %lf %lf %lf %lf",bok1,bok2,bok3,bok4,kat);
    return buf;
}

Kwadrat::Kwadrat(double a,double b, double c, double d, double k) throw(string)
{
    if(k!=90.0 || a!=b || b!=c || c!=d)
        throw (string)"To nie kwadrat";
    kat=90.0;
    bok1=bok2=bok3=bok4=a;
}

Kwadrat::~Kwadrat()
{
    //dtor
}

double Kwadrat::obliczObwod()
{
    return (4*bok1);
}

double Kwadrat::obliczPole()
{
    return bok1*bok1;
}

Prostokat::Prostokat(double a, double b, double c, double d, double k) throw (string)
{
    if(k!=90.0)
        throw (string)"Nie prostokat";

    else if( (a==b && c==d) || (a==d && b==c) )
    {
        bok1=bok3=a;
        bok2=bok4=c;
        kat=90;
    }
    else if(a==c && b==d)
    {
        bok1=bok3=a;
        bok2=bok4=b;
        kat=90;
    }
    else
        throw (string)"Nie prostokat";
}

Prostokat::~Prostokat()
{
    //dtor
}
double Prostokat::obliczObwod()
{
    return (2*bok1+2*bok2);
}

double Prostokat::obliczPole()
{
    return bok1*bok2;
}

Romb::Romb(double a, double b, double c, double d,double k) throw(string)
{
    if(k>=180 || a!=b || b!=c || c!=d)
			throw (string)"To nie romb";
		kat=k;
		bok1=bok2=bok3=bok4=a;
}

Romb::~Romb()
{
}

double Romb::obliczObwod()
{
    return (4*bok1);
}

double Romb::obliczPole()
{
    return bok1*bok1*sin((kat)*180.0/M_PI);
}




Pieciokat::Pieciokat(double a)
{
    bok=a;
}

Pieciokat::~Pieciokat()
{
    //dtor
}

string Pieciokat::pokazParametry()
{
    char buf[100];
    sprintf(buf,"p: %lf",bok);
    return buf;
}

double Pieciokat::obliczObwod()
{
    return (5*bok);
}

double Pieciokat::obliczPole()
{
    return (bok*bok)*pow( (5*(5+2*pow(5,0.5))), 0.5)/4;
}




Szesciokat::Szesciokat(double a)
{
    bok=a;
}

Szesciokat::~Szesciokat()
{
}

string Szesciokat::pokazParametry()
{
    char buf[100];
    sprintf(buf,"s: %lf",bok);
    return buf;
}

double Szesciokat::obliczObwod()
{
    return (6*bok);
}

double Szesciokat::obliczPole()
{
    return 6*bok*bok*pow(3,0.5)/4;
}





Okrag::Okrag(double r)
{
    promien=r;
}

Okrag::~Okrag()
{
}

string Okrag::pokazParametry()
{
    char buf[100];
    sprintf(buf,"o: %lf",promien);
    return buf;
}

double Okrag::obliczObwod()
{
    return (2*M_PI*promien);
}

double Okrag::obliczPole()
{
    return (M_PI*promien*promien);
}
