class NieProstokat extends Exception {}

class Prostokat extends Czworokat{
	
	Prostokat(double a, double b, double c, double d, double k) throws NieProstokat{
		
		if(k!=90.0)
			throw new NieProstokat();
		
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
			throw new NieProstokat();
		
	}
	
	double obliczObwod(){
		return (2*bok1+2*bok2);
	}
	
	double obliczPole(){
		return bok1*bok2;
	}
}