import java.util.Arrays;
import java.util.PriorityQueue;

public class Ejercicio3 {
	
	
	public static double findMin(double[] arry) {
		double min=arry[0];
		for(int i=1;i<arry.length;i++) {
			if(arry[i]<min)
				min=arry[i];
		}
		min=Math.floor(min);
		return min;
	}
	
	private static double findMax(double[] arry) {
		double max=arry[0];
		for(int i=1;i<arry.length;i++) {
			if(arry[i]>max)
				max=arry[i];
		}
		max=Math.ceil(max);
		return max;
	}
	
	private static int findBucket(double x, double min, double max, int n) {
		
		double rango = ((max-min)/n);
		int bucket= (int)(x/rango);
		return bucket;

	}
	
public static void bucketsort(double [] arry) {
		
		int n=arry.length;

		double min=findMin(arry);
		double max=findMax(arry);
		
		for(int i=0;i<n;i++) {
			System.out.printf("El valor: "+arry[i]+" se va a ir al bucket: "+findBucket(arry[i],min,max,n)+"  \n");
		}
				
		//crear las colas vacias
		PriorityQueue<Double>[] buckets= new PriorityQueue[n];
		for(int i=0;i<n;i++) {
			buckets[i]= new PriorityQueue<Double>();
		}
		
		System.out.println(Arrays.toString(buckets));

		//agregar segun el bucket correspondiente
		for(int i=0;i<n;i++) {
			buckets[findBucket(arry[i],min,max,n)].add(arry[i]);
		}
		
		System.out.println(Arrays.toString(buckets));
		
		int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
            	while(!buckets[i].isEmpty()) {
            		System.out.println(buckets[i].peek());
            		arry[index] = buckets[i].poll();
            		index++; 	
            	}
            	    
            }
        }
        //System.out.println("Termino");
        //System.out.println(Arrays.toString(arry));
	}

	public static void main(String[] args) {
		double[] a= {0.78,0.17,0.39,0.26,0.72,0.94,0.21,0.12,0.23,0.68};
		System.out.println("Arreglo a:");
		System.out.println(Arrays.toString(a));
		System.out.println("Arreglo a con BucketSort:");
		bucketsort(a);
		System.out.println(Arrays.toString(a));
		
		System.out.println();
		System.out.println("***");
		double[]b= {3.33,1.49,4.90,1.13,0.50,2.61,3.45,1.40,4.20,1.40};
		System.out.println("Arreglo b:");
		System.out.println(Arrays.toString(b));
		System.out.println("Arreglo a con BucketSort:");
		bucketsort(b);
		System.out.println(Arrays.toString(b));

	}

}
