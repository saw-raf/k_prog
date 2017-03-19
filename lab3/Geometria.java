class BrakArgumentow extends Exception {}
class BrakParametrow extends Exception {}
class NiezdefiniowanaFigura extends Exception {}
class KoniecProgramu extends Exception {}
class NiedodatniParametr extends Exception {}



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
							if(r<=0)
								throw new NiedodatniParametr();
							tablicaFigur[iteratorFigur]= new Okrag(r);
							iteratorFigur++;
							break;
						case 'c':
							start=iteratorParametrow;
							double[] c=new double[4];
							for(int j=0;j<4;j++){
								iteratorParametrow++;
								c[j]=Double.parseDouble(args[iteratorParametrow-1]);
								if(c[j]<=0)
									throw new NiedodatniParametr();
							}
							iteratorParametrow++;
							double kat=Double.parseDouble(args[iteratorParametrow-1]);
							if(kat<=0)
								throw new NiedodatniParametr();
							try{
								tablicaFigur[iteratorFigur]= new Kwadrat(c[0],c[1],c[2],c[3],kat);
								iteratorFigur++;
							}
							catch(NieKwadrat e){
								try{
									tablicaFigur[iteratorFigur]= new Prostokat(c[0],c[1],c[2],c[3],kat);
									iteratorFigur++;
								}
								catch(NieProstokat f){
									try{
										tablicaFigur[iteratorFigur]= new Romb(c[0],c[1],c[2],c[3],kat);
										iteratorFigur++;
									}
									catch(NieRomb g)
									{
										System.out.println("c: "+c[0]+" "+c[1]+" "+c[2]+" "+c[3]+" "+kat+" nie potrafie zrobic czworokata dla tych wartosci");
									}
								}
							}
							break;
						case 'p':
							iteratorParametrow++;
							double p=Double.parseDouble(args[iteratorParametrow-1]);
							if(p<=0)
								throw new NiedodatniParametr();
							tablicaFigur[iteratorFigur]= new Pieciokat(p);
							iteratorFigur++;
							break;
						case 's':
							iteratorParametrow++;
							double s=Double.parseDouble(args[iteratorParametrow-1]);
							if(s<=0)
								throw new NiedodatniParametr();
							tablicaFigur[iteratorFigur]= new Szesciokat(s);
							iteratorFigur++;
							break;
						default:
							throw new NiezdefiniowanaFigura();
					}
				}
				catch(NiedodatniParametr a){
					if(args[0].charAt(i)=='c')
						iteratorParametrow=start+5;
					System.out.println(args[0].charAt(i)+": Parametry dla figury powinny byc wieksze od zera!!!");
				}
				catch(NumberFormatException e){
					if(args[0].charAt(i)=='c')
						iteratorParametrow=start+5;
					System.out.println(args[0].charAt(i)+": Podano niewlasciwy parametr dla argumentu.");

				}
				catch(ArrayIndexOutOfBoundsException e){
					System.out.println(args[0].charAt(i)+": podano za malo parametrow");
				}
				catch(NiezdefiniowanaFigura e){
					System.out.println(args[0].charAt(i)+": nie znam takiej figury");
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
				System.out.println(tablicaFigur[i].pokazParametry()+" --- Dla figury "+s+" pole="+tablicaFigur[i].obliczPole()+" a obwod="+tablicaFigur[i].obliczObwod());
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
