class NieRomb extends Exception {}

class Romb extends Czworokat{
	Romb(double a, double b, double c, double d, double k) throws NieRomb{
		
		if(k>=180 || a!=b || b!=c || c!=d)
			throw new NieRomb();
		kat=k;
		bok1=bok2=bok3=bok4=a;
	}
	
	double obliczObwod(){
		return (4*bok1);
	}
	
	double obliczPole(){
		return bok1*bok1*Math.sin(Math.toRadians(kat));
	}
	
}