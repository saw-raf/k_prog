#include <string>
using namespace std;

class Figura
{
public:
    Figura();
    virtual ~Figura();
    virtual double obliczObwod()=0;
    virtual double obliczPole()=0;
    virtual string pokazParametry()=0;

};

class Czworokat : public Figura
{
public:
    Czworokat();
    virtual ~Czworokat();
    string pokazParametry();

protected:
    double bok1;
	double bok2;
	double bok3;
	double bok4;
	double kat;

};

class Kwadrat : public Czworokat
{
public:
    Kwadrat(double a,double b, double c, double d, double k) throw (string);
    ~Kwadrat();
    double obliczObwod();
    double obliczPole();
};

class Prostokat : public Czworokat
{
public:
    Prostokat(double a, double b, double c, double d, double k) throw (string);
    ~Prostokat();
    double obliczPole();
    double obliczObwod();

};

class Romb : public Czworokat
{
public:
    Romb(double a, double b, double c,double d, double k) throw (string);
    ~Romb();
    double obliczObwod();
    double obliczPole();

};

class Pieciokat : public Figura
{
public:
    Pieciokat(double a);
    ~Pieciokat();
    double obliczPole();
    double obliczObwod();
    string pokazParametry();

private:
    double bok;
};

class Szesciokat : public Figura
{
public:
    Szesciokat(double a);
    ~Szesciokat();
    double obliczPole();
    double obliczObwod();
    string pokazParametry();
private:
    double bok;
};

class Okrag : public Figura
{
public:
    Okrag(double r);
    ~Okrag();
    double obliczObwod();
    double obliczPole();
    string pokazParametry();
private:
    double promien;
};

