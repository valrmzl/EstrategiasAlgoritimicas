
public class nov8 {
	
	static long BC_rec(int n, int k) {
		if(k==0 || k==n) return 1;
		return BC_rec(n-1,k-1) + BC_rec(n-1,k);
	}
	
	
	
	static long BD_td(int n, int k, long [][]cache) {
		if(k==0 || k==n) return 1;
		if(cache[n][k]>0) return cache[n][k];
		cache[n][k]=BD_td(n-1,k-1,cache) + BD_td(n-1,k,cache);
		return cache[n][k];
	}
	//version top down
	static long BD_td(int n, int k) {
		//matriz de las respuestas parciales
		long [][] cache = new long [n+1][k+1]; // el 1 es para aprocechar el mapeo diecto
		
		return BD_td(n,k,cache);
	}
	
	public static void main(String [] args) {
		System.out.println(BD_td(4,3));
		
	}

}
