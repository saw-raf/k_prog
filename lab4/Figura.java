import static java.lang.Math.*;

class BrakArgumentow extends Exception {}
class BrakParametrow extends Exception {}
class NiezdefiniowanaFigura extends Exception {}
class KoniecProgramu extends Exception {}
class NiedodatniParametr extends Exception {}


public class Figura{
	public enum K1{
		OKRAG(1), KWADRAT(1), PIECIOKAT(1), SZESCIOKAT(1);
		
		private double parametr;
		
		K1(double parametr){
			this.parametr=parametr;
		}
		double obliczObwod(){
			
			switch(this){
				
				case OKRAG:
					return (2*Math.PI*parametr);
					
				case KWADRAT:
					return 4*parametr;
					
				case PIECIOKAT:
					return 5*parametr;
					
				case SZESCIOKAT:
					return 6*parametr;
			}
			
			return -1;
		}
		
		double obliczPole(){
			
			switch(this){
				
				case OKRAG:
					return (Math.PI*parametr*parametr);
					
				case KWADRAT:
					return parametr*parametr;
					
				case PIECIOKAT:
					return (parametr*parametr)*Math.sqrt(5*(5+2*Math.sqrt(5)))/4;
					
				case SZESCIOKAT:
					return 6*parametr*parametr*Math.sqrt(3)/4;
			}
			
		return -1;
		}
	}
	
	public enum K2{
		PROSTOKAT(1,1),ROMB(1,1);
		
		private double parametr;
		private double parametr2;
		
		K2(double parametr, double parametr2){
			this.parametr=parametr;
			this.parametr2=parametr2;
		}
		double obliczObwod(){
			
			switch(this){
				
				case PROSTOKAT:
					return (2*(parametr+parametr2));
					
				case ROMB:
					return 4*parametr;
			}
			
			return -1;
		}
		
		double obliczPole(){
			
			switch(this){
				
				case PROSTOKAT:
					return (parametr*parametr2);
					
				case ROMB:
					return parametr*parametr*Math.sin(Math.toRadians(parametr2));	
			}
			
		return -1;
		}
		
	}
	
	public static void main(String[] args){
		K1 figura=Figura.K1.KWADRAT;
		K1 figura2=Figura.K1.KWADRAT;
		figura.parametr=2;
		figura2.parametr=3;
		System.out.println(figura.obliczPole());
		System.out.println(figura2.obliczPole());
	}
}