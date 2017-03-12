
public class WierszTrojkataPascala{

	private int rozmiar;
	private int wiersz[];

	public WierszTrojkataPascala(int n){
		rozmiar=n+1;
		wiersz=new int[rozmiar];
		wiersz[0]=1;
		for(int i=1;i<rozmiar;i++)
			wiersz[i]=wiersz[i-1]*(n-(i-1))/i;//property C(n,k+1)=C(n,k)*(n-k)/(k+1)

	}

	public int wspolczynnik(int m) throws ArrayIndexOutOfBoundsException{
		if(m>=rozmiar || m<0)
			throw new ArrayIndexOutOfBoundsException();	
		return wiersz[m];
	}
}
