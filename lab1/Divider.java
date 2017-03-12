public class Divider{
	public static int div(int n){
		if(n==1)
			return -1;
		else if(n==0)
			return 0;
		else if(n<0)
			return -2;
		else{
			for(int i=n-1; i>1; i--){
				if(n%i==0)
					return i;
			}
		}
		return 1;

	}
	public static void main(String[] args){

		for(int i=0; i<args.length; i++){
			try{
				int n=Integer.parseInt(args[i]);
				int divider=div(n);
				if(divider==-1)
					System.out.println(n+": Dla 1 nie potrafie znaleźć największego dzielnika właściwego");
				else if(divider==0)
					System.out.println(n+": Zero dzieli sie przez kazda liczbe naturalna rozna od zera!!!");
				else if(divider==-2)
					System.out.println(n+": Miales podac liczbe naturalna!!!");
				else
					System.out.println(n+": "+divider);
			}
			catch(NumberFormatException ex) {
				System.out.println(args[i]+" nie jest liczba calkowita");
			}
		}
	}
}
