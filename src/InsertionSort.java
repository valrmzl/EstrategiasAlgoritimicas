import java.util.Arrays;

public class InsertionSort {
	
	
	public static int rand(int min, int max) {
		
		return min+ (int)((max-min+1)*Math.random());
	}
	
	
	public static int[] createArray(int N, int min, int max) {
		int[] array=new int[N];
		for(int i=0;i<N;i++)
			array[i]=rand(min,max);
		return array;
		
	}
	
	public static int[] invertedArray(int N, int max) {
		int []array = new int[N];
		array[0]=max;
		for(int i=1; i<N;i++) {
			array[i]=array[i-1]-rand(1,10);
		}
		
		return array;
	}
	public static boolean isSorted(int[] array) {
		for(int i=0;i<array.length-1;i++) {
			if(array[i]>array[i+1]) return false;
		}
		return true; //peor caso, n-1 comparaciones
	}
	
	
	static long moves, cmps;
	static boolean lessThan(int a, int b) {
		cmps++;
		return a<b;
		
	}
	
	
	public static void insertion(int[] array) {
		moves=0;
		final int N= array.length;
		for(int p=1; p<N; p++) {
			int pivot=array[p];               	moves++;
			int i=p-1;
			
			//el while anterior era while(i>=0 && pivot<array[i]
			while(i>=0 && lessThan(pivot, array[i])) { //mientras la persona que estaba en el pivote sea mas chaparrito del que esta en frente
				array[i+1]=array[i];
												moves++;
				i--;
				
			}
			array[i+1]=pivot;
			System.out.println(Arrays.toString(array));
												moves++;
			
		}
		
		
	}
	
	public static void main2(String[] args) {
		System.out.println("hola");
		
	}

	public static void main(String[] args) {
		System.out.println("Insertion Sort");
		int[] array= {8,7,1,3,2,4,5,1};
		System.out.println(Arrays.toString(array));
		insertion(array);
		System.out.println("**");
		System.out.println(Arrays.toString(array));
		/*
		System.out.println("");
		int[] array= {5,2,7,3,1,8,4,6,0,9};
		System.out.println(isSorted(array));
		System.out.println(Arrays.toString(array));
		insertion(array);
		System.out.println("");
		System.out.println(Arrays.toString(array));
		System.out.println(isSorted(array));
		*/
		/*
		final int N=3;
		int array[]=createArray(N,1,N);
		System.out.println(isSorted(array));
		System.out.println(Arrays.toString(array));
		insertion(array);
		System.out.println(isSorted(array));
		System.out.println(Arrays.toString(array));
		System.out.printf("Moves: %d /n Cmps: %d",moves,cmps);*/
		/*
		long start=System.currentTimeMillis();
		insertion(array);
		long end=System.currentTimeMillis();
		System.out.println(isSorted(array));
		long millis=end-start;
		double seconds=millis/1000.0;
		System.out.printf("Duración (segundos) %.2f",seconds);
		//System.out.println(Arrays.toString(array));
		 * */
		 

	}

}
