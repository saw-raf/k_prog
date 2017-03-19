class BrakArgumentow extends Exception {}
class BrakParametrow extends Exception {}
class NiezdefiniowanaFigura extends Exception {}
class KoniecProgramu extends Exception {}



public class Geometria{
	
	
	
	public static void main(String[] args){
		try{
			if(args.length==0)
				throw new BrakArgumentow();
			
			int ileFigur=args[0].length();
			
			Figura[] tablicaFigur= new Figura[ileFigur];
			
			int iteratorParametrow=1;
			int iteratorFigur=0;
			int start=0;
			
			for(int i=0;i<ileFigur;i++){
				
				try{
					switch(args[0].charAt(i)){
						case 'o':
							iteratorParametrow++;
							double r=Double.parseDouble(args[iteratorParametrow-1]);
							tablicaFigur[iteratorFigur]= new Okrag(r);
							iteratorFigur++;
							break;
						case 'c':
							start=iteratorParametrow;
							double[] c=new double[4];
							for(int j=0;j<4;j++){
								iteratorParametrow++;
								c[j]=Double.parseDouble(args[iteratorParametrow-1]);
							}
							double kat=Double.parseDouble(args[iteratorParametrow]);
							try{
								tablicaFigur[iteratorFigur]= new Kwadrat(c[0],c[1],c[2],c[3],kat);
								iteratorParametrow++;
								iteratorFigur++;
							}
							catch(NieKwadrat e){
								try{
									tablicaFigur[iteratorFigur]= new Prostokat(c[0],c[1],c[2],c[3],kat);
									iteratorParametrow++;
									iteratorFigur++;
								}
								catch(NieProstokat f){
									try{
										tablicaFigur[iteratorFigur]= new Romb(c[0],c[1],c[2],c[3],kat);
										iteratorParametrow++;
										iteratorFigur++;
									}
									catch(NieRomb g)
									{
										System.out.println("Nie potrafie zrobic czworokata dla: "+c[0]+" "+c[1]+" "+c[2]+" "+c[3]+" "+kat);
									}
								}
							}
							break;
						case 'p':
							iteratorParametrow++;
							double p=Double.parseDouble(args[iteratorParametrow-1]);
							tablicaFigur[iteratorFigur]= new Pieciokat(p);
							iteratorFigur++;
							break;
						case 's':
							iteratorParametrow++;
							double s=Double.parseDouble(args[iteratorParametrow-1]);
							tablicaFigur[iteratorParametrow]= new Szesciokat(s);
							iteratorFigur++;
							break;
						default:
							throw new NiezdefiniowanaFigura();
					}
				}
				catch(NumberFormatException e){
					if(args[0].charAt(i)=='c')
						iteratorParametrow=start+5;
	
					System.out.println("Podano niewlasciwy parametr dla argumentu: "+args[0].charAt(i));

				}
				catch(ArrayIndexOutOfBoundsException e){
					System.out.println("Dla: \""+args[0].charAt(i)+"\" podano za malo parametrow");
				}
				catch(NiezdefiniowanaFigura e){
					System.out.println("Nie zdefiniowano zachowania dla: "+args[0].charAt(i));
				}
			}
			for(int i=0;i<iteratorFigur;i++)
			{
				String s="";
				if(tablicaFigur[i] instanceof Okrag)
					s="Okrag";
				else if(tablicaFigur[i] instanceof Pieciokat)
					s="Pieciokat";
				else if(tablicaFigur[i] instanceof Szesciokat)
					s="Szesciokat";
				else if(tablicaFigur[i] instanceof Kwadrat)
					s="Kwadrat";
				else if (tablicaFigur[i] instanceof Prostokat)
					s="Prostokat";
				else if(tablicaFigur[i] instanceof Romb)
					s="Romb";
				System.out.println("");
				System.out.println("Dla figury "+s+" \""+tablicaFigur[i].pokazParametry()+"\" pole to: "+tablicaFigur[i].obliczPole()+" a obwod to: "+tablicaFigur[i].obliczObwod());
			}
		}
		catch(BrakArgumentow e){
			System.out.println("Musisz wywolac program z argumentami wywolania");
			System.out.println("o - okrag");
			System.out.println("c - czworokat");
			System.out.println("p - pieciokat");
			System.out.println("s - szesciokat");
		}
		/*catch(KoniecProgramu e){
			System.out.println("Koniec Programu");
		}*/
	}
}