import static java.lang.Math.*;

class Szesciokat extends Figura{
	double bok;
	Szesciokat(double a){ bok=a; }
	double obliczObwod(){
		return (6*bok);
	}
	double obliczPole(){
		return 6*bok*bok*Math.sqrt(3)/4;
	}
	String pokazParametry()
	{
		return ("s "+bok);
	}
}