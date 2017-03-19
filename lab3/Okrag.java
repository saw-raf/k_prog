import static java.lang.Math.*;

class Okrag extends Figura{
	
	private double promien;
	
	Okrag(double r){ promien=r; }
	
	double obliczObwod(){
		return (2*Math.PI*promien);
	}
	
	double obliczPole(){
		return (Math.PI*promien*promien);
	}
	
	String pokazParametry()
	{
		return ("o: "+promien);
	}
}