public class Divider{
	public static int div(int n){
		if(n==1)
			return -1;
		else if(n==0)
			return 0;
		else{
			int max=1;
			for(int i=2; i*i<=n; i++){
				if(n%i==0 && max < (n/i))
					max=(n/i);
			}
			return max;
		}
	}
	public static void main(String[] args){

		for(int i=0; i<args.length; i++){
			try{
				int n=Integer.parseInt(args[i]);
				int divider=div(n);
				if(divider==-1)
					System.out.println("Dla 1 nie potrafie znaleźć największego dzielnika właściwego");
				else if(divider==0)
					System.out.println("Zero dzieli sie przez kazda liczbe naturalna rozna od zera!!!");
				else
					System.out.println(divider);
			}
			catch(NumberFormatException ex) {
				System.out.println(args[i]+" nie jest liczba calkowita");
			}
		}
	}
}
