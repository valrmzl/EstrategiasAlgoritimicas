import java.util.Arrays;
import java.util.PriorityQueue;

public class AlgoritmosVeraces {
	
	static class Item implements Comparable<Item>{
		double value, wieght, vw;
		int index;
		public Item(double v, double w,int i) {
			this.value=v;
			this.wieght=w;
			this.vw=v/w;
			this.index=i;
		}
		@Override
		public int compareTo(Item item) {
			if(this.vw > item.vw) return -1;
			if(this.vw < item.vw) return  1;
			// if(this.value > item.value) return -1;
			// if(this.value < item.value) return  1; 
			// if(this.weight < item.weight) return -1;
			// if(this.weight > item.weight) return  1;
			return 0;
			
		}
	}
	//T(N) = O(N log N) + O(N log N) = O(N log N)
	
	
	
	
	//
	static double[] knapsack(double[] values, double[] weights, double W) {
		final int N= values.length;
		double[] factors= new double[N];
		
		PriorityQueue<Item> C= new PriorityQueue<>();
		for(int i=0;i<N;i++) {
			Item item= new Item(values[i],weights[i],i);
			C.offer(item);		
		}
		
		//LO QUE HE METIDO A LA MOCHILA
		double weight=0;
		while(weight<W) {
			Item item=C.poll();
			
			if(weight+item.wieght <= W) { //MENOR O IGUAL A LA CAPCIDAD DE LA MOCHILA, SI ES MENOR LO VAMOS A CONSIDERAR
				factors[item.index]=1.0;
				weight += item.wieght; //como si lo hubiera metido a la mochila
			}else{
				factors[item.index]=(W-weight)/item.wieght;
				weight=W;	
			}
		}
		return factors;
	}
	
	
	//funcion objetivo -->> se intereza maximizar 
	static double totalValue(double[]values, double[] factors) {
		double v=0;
		for(int i =0;i<values.length;i++) {
			v+=values[i]*factors[i];
		}
		return v;
	}
	
	//la solucion es factible??
	static boolean isValid(double[]weights, double[] factors,double W) {
		double w=0;
		for(int i=0;i<weights.length;i++) {
			w+=weights[i]*factors[i];
			if(w>W) return false;
		}
		
		return true;
		
	}
	
	
	//ejercicoo de las mondeas
	//devolver el numero minimo de moneas en D neesarias para lograra C
	//Para asegurar que hay solucion debe de haber mdeas de $1, para cuando el cambio es impar
	//pueden usarse muchas instancias de la misma denominación
	//dada la denominacion actual  (6,4,1)
	//descurbir si sirve o no considerarla 
	//manipuladno el cambio podems ir viendo que onda
	public static int change (int C, int [] D) {
		
		
		
		
		return 0;
	}
	
	//recibe el camnbio, el indice y las demoninaciones

	
	//devuelve la cantidad de monedad de esa demonicacion , a eso refiere el chage con esas condicones 
	public static int change(int C, int d, int[] D) {
		//caso base 
		//el cambio es 0
		if(C==0) return 0;
		//indice  d , DEVUELVO EL CAMBIO QUE QUEDA CON LAS DE 1 PESO
		if(d==0) return C;
		
		//el dato que yo represneto de que manera se usa, el dato actual
		
		//llamdas recursivas
		//la denominacin actual no nos sirve o se pasa del cambio
		if(C<D[d])
			return change(C,d-1,D);
		
		//la denominacion actual si nos puede servir pero tal vez no
		
		//simualicon de que si
		int res1= change(C,d-1,D);
		int res2= change(C-D[d],d-1,D);
		return 0;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double[] values = {20, 30, 66, 40, 60};
		double[] weights = {10, 20, 30, 40, 50};
		double[] factors = knapsack(values, weights, 100);
		System.out.println(Arrays.toString(factors));
		System.out.println(totalValue(values, factors));
		System.out.println(isValid(weights, factors, 100));
		/*
		//devolver monedas
		int cambio=9;
		int [] denominaciones= {1,4,6};
		System.out.println(change(cambio,denominaciones));*/

	}

}
