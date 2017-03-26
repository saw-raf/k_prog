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
		try{
			if(args.length==0)
				throw new BrakArgumentow();
			
			int ileFigur=args[0].length();
			
			int iteratorParametrow=1;
			int start=0;
			
			for(int i=0;i<ileFigur;i++){
				System.out.println("");
				try{
					switch(args[0].charAt(i)){
						case 'o':
							K1 figuraO;
							iteratorParametrow++;
							double r=Double.parseDouble(args[iteratorParametrow-1]);
							if(r<=0)
								throw new NiedodatniParametr();
							figuraO=Figura.K1.OKRAG;
							figuraO.parametr=r;
							System.out.println("o: "+r+" pole: "+figuraO.obliczPole()+" obwod: "+figuraO.obliczObwod());
							break;
						case 'k':
							K1 figuraK;
							iteratorParametrow++;
							double bok=Double.parseDouble(args[iteratorParametrow-1]);
							if(bok<=0)
								throw new NiedodatniParametr();
							figuraK=Figura.K1.KWADRAT;
							figuraK.parametr=bok;
							System.out.println("k: "+bok+" pole: "+figuraK.obliczPole()+" obwod: "+figuraK.obliczObwod());
							break;
						case 'P':
							K1 figuraP;
							iteratorParametrow++;
							double p=Double.parseDouble(args[iteratorParametrow-1]);
							if(p<=0)
								throw new NiedodatniParametr();
							figuraP=Figura.K1.PIECIOKAT;
							figuraP.parametr=p;
							System.out.println("P: "+p+" pole: "+figuraP.obliczPole()+" obwod: "+figuraP.obliczObwod());
							break;
						case 's':
							K1 figuraS;
							iteratorParametrow++;
							double s=Double.parseDouble(args[iteratorParametrow-1]);
							if(s<=0)
								throw new NiedodatniParametr();
							figuraS=Figura.K1.SZESCIOKAT;
							figuraS.parametr=s;
							System.out.println("s: "+s+" pole: "+figuraS.obliczPole()+" obwod: "+figuraS.obliczObwod());
							break;
						case 'p':
							K2 figura2P;
							start=iteratorParametrow;
							iteratorParametrow++;
							double bok1=Double.parseDouble(args[iteratorParametrow-1]);
							iteratorParametrow++;
							double bok2=Double.parseDouble(args[iteratorParametrow-1]);
							if(bok1<=0 || bok2<=0)
								throw new NiedodatniParametr();
							figura2P=Figura.K2.PROSTOKAT;
							figura2P.parametr=bok1;
							figura2P.parametr2=bok2;
							System.out.println("p: "+bok1+" "+bok2+" pole: "+figura2P.obliczPole()+" obwod: "+figura2P.obliczObwod());
							break;
						case 'r':
							K2 figura2R;
							start=iteratorParametrow;
							iteratorParametrow++;
							double bok3=Double.parseDouble(args[iteratorParametrow-1]);
							iteratorParametrow++;
							double kat=Double.parseDouble(args[iteratorParametrow-1]);
							if(bok3<=0 || kat<=0)
								throw new NiedodatniParametr();
							figura2R=Figura.K2.ROMB;
							figura2R.parametr=bok3;
							figura2R.parametr2=kat;
							System.out.println("r: "+bok3+" "+kat+" pole: "+figura2R.obliczPole()+" obwod: "+figura2R.obliczObwod());
							break;
						default:
							throw new NiezdefiniowanaFigura();
					}
				}
				catch(NiedodatniParametr a){
					if(args[0].charAt(i)=='p' || args[0].charAt(i)=='r')
						iteratorParametrow=start+2;
					System.out.println(args[0].charAt(i)+": Parametry dla figury powinny byc wieksze od zera!!!");
				}
				catch(NumberFormatException e){
					if(args[0].charAt(i)=='c')
						iteratorParametrow=start+2;
					System.out.println(args[0].charAt(i)+": Podano niewlasciwy parametr dla argumentu.");

				}
				catch(ArrayIndexOutOfBoundsException e){
					System.out.println(args[0].charAt(i)+": podano za malo parametrow");
				}
				catch(NiezdefiniowanaFigura e){
					System.out.println(args[0].charAt(i)+": nie znam takiej figury");
				}
			}
			
		}
		catch(BrakArgumentow e){
			System.out.println("Musisz wywolac program z argumentami wywolania");
			System.out.println("o - okrag");
			System.out.println("c - czworokat");
			System.out.println("p - pieciokat");
			System.out.println("s - szesciokat");
		}
	}
}