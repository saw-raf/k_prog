#include "Klasy.hpp"
#include <iostream>
#include <cstring>
#include <string>
#include <vector>


using namespace std;

int main(int argc, char* argv[])
{
    try
    {
        if(argc==1)
            throw argc;
        int ileFigur=strlen(argv[1]);
        Figura** tablicaFigur=new Figura*[ileFigur];

        int iteratorParametrow=2;
        int iteratorFigur=0;
        int start=0;

        for(int i=0;i<ileFigur;i++)
        {
            try
            {
                if(iteratorParametrow>argc-2)
                    throw iteratorParametrow;
                switch(argv[1][i])
		{
                    case 'o':
                        iteratorParametrow++;
                        double r;
			r=stod(argv[iteratorParametrow-1]);
                        if(r<=0)
                            throw r;
                        tablicaFigur[iteratorFigur]= new Okrag(r);
                        iteratorFigur++;
                        break;
                    case 'c':
                        start=iteratorParametrow;
                        double c[4];
                        for(int j=0;j<4;j++)
                        {
                            if(iteratorParametrow>argc-2)
                                throw iteratorParametrow;
                            iteratorParametrow++;
                            c[j]=stod(argv[iteratorParametrow-1]);
                            if(c[j]<=0)
                                throw c[j];
                        }
                        iteratorParametrow++;
                        double kat;
			kat=stod(argv[iteratorParametrow-1]);
                        if(kat<=0)
                            throw kat;
                        try
                        {
                            tablicaFigur[iteratorFigur]= new Kwadrat(c[0],c[1],c[2],c[3],kat);
                            iteratorFigur++;
                        }
                        catch(string w)
                        {
                            try
                            {
                                tablicaFigur[iteratorFigur]= new Prostokat(c[0],c[1],c[2],c[3],kat);
                                iteratorFigur++;
                            }
                            catch(string w)
                            {
                                try
                                {
                                    tablicaFigur[iteratorFigur]= new Romb(c[0],c[1],c[2],c[3],kat);
                                    iteratorFigur++;
                                }
                                catch(string w)
                                {
										cout<<"c: "<<c[0]<<" "<<c[1]<<" "<<c[2]<<" "<<c[3]<<" "<<kat<<" nie potrafie zrobic czworokata dla tych wartosci"<<endl;
                                }
                            }
                        }
                        break;
                    case 'p':
                        iteratorParametrow++;
                        double p;
			p=stod(argv[iteratorParametrow-1]);
                        if(p<=0)
                            throw p;
                        tablicaFigur[iteratorFigur]= new Pieciokat(p);
                        iteratorFigur++;
                        break;
                    case 's':
                        iteratorParametrow++;
                        double s;
			s=stod(argv[iteratorParametrow-1]);
                        if(s<=0)
                            throw s;
                        tablicaFigur[iteratorFigur]= new Szesciokat(s);
                        iteratorFigur++;
                        break;
                    default:
			throw (string)"Nie znam takiej figury";
		}
            }
            catch(double r)
            {
                if(argv[1][i]=='c')
                    iteratorParametrow=start+5;
                cout<<argv[1][i]<<": Parametry dla figur powinny byc wieksze od zera"<<endl;
            }
            catch(const invalid_argument& a)
            {
                if(argv[1][i]=='c')
                    iteratorParametrow=start+5;
                cout<<argv[1][i]<<": Podano niewlasciwy parametr dla argumentu"<<endl;
            }
            catch(int e)
            {
                cout<<"Podano za malo parametrow"<<endl;
            }
            catch(string w)
            {
                cout<<w<<endl;
            }
        }
        for(int i=0;i<iteratorFigur;i++)
			{
				cout<<tablicaFigur[i]->pokazParametry()<<" --- pole="<<tablicaFigur[i]->obliczPole()<<" a obwod="<<tablicaFigur[i]->obliczObwod()<<endl;
			}
        delete[] tablicaFigur;
    }
    catch(int a)
    {
        if(a==1)
        cout<<"Musisz wywolac program z argumentami wywolania"<<endl;
    }
    return 0;
}
