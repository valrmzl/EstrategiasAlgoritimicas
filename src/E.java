import java.util.Arrays;
import java.util.Scanner;

public class E {
	
	/*
	public static int cantidadFlechas(int n,String globos) {
		int flechas=1;
		for(int i=0;i<globos.length();i++) {
			if(i==globos.length()-1) return flechas;			
			if(globos.charAt(i)>globos.charAt(i+2)) {
				i++;
			}else {
				flechas++;
				i++;
			}
		}
		return flechas;
	}*/
	

	public static void main(String[] args) {
		Scanner n= new Scanner(System.in);
		int inputN= n.nextInt();
	
		
		
		
		Scanner g= new Scanner(System.in);
		String inputG= g.nextLine();
		String[] g1= inputG.split(" ");
		int[] globos= new int[inputN];
		for(int i=0;i<g1.length;i++) {
			globos[i]=Integer.parseInt(g1[i]);
		}
		
		//System.out.println(Arrays.toString(globos));
		
		
		int flechas=1;
		for(int i=0;i<inputN-1;i++) {
			if(globos[i] <= globos[i+1]) {
				flechas++;
			}
			
		}
		
		System.out.println(flechas);
		
		//System.out.println(flechas);
		
		//System.out.println(cantidadFlechas(inputN,inputG));


	}

}
