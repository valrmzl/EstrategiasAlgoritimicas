import java.util.Arrays;

public class Ejercicio1CountSort {
	
	
public static void countsort(char[] arry) {
		
		int[] conteo= new int[26];
		char[] ordenado=new char[arry.length];
		
		for(int i=0;i<arry.length;i++) {
			char valor=arry[i];
			conteo[valor-97]++;
		}
		//System.out.println("Arreglo de conteo: ");
		//System.out.println(Arrays.toString(conteo));
		
		//hacer la suma del arry de conteo
		//posoicones donde debe de aparecer la letra
		for(int i=0;i<conteo.length-1;i++)
			conteo[i+1]=conteo[i+1]+conteo[i];
		
		for(int i=1, j=arry.length-1;i<=arry.length;i++,j--) {
			char valor=arry[arry.length-i];
			//System.out.println(valor);
			ordenado[conteo[valor-97]-1]=valor;	
			//System.out.println(Arrays.toString(ordenado));
			conteo[valor-97]=conteo[valor-97]-1;
			//System.out.println(Arrays.toString(conteo));
		
		}

		for(int i=0;i<arry.length;i++) {
			arry[i]=ordenado[i];
			
		}
	
	}

	public static void main(String[] args) {
		
		System.out.println("Antes de ordenar: ");
		char[] arry1= {'z','h','b','a','d','c','f','a'};
		System.out.println(Arrays.toString(arry1));
		countsort(arry1);
		System.out.println("Despues de ordenar con Count");
		System.out.println(Arrays.toString(arry1));
		
		
		System.out.println();
		System.out.println("*****");
		System.out.println("Antes de ordenar: ");
		char[] arry2= {'f','a','a','z','z','e','f','h','j','w','x','i','m'};
		System.out.println(Arrays.toString(arry2));
		countsort(arry2);
		System.out.println("Despues de ordenar con Count");
		System.out.println(Arrays.toString(arry2));
	}

}
