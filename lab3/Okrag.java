import static java.lang.Math.*;

class Okrag extends Figura{
	double promien;
	double obliczObwod(){
		return (2*Math.PI*promien);
	}
	double obliczPole(){
		return (Math.Pi*promien*promien);
	}
}