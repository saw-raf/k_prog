class NieKwadrat extends Exception {}

class Kwadrat extends Czworokat{
	
	Kwadrat(double a, double b, double c, double d, double k) throws NieKwadrat{ 
		if(kat!=90 || a!=b || b!=c || c!=d)
			throw new NieKwadrat();
		kat=90.0;
		bok1=bok2=bok3=bok4=a;
			
	}
	double obliczObwod(){
		return (4*bok1);
	}
	double obliczPole(){
		return bok1*bok1;
	}

}