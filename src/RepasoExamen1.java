import java.util.HashSet;
import java.util.Set;

public class RepasoExamen1 {
	
	static int sum(int N) {
		return N +sum(N/2);
	}
	
	public static int countInCommon(String[] w1, String[] w2) {
		int comun=0;
		Set<String> set= new HashSet<>();
		for(String s:w1) {
			set.add(s);
		}
		
		for(String s:w2) {
			if(!(set.add(s))) {
				comun++;
			}
		}
		
		return comun;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] w1= {"hola","val","poo","jose","pepe"};
		String[] w2= {"hola","val","poo","jose","pepe","pepe","mar","a"};
		System.out.println(countInCommon(w1,w2));

	}

}
