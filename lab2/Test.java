public class Test{
	public static void main(String[] args){
		try{
			int rozmiar=Integer.parseInt(args[0]);
			if(rozmiar<0)
				throw new NegativeArraySizeException();
			if(args.length<2)
				throw new ArrayIndexOutOfBoundsException();
			WierszTrojkataPascala wiersz=new WierszTrojkataPascala(rozmiar);
			for(int i=1;i<args.length;i++){
				try{
					int wspolczynnik=Integer.parseInt(args[i]);
					System.out.println(args[i]+": "+wiersz.wspolczynnik(wspolczynnik));
				}
				catch (NumberFormatException a){
					System.out.println("\""+args[i]+"\""+" nie jest liczba");		
				}
				catch (ArrayIndexOutOfBoundsException b){
					System.out.println(args[i]+": Wyszedles poza zakres");			
				}
			}
						
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Podaj numer wiersza oraz numer wspolczynnika");		
		}
		catch (NegativeArraySizeException a){
			System.out.println(args[0]+": nieprawidłowy numer wiersza");	
		}
		catch (NumberFormatException e){
			System.out.println("\""+args[0]+"\""+" nie jest liczba");		
		}
	}
}
