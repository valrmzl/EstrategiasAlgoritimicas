import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class S7Parte2 {
	
	public static void main(String[] args){
		//control shift 7b
		//get con linked list no es buena idea, tarda mucho tiempo 
		//si quiero recorrer un linkedlist no usar gte, una solcuion es for each, me entrega el
		//siguiente en tiempo constante
		//un get en el arraylist es constante 
		
		final int N = 200_000;
		long start, end;
		double avg1=0, avg2=0;
		List<Double> aList= new ArrayList<>();
		List<Double> lList= new LinkedList<>();
		
		start= System.currentTimeMillis();
		for(int i=0; i<N; i++)
			aList.add(i+Math.random());
		
		end=System.currentTimeMillis();
		System.out.printf("Llenar ArrayList: %.2f\n", (end-start)/1000.0);
		System.out.println("----");
		
		start= System.currentTimeMillis();
		for(int i=0; i<N; i++)
			lList.add(i+Math.random());
		
		end=System.currentTimeMillis();
		System.out.printf("Llenar LinkedList: %.2f\n", (end-start)/1000.0);
		
	
		
		
		
		
	}

}
