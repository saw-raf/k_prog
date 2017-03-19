import static java.lang.Math.*;

class Pieciokat extends Figura{
	
	private double bok;
	
	Pieciokat(double a){ bok=a; }
	
	double obliczObwod(){
		return (5*bok);
	}
	
	double obliczPole(){
		return (bok*bok)*Math.sqrt(5*(5+2*Math.sqrt(5)))/4;
	}
	
	String pokazParametry()
	{
		return ("p: "+bok);
	}
}