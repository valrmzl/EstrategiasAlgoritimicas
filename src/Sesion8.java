import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Sesion8 {
	
	static boolean hasDuplicatesSort(String[] strArray) {
		
		
		Arrays.sort(strArray); //el costo del sort es 0(NLOGN)
		System.out.println(Arrays.toString(strArray));
		
		//la suma de los pasos es el costo total
		//S (N) =O(1), El espacio es constante, no creo más
		
		// tiene que acabar en n-1, como pa comparando por parejas, si no va a tronar
		for(int i=0;i<strArray.length-1;i++) {  //0(N) el peor de los casos es lienal
			if(strArray[i].equals(strArray[i+1])) return true; //costo constante
		}
		
		return false;  // T(N) = O (N LOG N) + O(N) = O (N LOG N)
		//para que fuera N , necesitariamos memoria extra 
	}
	
	
	//T(N) = O(N)
	//S(N) = O(N)
	static boolean hasDuplicates(String[] strArray) {
		Set<String>set = new HashSet<>();
		for(String s:strArray) {
			if(!set.add(s)) return  true;		
			}
		
		return false;
	}
	
	public static void main(String []args) {
		String[] array1 = {"public","sttaic","void","main","string",
				"args","boolean","import","console","declaration","class",
				"static"};
		
		System.out.println(hasDuplicates(array1));
		
	}

}
