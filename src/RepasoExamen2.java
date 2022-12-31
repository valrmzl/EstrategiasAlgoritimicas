import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class RepasoExamen2 {
	
	
	
	public static void countsort(char[] arry) {
		
		int[] conteo= new int[26];
		char[] ordenado=new char[arry.length];
		
		for(int i=0;i<arry.length;i++) {
			char valor=arry[i];
			conteo[valor-97]++;
		}
		
		//hacer la suma del arry de conteo
		//posoicones donde debe de aparecer la letra
		for(int i=0;i<conteo.length-1;i++)
			conteo[i+1]=conteo[i+1]+conteo[i];
		
		for(int i=1, j=arry.length-1;i<=arry.length;i++,j--) {
			char valor=arry[arry.length-i];
			ordenado[conteo[valor-97]-1]=valor;	
			conteo[valor-97]=conteo[valor-97]-1;	
		}
		System.out.println(Arrays.toString(ordenado));
		
		/*
		
		System.out.println("arreglo que queriamos ordenar:");
		System.out.println(Arrays.toString(arry));
		arry=ordenado.clone();
		System.out.println("arreglado terminado: ");
		System.out.println(Arrays.toString(arry));
		*/
		
		
	}
	
	public static void radixsort(double[] array, int decimals) {
		
		
	}
	
	
	
	public static void countsort(int[] arry) {
		int[] conteo= new int[4];
		int[] ordenado=new int[arry.length];
		
		for(int i=0;i<arry.length;i++) {
			int valor=arry[i];
			conteo[valor-1]++;
		}
		System.out.println(Arrays.toString(conteo));
		for(int i=0;i<conteo.length-1;i++) {
			conteo[i+1]=conteo[i+1]+conteo[i];
		}
		
		System.out.println(Arrays.toString(conteo));
		System.out.println("***");
		System.out.println(Arrays.toString(arry));
		
		
		for(int i=1, j=arry.length-1;i<=arry.length;i++,j--) {
			int valor=arry[arry.length-i];
			System.out.println(valor);
			int value=valor;
			System.out.println(value);
			ordenado[conteo[valor-1]-1]=valor;
			System.out.println(Arrays.toString(ordenado));
			conteo[valor-1]=conteo[valor-1]-1;
			System.out.println(Arrays.toString(conteo));
		
			
		}
		System.out.println("arreglo que queriamos ordenar:");
		System.out.println(Arrays.toString(arry));
		arry=ordenado.clone();
		System.out.println("arreglado terminado: ");
		System.out.println(Arrays.toString(arry));
	}
	
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
            
            	System.out.println(buckets[i].peek());
        		arry[index] = buckets[i].poll();
        		index++;     
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
		
		/*
		int[] arry= {4,2,4,2,3,1};
		int[] arry1= {1,1,1,2,3,3,1,2,4,4,4};
		countsort(arry);
		System.out.println("**");
		countsort(arry1);
		*/
		/*
		char[] arry= {'z','h','b','a','d','c','f','a'};
		countsort(arry);*/
		
		/*
		double[] arry= {14.15,3,15678,583.3,2123.34,0.563,0.561};
		radixsort(arry,2);*/
		
	}

}
