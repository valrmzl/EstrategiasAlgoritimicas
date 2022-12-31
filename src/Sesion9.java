import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Sesion9 {
	
	//costo del algoritmo
	
	public static int mode(int[] arry) {
		Map<Integer,Integer> map= new HashMap<>();
		int mode=arry[0];
		int maxF=1;
		for(int x:arry) {
			if(!map.containsKey(x)) {
				map.put(x,1);
				
			}else {
				int f=map.get(x)+1;
				map.put(x,f);
				if(f>maxF) {
					maxF=f;
					mode=x;
				}
			}
		}
			
		return mode;
	}
	
	//cola de prioridad
	public static void pqSort(String[] strArry) {
		PriorityQueue<String> cola= new PriorityQueue<>();
		for(String s:strArry) { // N x 
			cola.offer(s);  //max log n
		}
		
		
		for(int i=0;i<strArry.length;i++) { //N X
			strArry[i]=cola.poll();  //0(LOG N)
		}
		
		
		
	}
	
	public static void main(String[] args) {
		String[] words= {"public","static","void","main",
				"string","args","run","window","project","search"};
		pqSort(words);
		System.out.println(Arrays.toString(words));
		
	}

}
